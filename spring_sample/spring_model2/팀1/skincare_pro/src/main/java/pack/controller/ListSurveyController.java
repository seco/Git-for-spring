package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import pack.model.SurveyDaoInter;

@Controller
public class ListSurveyController {
	
	
	@Autowired //autowired의 파생클래스가 들어온다. Impl이 들어온다는뜻.
	private SurveyDaoInter surveyDaoInter;
	
	@RequestMapping("surveylist")
	public ModelAndView surveylist() {
		
		System.out.println("surveylist");
		
		return new ModelAndView("surveylist", "data", surveyDaoInter.getDataAll());
	}
}
