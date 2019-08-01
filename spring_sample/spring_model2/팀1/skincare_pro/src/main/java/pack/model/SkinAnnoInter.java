package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pack.controller.SkinBean;

public interface SkinAnnoInter {
	@Select("select * from time")
	List<SkinDto> getDataAll();
	
	//@Select("select time_avail from time where time_no=#{time_no}")
		
	@Insert("insert into time_reserve(prog_order_no, reserve_date,time_unit,careManager_no) values(#{prog_order_no},#{reserve_date},#{time_unit},#{careManager_no})")
	public boolean book(SkinBean bean);
	
	// @Select("select * from time_reserve where reserve_date=#{dateVal}")
	@Select("select time_no, time_avail, time_unit, prog_order_no, reserve_date from time t left outer join time_reserve r on t.time_no = r.time_unit and r.reserve_date = #{dateVal} order by time_no")	
	public List<TimeDto> getDataTime(String dateVal);
	
	@Select("select prog_order_no, p.pro_no pro_no, pro_name, pro_order_cnt, pro_order_reserve_cnt , register_date, state from prog_order po, program p where po.pro_no = p.pro_no and po.gogek_id = #{gogek_id}")
	public List<ProgRsvDto> getProgRsv(String gogek_id);
	
	@Update("update prog_order set pro_order_reserve_cnt = pro_order_reserve_cnt + 1 where prog_order_no = #{prog_order_no}")
	public boolean addProgCnt(String prog_order_no);

	@Update("update prog_order set pro_order_reserve_cnt = pro_order_reserve_cnt + 1, state= '완료' where prog_order_no = #{prog_order_no}") // prog cnt 와 state 완료로 업데이트 ( 쿠폰 모두 소진 )
	public boolean addProgCntState(String prog_order_no);
	
	@Select("select prog_order_no, p.pro_no pro_no, pro_name, pro_order_cnt, pro_order_reserve_cnt , register_date, state from prog_order po, program p where po.pro_no = p.pro_no and po.prog_order_no = #{prog_order_no}")
	public ProgRsvDto getProgRsvByOrder(String prog_order_no);
	
	@Select("select prog_order_no, reserve_date, time_unit, careManager_no, emp_no, emp_name, emp_img from time_reserve r right outer join emp e on (e.emp_no = r.careManager_no and reserve_date = #{date_val} and time_unit = #{time_no}) where e.emp_job =  'careManager'")
	public List<CareMgrDto> getCareMgr(@Param("date_val") String date_val, @Param("time_no") String time_no);	

//	public getRsvList 수정중 이었음 
	@Select("select time_reserve_no, emp_no, emp_name, po.prog_order_no prog_order_no, pro_name, reserve_date, r.time_unit time_unit, t.time_avail time_avail, pro_order_cnt, pro_order_reserve_cnt \r\n" + 
			"from time_reserve r, prog_order po, gogekinfo g, time t , program p, emp e \r\n" + 
			"where r.prog_order_no = po.prog_order_no and g.gogek_id = po.gogek_id\r\n" + 
			"and p.pro_no = po.pro_no\r\n" + 
			"and r.time_unit = t.time_no\r\n" + 
			"and e.emp_no = r.careManager_no\r\n" + 
			"and g.gogek_id = #{gogek_id}\r\n" + 
			"and str_to_date(reserve_date , '%Y-%m-%d') > now();")
	public List<ReserveDto> getRsvList(String gogek_id);
	
	@Update("update time_reserve set reserve_date=#{reserve_date}, time_unit=#{time_unit}, careManager_no=#{careManager_no}, prog_order_no = #{prog_order_no} where time_reserve_no = #{time_reserve_no}")
	public boolean updateRsv(SkinBean bean);
	 
	@Delete("delete from time_reserve where time_reserve_no = #{time_reserve_no}")
	public boolean delRsv(String time_reserve_no);
	
	@Update("update prog_order set pro_order_reserve_cnt = pro_order_reserve_cnt-1 where prog_order_no =#{prog_order_no}")
	public boolean subRsv(String prog_order_no);
}