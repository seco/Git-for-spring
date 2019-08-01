package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDao implements EmpDaoInter {
	
	@Autowired
	EmpDaoAnnoInter empDaoAnnoInter;
	
	public List<EmpDto> getEmpScList() {
		//System.out.println("getEmpScList 호출");
		return empDaoAnnoInter.selectAllEmp();
	}
	
	public EmpDto selectPartEmp(String num) {
		return empDaoAnnoInter.selectPartEmp(num);
	}
	
	public boolean insertEmp(EmpBean bean) {// 직원 등록(관리자 모드)
		System.out.println("insert 호출");
		if (empDaoAnnoInter.insertEmp(bean)>0)
			return true;
		else
			return false;
	}
	
	public boolean updateEmp(EmpBean bean) {
		int re = empDaoAnnoInter.updateEmp(bean);
		if(re > 0)
			return true;
		else
			return false;
	}
	
	public boolean deleteEmp(String num) {
		int re = empDaoAnnoInter.deleteEmp(num);
		if(re > 0)
			return true;
		else
			return false;
	}
}
