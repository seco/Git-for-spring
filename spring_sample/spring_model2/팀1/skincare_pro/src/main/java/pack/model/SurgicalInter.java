package pack.model;

import java.util.List;

import org.springframework.dao.DataAccessException;

import pack.controller.GogekBean;
import pack.controller.ProgramAllBean;
//다형성을위해 인터페이스씀.
public interface SurgicalInter {
	List<GogekDto> surgical() throws DataAccessException;   
	List<GogekDto> search(GogekBean bean) throws DataAccessException; //검색
	public GogekDto selectPart(String gogek_id) throws DataAccessException; // 이름누르면 예약메뉴
	public List<ProgramAllDto> prolist() throws DataAccessException;
	public boolean reserveData(ProgramAllBean probean) throws DataAccessException;
	public List<ProgramAllDto> reservelist() throws DataAccessException;
	public List<ProgramAllDto> reservelist_gogek(String gogek_id) throws DataAccessException;
	public List<ProgramAllDto> blist() throws DataAccessException;
	public boolean reserveData_gogek(ProgramAllBean probean) throws DataAccessException;
	public List<ProgramAllDto> search1(ProgramAllBean bean) throws DataAccessException; //예약자검색
	public boolean stateUpdate(String prog_order_no) throws DataAccessException;
}
