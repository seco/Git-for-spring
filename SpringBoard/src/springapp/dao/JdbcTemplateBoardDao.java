package springapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JdbcTemplateBoardDao {
	
	private JdbcTemplate jdbcTemplate;
	
	//DB�� ������ �غ�
	public void setJdbcTemplate(JdbcTemplate temp){
		jdbcTemplate = temp;
	}
	
	public int count() throws Exception {
		//������ ������� ���������� ����
		return jdbcTemplate.queryForInt("select count(*) from board");
	}
	
	//��ü����
	public List list(int start, int end, String keyField, String keyWord){
		List result = new ArrayList();
		String sql = "";
		
		//�˻� ������ Ȯ�� �� ���� ���� ���ǹ�
		if(keyWord==null||keyWord==""){
			sql = " select * from(select rownum numrow, aa.* from " +
			      " (select * from board order by groups desc, levels asc) aa ) " +
			      " where numrow between ? and ?";
		} else {
			sql = " select * from(select rownum numrow, aa.* from " +
			      " (select * from board where " + keyField + " like '%" + keyWord + "%' " +
			      " order by groups desc, levels asc) aa ) " +
			      " where numrow between ? and ?";
		}
		Object[] values = new Object[] {
				new Integer(start),
				new Integer(end)
		};
		
		//���ڵ带 �����ؼ� �������ִ� Ŭ����
		RowMapper mapper = new RowMapper() {

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardVo vo = new BoardVo();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setRegdate(rs.getString("regdate").substring(0,10));
				vo.setHit(rs.getInt("hit"));
				vo.setPassword(rs.getString("password"));
				vo.setGroups(rs.getInt("groups"));
				vo.setLevels(rs.getInt("levels"));
				vo.setStep(rs.getInt("step"));
				return vo;
			}
			
		};
		result = jdbcTemplate.query(sql, values, mapper);
		return result;
	}

	//�󼼺���
	public BoardVo findBySeq(String seq){
		upCount(Integer.parseInt(seq));
		BoardVo result = null;
		String sql = "select * from board where seq=?";
		Object[] values = new Object[]{seq};
		RowMapper mapper = new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardVo vo = new BoardVo();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setRegdate(rs.getString("regdate").substring(0, 10));
				vo.setHit(rs.getInt("hit"));
				vo.setPassword(rs.getString("password"));
				vo.setGroups(rs.getInt("groups"));
				vo.setLevels(rs.getInt("levels"));
				vo.setStep(rs.getInt("step"));
				return vo;
			}
		};
		result = (BoardVo)jdbcTemplate.queryForObject(sql, values, mapper);
		return result;
	}
	
	//�� �����ϱ�
	public void update(BoardVo vo){
		String sql = "Update board set title=?, content=? where seq=?";
		Object[] values = new Object[]{vo.getTitle(), vo.getContent(), vo.getSeq()};
		jdbcTemplate.update(sql, values);
	}
	
	//�� ����ϱ�
	public void insert(BoardVo vo){
		int num = vo.getSeq();
		int groups = vo.getGroups();
		int step = vo.getStep();
		int levels = vo.getLevels();
		int number = 0;
		
		String sql = "";
		Object[] values = null;
		
		int temp = jdbcTemplate.queryForInt("select max(seq) from board");
		
		//�Խñ��� ���� �� ���� number�� ���� ���ǹ�
		if(temp!=0){
			number = temp + 1;			
		} else {
			number = 1;
		}
		
		//�Խñ� Ȯ�� ������ ���� ���ǹ�
		if(num!=0){
			sql = "update board set levels = levels + 1 where groups = ? and step > ?";
			values = new Object[]{groups, step};
			jdbcTemplate.update(sql, values);
			
			//�� ������ ���� ������� �θ������ Ȯ���� groups �� ������ ���� ���ǹ�
			if(groups==0){
				groups=num;
			} else {
				
			}
			step = step + 1;
			levels = levels + 1;
		} else {
			groups = number;
			step = 0;
			levels = 0;
		}
		
		//�ۼ��� ���� �θ��, ����� �� ���� ���Ǻ���
		if(step==0){
			sql = "insert into board(seq, title, content, writer, regdate, hit, password, groups, levels, step) " +
			      " values(board_seq.nextval, ?, ?, ?, to_char(sysdate,'YYYY/MM/DD'), ?, ?, board_seq.nextval, ?, ?)";
			values = new Object[]{vo.getTitle(), vo.getContent(), vo.getWriter(), vo.getHit(), vo.getPassword(), levels, step};
		} else {
			sql = "insert into board(seq, title, content, writer, regdate, hit, password, groups, levels, step)" +
			      " values(board_seq.nextval, ?, ?, ?, to_char(sysdate, 'YYYY/MM/DD'), ?, ?, ?, ?, ?)";
			values = new Object[]{vo.getTitle(), vo.getContent(), vo.getWriter(), vo.getHit(), vo.getPassword(), groups, levels, step};
		}
		jdbcTemplate.update(sql, values);
	}
	
	//��ȸ�� ����
	public void upCount(int seq){
		String sql = "Update board set hit = hit + 1 where seq = ?";
		Object[] values = new Object[]{new Integer(seq)};
		jdbcTemplate.update(sql, values);
	}
	
	//�����ϱ�
	public void delete(int seq, int groups){
		String sql = "";
		//�θ�� ������ ��۸�� ������ ���� ���ǹ�
		if(seq==groups){
			sql = "delete from board where groups=?";
		} else {
			sql = "delete from board where seq=?";
		}
		Object[] values = new Object[]{seq};
		jdbcTemplate.update(sql, values);
	}
	
	//��ü �Խù� �� Ȯ��
	public int getRowCount(String keyField, String keyWord){
		int count=0;   //��ü �Խù� ���� �ʱⰪ
		//�˻����� �� �Խù� �� ������ ���� ���ǹ�
		if(keyWord==null||keyWord==""){
			count = jdbcTemplate.queryForInt("select count(*) from board");
		} else {
			count = jdbcTemplate.queryForInt("select count(*) from board where "+keyField+" like '%"+keyWord+"%'");
		}
		return count;
	}
	
}
