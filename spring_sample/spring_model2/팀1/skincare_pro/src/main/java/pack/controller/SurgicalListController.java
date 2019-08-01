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
public class SurgicalListController {

	@Autowired
	private SurgicalInter surgicalInter;

	@RequestMapping("surgical")
	public ModelAndView surgical() {
		/*surgicalInter.reserveData(probean);*/
		ModelAndView view = new ModelAndView();
		List<ProgramAllDto> prodto = surgicalInter.reservelist();
		List<GogekDto> godto = surgicalInter.surgical();
		view.setViewName("surgicallist");
		
		view.addObject("prodto", prodto);
		view.addObject("data", godto);
		return view;
		
	}	
		
	

}
