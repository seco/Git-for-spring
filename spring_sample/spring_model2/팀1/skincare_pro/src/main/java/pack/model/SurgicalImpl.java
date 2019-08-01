package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import pack.controller.GogekBean;
import pack.controller.ProgramAllBean;

@Repository  //Persistence Layer에서 DAO를 명시하기 위해서 사용
public class SurgicalImpl implements SurgicalInter{
	
	@Autowired
	private SurgicalAnnoInter surgicalAnnoInter;
	
	public List<GogekDto> surgical() throws DataAccessException {
		System.out.println(surgicalAnnoInter.getDataAll());
		return surgicalAnnoInter.getDataAll();
	}
	
	public List<GogekDto> search(GogekBean bean) throws DataAccessException {
		
		return surgicalAnnoInter.selectSearch(bean);
	}
	
	public List<ProgramAllDto> search1(ProgramAllBean bean) throws DataAccessException {
		
		return surgicalAnnoInter.reserveSearch(bean);
	}
	
	public GogekDto selectPart(String gogek_id) { //이름링크누르면 form태그로
		
		return surgicalAnnoInter.selectOne(gogek_id);
	}
	
	public List<ProgramAllDto> prolist() throws DataAccessException{
		return surgicalAnnoInter.selectAllData();
	}
	
	
	public boolean reserveData(ProgramAllBean probean) throws DataAccessException{ // 상품과 횟수 등록
		return surgicalAnnoInter.proInsertData(probean);
	}
	
	public List<ProgramAllDto> reservelist() throws DataAccessException{ //예약된 사람들 리스트
		return surgicalAnnoInter.reserveAllData();
	}
	
	public List<ProgramAllDto> reservelist_gogek(String gogek_id) throws DataAccessException{ //예약된 사람들 리스트
		return surgicalAnnoInter.reserveAllData_gogek(gogek_id);
	}
	
	public List<ProgramAllDto> blist() throws DataAccessException{ //예약자 중 비승인 리스트
		return surgicalAnnoInter.beAllData();
	}
	
	public boolean reserveData_gogek(ProgramAllBean probean) throws DataAccessException{ // 상품과 횟수 등록
		return surgicalAnnoInter.proInsertData_gogek(probean);
	}
	
	public boolean stateUpdate(String prog_order_no) throws DataAccessException{
		return surgicalAnnoInter.stateUpdate(prog_order_no);
	}
}