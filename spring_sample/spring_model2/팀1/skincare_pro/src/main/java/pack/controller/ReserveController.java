package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pack.model.ApplyDao;
import pack.model.ApplyDto;

@Controller
public class ReserveController {
	@Autowired
	private ApplyDao applyDao;
  
	@RequestMapping("approvalList")
	public ModelAndView selectapplyList() {
		List<ApplyDto> list = applyDao.selectAllApply();

		ModelAndView view = new ModelAndView();
	
		view.addObject("list", list);
		return view;
	}
	
}
