package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;


import pack.controller.SurveyBean;

@Repository
public class SurveyDaoImpl implements SurveyDaoInter{
	
	@Autowired // type에 의한 맵핑. 어플리케이션의 configuration만남. 거기서 selectDataAll만나게댐
	private SurveyAnnoInter surveyAnnoInter;
	
	
	public List<SurveyDto>  getDataAll() throws DataAccessException{
			
		return surveyAnnoInter.selectDataAll();
	}
	
	public boolean insertSurvey(SurveyBean bean) throws DataAccessException {
		System.out.println(bean.getName());
		System.out.println(bean.getText());
		System.out.println(bean.getComment());
		System.out.println(bean.getPhone());
		
		try {
			surveyAnnoInter.insertSurvey(bean);
			return true;
		} catch (Exception e) {
			System.out.println("insertSurvey err :" +e);
			return false;
		}
		
	}
	

}