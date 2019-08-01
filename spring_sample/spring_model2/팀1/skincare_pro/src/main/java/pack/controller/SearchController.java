package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;


import pack.model.GogekDto;
import pack.model.ProgramAllDto;
import pack.model.SurgicalInter;

@Controller
public class SearchController {
	@Autowired
	private SurgicalInter surgicalInter;
	
	@RequestMapping(value="search", method=RequestMethod.POST)
	public ModelAndView search(GogekBean bean) {
		
		
		
		List<GogekDto> list = surgicalInter.search(bean);
		return new ModelAndView("surgicallist", "data", list);
		
	}
	
	@RequestMapping(value="search1", method=RequestMethod.POST)
	public ModelAndView search1(ProgramAllBean bean) {
		
		
		
		List<ProgramAllDto> list = surgicalInter.search1(bean);
		return new ModelAndView("surgicallist", "prodto", list);
		
	}
		
		
	
}
