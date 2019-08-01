package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import pack.controller.SurveyBean;

public interface SurveyAnnoInter {
	@Select("select comment, name, phone, text from survey")
	public List<SurveyDto> selectDataAll(); //목록
	
	@Insert("insert into survey values(#{comment}, #{name}, #{phone}, #{text})")
	public boolean insertSurvey(SurveyBean bean);  //서치
}
