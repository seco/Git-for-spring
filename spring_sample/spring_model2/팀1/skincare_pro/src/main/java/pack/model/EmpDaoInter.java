package pack.model;

import java.util.List;

public interface EmpDaoInter {
	public List<EmpDto> getEmpScList();
	public EmpDto selectPartEmp(String num);
	
	boolean insertEmp(EmpBean bean);
	boolean updateEmp(EmpBean bean);
	boolean deleteEmp(String num);
}
