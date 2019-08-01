package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import pack.model.GogekDto;
import pack.model.ProgramAllDto;
import pack.model.SurgicalInter;

@Controller
public class CusReserveController {
	

	@Autowired
	private SurgicalInter surgicalInter;

	@RequestMapping(value="reserve" , method = RequestMethod.GET) //업데이트화면
	public ModelAndView reserve(@RequestParam("gogek_id") String gogek_id) { 
		ModelAndView view = new ModelAndView();
		
		
		view.setViewName("reserve");		
		List<ProgramAllDto> dto1 = surgicalInter.prolist();
		GogekDto dto = surgicalInter.selectPart(gogek_id);
		
		view.addObject("dto", dto);
		view.addObject("program", dto1);
	
		return view;
		
	}
	
	/*@RequestMapping(value="reserve" , method = RequestMethod.POST) //업데이트 완료 누를때
	public String reserve(CustomerBean bean) { //String 방법!!! 위는 ModelAndView방법
		//MemBean bean는 jsp에서 jsp:set property ="*" 을생각
		boolean b = surgicalInter.updateData(bean);
		
		if(b) {
			return "redirect:/list";
		}else {
			return "error";
		}		 
		
	}*/

}
