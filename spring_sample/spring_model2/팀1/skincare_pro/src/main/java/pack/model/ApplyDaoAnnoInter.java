package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface ApplyDaoAnnoInter {
	@Select("select c.c_no c_no, c_name, c_phone, pro_order_cnt, register_date, state, pro_name\r\n" + 
			"from prog_order po , customer c, program p\r\n" + 
			"where po.c_no = c.c_no \r\n" + 
			"and  p.pro_no = po.pro_no\r\n" + 
			"and state = '비승인'")
	public List<ApplyDto> selectAllApply(); // 전체 신청(비승인) 리스트
	
	// 프로그램 승인 업데이트
	//@Update("update ")
	
	// 수정 필요 안쓰는 것
	@Insert("insert into test_employee values(#{emp_no}, #{emp_name} ,#{emp_job}, #{emp_img})")
	public int insertRsv(EmpBean bean);
	
	
}