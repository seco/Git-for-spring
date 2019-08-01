package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.ProgramBean;

@Repository
public class ProgramDaoImpl implements ProgramDaoInter{
	
	@Autowired
	private ProgramAnnoInter annoInter;

	public List<ProgramDto> getDataAll() {
		return annoInter.getDataAll();
	}

	public List<ProgramDto> getProgramByCate(String pro_cate) {
		return annoInter.getProgramByCate(pro_cate);
	}
	
	public ProgramDto selectPart(String pro_no) {
		return annoInter.selectPart(pro_no);
	}
	
	public List<CateDto> getAllCate() {
		return annoInter.getAllCate();
	}

	public ProgramDto getProgramDetail(String pro_no) {
		return annoInter.getProgramDetail(pro_no);
	}
	
	public boolean insertData(ProgramBean bean) {
		try {
			annoInter.insertData(bean);	
			return true;
			
		} catch (Exception e) {
			System.out.println("insertdateData err : " + e);
			return false;
		}
	}

	public boolean updateData(ProgramBean bean) {
		try {
			annoInter.updateData(bean);	
			return true;
			
		} catch (Exception e) {
			System.out.println("updateData err : " + e);
			return false;
		}
	}

	public boolean deleteData(String no) {
		try {
			annoInter.deleteData(no);		
			return true;
			
		} catch (Exception e) {
			System.out.println("deleteData err : " + e);
			return false;
		}
	}
	
	public List<String> selectcate() {
		List<String> list = annoInter.selectcate();
		return list;
	}
}
