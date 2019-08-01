package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pack.controller.GogekBean;
import pack.controller.ProgramAllBean;

public interface SurgicalAnnoInter { //datamapper.xml 필요없어진다.
	@Select("select * from gogekinfo")
	public List<GogekDto> getDataAll(); //고객목록
	
	@Select("select gogek_id, gogek_name, gogek_phone from gogekinfo where gogek_name like concat('%',#{searchValue},'%')")
	public List<GogekDto> selectSearch(GogekBean bean); // 고객검색
	
	@Select("select gogek_name, pro_name, pro_detail, pro_order_cnt, register_date from prog_order p inner join program pr on p.pro_no = pr.pro_no inner join gogekinfo c on c.gogek_id= p.gogek_id where gogek_name like concat('%',#{searchValue},'%')")
	public List<ProgramAllDto> reserveSearch(ProgramAllBean bean); // 예약자검색
	
	@Select("select * from gogekinfo where gogek_id=#{gogek_id}")
	public GogekDto selectOne(String gogek_id); //고객한명선택
	
	@Select("select * from program")	
	public List<ProgramAllDto> selectAllData(); //상품목록
	
	@Insert("insert into prog_order(pro_order_cnt, pro_no, gogek_id, state, register_date) values(#{pro_order_cnt}, #{pro_no}, #{gogek_id}, '비승인', now())")
	public boolean proInsertData(ProgramAllBean probean); //예약등록하기
	
	@Insert("insert into prog_order(pro_order_reserve_cnt,pro_order_cnt, pro_no, gogek_id, state, register_date) values(0, #{pro_order_cnt}, #{pro_no}, #{gogek_id}, '비승인', now())")
	public boolean proInsertData_gogek(ProgramAllBean probean); //예약등록하기
	
	@Select("select gogek_name, pro_name, pro_detail, pro_order_cnt, register_date, state from prog_order p inner join program pr on p.pro_no = pr.pro_no inner join gogekinfo c on c.gogek_id= p.gogek_id order by register_date asc")
	public List<ProgramAllDto> reserveAllData(); //예약자 등록목록
	
	@Select("select gogek_name, pro_name, pro_detail, pro_order_cnt, register_date, state from prog_order p inner join program pr on p.pro_no = pr.pro_no inner join gogekinfo c on c.gogek_id= p.gogek_id where p.gogek_id = #{gogek_id} order by register_date asc")
	public List<ProgramAllDto> reserveAllData_gogek(String gogek_id); //예약자 등록목록
	
	@Select("select prog_order_no, gogek_name, pro_name, pro_detail, pro_order_cnt, register_date, state from prog_order p inner join program pr on p.pro_no = pr.pro_no inner join gogekinfo c on c.gogek_id= p.gogek_id where state='비승인'")
	public List<ProgramAllDto> beAllData(); //비승인목록
	
	@Update("update prog_order set state='승인' where prog_order_no = #{prog_order_no}") 
	public boolean stateUpdate(String prog_order_no);
}
