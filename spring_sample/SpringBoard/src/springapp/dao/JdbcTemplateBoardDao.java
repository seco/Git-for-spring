package springapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JdbcTemplateBoardDao {
	
	private JdbcTemplate jdbcTemplate;
	
	//DB와 연결할 준비
	public void setJdbcTemplate(JdbcTemplate temp){
		jdbcTemplate = temp;
	}
	
	public int count() throws Exception {
		//쿼리의 결과값을 정수형으로 리턴
		return jdbcTemplate.queryForInt("select count(*) from board");
	}
	
	//전체보기
	public List list(int start, int end, String keyField, String keyWord){
		List result = new ArrayList();
		String sql = "";
		
		//검색 유무를 확인 후 쿼리 실행 조건문
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
		
		//레코드를 매핑해서 전달해주는 클래스
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

	//상세보기
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
	
	//글 수정하기
	public void update(BoardVo vo){
		String sql = "Update board set title=?, content=? where seq=?";
		Object[] values = new Object[]{vo.getTitle(), vo.getContent(), vo.getSeq()};
		jdbcTemplate.update(sql, values);
	}
	
	//글 등록하기
	public void insert(BoardVo vo){
		int num = vo.getSeq();
		int groups = vo.getGroups();
		int step = vo.getStep();
		int levels = vo.getLevels();
		int number = 0;
		
		String sql = "";
		Object[] values = null;
		
		int temp = jdbcTemplate.queryForInt("select max(seq) from board");
		
		//게시글이 없을 때 위한 number값 변경 조건문
		if(temp!=0){
			number = temp + 1;			
		} else {
			number = 1;
		}
		
		//게시글 확인 유무를 위한 조건문
		if(num!=0){
			sql = "update board set levels = levels + 1 where groups = ? and step > ?";
			values = new Object[]{groups, step};
			jdbcTemplate.update(sql, values);
			
			//현 선택한 글이 댓글인지 부모글인지 확인후 groups 값 지정을 위한 조건문
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
		
		//작성한 글이 부모글, 댓글일 때 쿼리 조건변경
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
	
	//조회수 증가
	public void upCount(int seq){
		String sql = "Update board set hit = hit + 1 where seq = ?";
		Object[] values = new Object[]{new Integer(seq)};
		jdbcTemplate.update(sql, values);
	}
	
	//삭제하기
	public void delete(int seq, int groups){
		String sql = "";
		//부모글 삭제시 댓글모두 삭제를 위한 조건문
		if(seq==groups){
			sql = "delete from board where groups=?";
		} else {
			sql = "delete from board where seq=?";
		}
		Object[] values = new Object[]{seq};
		jdbcTemplate.update(sql, values);
	}
	
	//전체 게시물 수 확인
	public int getRowCount(String keyField, String keyWord){
		int count=0;   //전체 게시물 수의 초기값
		//검색했을 시 게시물 수 변경을 위한 조건문
		if(keyWord==null||keyWord==""){
			count = jdbcTemplate.queryForInt("select count(*) from board");
		} else {
			count = jdbcTemplate.queryForInt("select count(*) from board where "+keyField+" like '%"+keyWord+"%'");
		}
		return count;
	}
	
}
