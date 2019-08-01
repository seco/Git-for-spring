package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pack.model.SurgicalAnnoInter;

@Controller
public class BlistController {
	
	@Autowired
	private SurgicalAnnoInter surgicalAnnoInter;
	
	@RequestMapping(value="blist" , method = RequestMethod.POST)
	public ModelAndView blist(){
		System.out.println("blist");
		return new ModelAndView("blist", "bdata", surgicalAnnoInter.beAllData());
		
	}
	
	@RequestMapping(value="blist")
	public ModelAndView blist2(){
		System.out.println("blist");
		return new ModelAndView("blist", "bdata", surgicalAnnoInter.beAllData());
	}
	
	@RequestMapping(value="change", method = RequestMethod.POST)  // 비승인 승인으로 바꾸기
	public String changelist(String prog_order_no) {
		
		System.out.println(prog_order_no);
		
		boolean b = surgicalAnnoInter.stateUpdate(prog_order_no);
		
		if(b) { //true 일 시 목록보기
			return "redirect:/blist";
		}
		else{
			return "error";
		}
		
	}
}
