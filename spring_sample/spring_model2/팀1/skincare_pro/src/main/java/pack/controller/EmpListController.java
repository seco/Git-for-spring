package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.EmpBean;
import pack.model.EmpDaoAnnoInter;
import pack.model.EmpDaoInter;
import pack.model.EmpDto;

@Controller
public class EmpListController {
	@Autowired
	private EmpDaoInter daoInter;
	
	@RequestMapping("empList")
	public ModelAndView empList() {
		return new ModelAndView("empList", "empList", daoInter.getEmpScList());
	}
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public ModelAndView readup(@RequestParam("emp_no") String num) {
		EmpDto dto = daoInter.selectPartEmp(num);
		
		return new ModelAndView("empUpdate", "dto", dto);
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(EmpBean bean) {
		boolean b = daoInter.updateEmp(bean);
		
		if(b) {
			return "redirect:/empList";
		} else {
			return "error";
		}
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(@RequestParam("emp_no") String num) {
		if(daoInter.deleteEmp(num))
			return "redirect:/empList";
		else
			return "error";
	}
}