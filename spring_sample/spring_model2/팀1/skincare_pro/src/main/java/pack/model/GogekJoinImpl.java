package pack.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import pack.controller.GogekBean;


@Repository
public class GogekJoinImpl implements GogekJoinInter{
	@Autowired // type에 의한 맵핑. 어플리케이션의 configuration만남. 거기서 selectDataAll만나게댐
	private GogekJoinAnnoInter gogekJoinAnnoInter;
	
	
	public boolean gogekInsert(GogekBean bean) throws DataAccessException{ //boolean 임으로 예외처리잡아줘야함
		try {
			gogekJoinAnnoInter.gogekInsert(bean);
			return true;
		} catch (Exception e) {
			System.out.println("gogekInsert err :" + e);
			return false;
		}
		
	}
	
	public GogekDto selectGogek(String gogek_id) throws DataAccessException { //해당 고객수정하기위한  정보 얻기
		
		return gogekJoinAnnoInter.selectGogek(gogek_id);
	}
	
	public boolean updateGogek(GogekBean bean) throws DataAccessException{
		try {
			gogekJoinAnnoInter.gogekUpdate(bean);
			return true;
		} catch (Exception e) {
			System.out.println("updatData err :" + e);
			return false;
		}
		
	}
	
	
	public boolean deleteData(String num) throws DataAccessException{
		
			
			return false;
	
	}
	
	
}