package pack.model;

import java.util.List;

import pack.controller.ProgramBean;

public interface ProgramDaoInter {
	List<ProgramDto> getDataAll();
	public ProgramDto selectPart(String pro_no);
	List<ProgramDto> getProgramByCate(String pro_cate);
	ProgramDto getProgramDetail(String pro_no);
	List<CateDto> getAllCate();
	
	public boolean insertData(ProgramBean bean);
	public boolean updateData(ProgramBean bean);
	public boolean deleteData(String pro_no);
	public List<String> selectcate();
}
