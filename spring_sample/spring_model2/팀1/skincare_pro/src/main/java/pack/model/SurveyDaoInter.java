package pack.model;

import java.util.List;

import org.springframework.dao.DataAccessException;

import pack.controller.SurveyBean;
//모델
public interface SurveyDaoInter {
	List<SurveyDto> getDataAll() throws DataAccessException;	
	boolean insertSurvey(SurveyBean bean) throws DataAccessException;

}
