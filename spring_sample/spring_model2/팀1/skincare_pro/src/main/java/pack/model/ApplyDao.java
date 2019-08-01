package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ApplyDao{
	
	@Autowired
	ApplyDaoAnnoInter applyDaoAnnoInter;
	
	public List<ApplyDto> selectAllApply() {
		return applyDaoAnnoInter.selectAllApply();
	}
//	
//	public boolean insertEmp(EmpBean bean) {// 직원 등록(관리자 모드)
//		System.out.println("insert 호출");
//		if (empDaoAnnoInter.insertEmp(bean)>0)
//			return true;
//		else
//			return false;
//	};
}
