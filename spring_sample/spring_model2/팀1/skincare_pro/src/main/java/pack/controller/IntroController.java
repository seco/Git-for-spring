package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pack.model.EmpDaoInter;

@Controller
public class IntroController {
	
	@Autowired
	private EmpDaoInter empDao;
	
	@RequestMapping("intro")
	public ModelAndView intro() {
		ModelAndView view = new ModelAndView();
		view.addObject("empScList", empDao.getEmpScList()); // skin care list 반환
		view.setViewName("intro");
		return view;
	}
	
//	@RequestMapping("disp_sc") // skin care emp list
//	public ModelAndView disp_sc() {
//		ModelAndView view = new ModelAndView();
//		view.addObject("empScList", empDao.getEmpScList()); // skin care list 반환
//		view.setViewName("intro");
//		return view;
//	}
}
