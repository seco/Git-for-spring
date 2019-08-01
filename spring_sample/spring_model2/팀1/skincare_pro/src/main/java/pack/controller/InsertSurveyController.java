package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pack.model.SurveyDaoInter;

@Controller
public class InsertSurveyController {

	@Autowired
	private SurveyDaoInter surveyDaoInter;

	@RequestMapping(value = "survey", method = RequestMethod.GET)
	public String form(SurveyBean bean) { // insert화면으로 이동

		return "usersurvey";

	}

	@RequestMapping(value="survey" , method=RequestMethod.POST)
	public String submit(SurveyBean bean) { //insert 성공시  값이들어가는부분
	
	boolean b = surveyDaoInter.insertSurvey(bean);
		
	System.out.println(bean.getName());
	System.out.println(bean.getComment());
	System.out.println(bean.getPhone());
	System.out.println(bean.getText());
	
	
		if(b) { //true 일 시 목록보기
			return "redirect:/surveylist";
		}
		else{
			return "error";
		}
	}
}
