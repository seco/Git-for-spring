package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface EmpDaoAnnoInter {
	@Select("select * from emp")
	public List<EmpDto> selectAllEmp(); // 전체 직원 조회
	
	@Select("select * from emp where emp_no=#{emp_no}")
	public EmpDto selectPartEmp(String num);
	
	@Insert("insert into emp(emp_name, emp_job, emp_img) values(#{emp_name} ,#{emp_job}, #{emp_img})")
	public int insertEmp(EmpBean bean);
	
	@Update("update emp set emp_name=#{emp_name}, emp_job=#{emp_job} where emp_no=#{emp_no}")
	public int updateEmp(EmpBean bean);
	
	@Delete("delete from emp where emp_no=#{emp_no}")
	public int deleteEmp(String num);
}