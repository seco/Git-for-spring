package pack.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pack.model.GogekDto;
import pack.model.GogekJoinInter;

//회원가입 및 수정
@Controller
public class GogekJoinController {
	
	@Autowired
	private GogekJoinInter gogekJoinInter;
	
	@RequestMapping(value = "join_membership", method = RequestMethod.GET)
	
	public String gogekform(GogekBean bean) { // insert화면으로 이동
		System.out.println("들어옴?");
		return "gogekinsert";

	}

	@RequestMapping(value="join_membership" , method=RequestMethod.POST)
	public String submit(GogekBean bean) { //insert 성공시  값이들어가는부분
	
	boolean b = gogekJoinInter.gogekInsert(bean);
		if(b) { //true 일 시 목록보기
			return "redirect:/main_intro.jsp";
		}
		else{
			return "error";
		}
	}
	
	//수정
	
	@RequestMapping(value="join_membershipUpdate" , method = RequestMethod.GET) //업데이트화면
	public ModelAndView selectOne(@RequestParam("gogek_id") String gogek_id) {
		
		GogekDto dto = gogekJoinInter.selectGogek(gogek_id);
		return new ModelAndView("gogekupdate", "gogek", dto);
		
	}
	
	@RequestMapping(value="join_membershipUpdate" , method = RequestMethod.POST) //업데이트 완료 누를때
	public String gogekupdate(@ModelAttribute GogekBean bean) { //String 방법!!! 위는 ModelAndView방법
		//MemBean bean는 jsp에서 jsp:set property ="*" 을생각
		
		boolean b = gogekJoinInter.updateGogek(bean);
		
		System.out.println("너" + bean.getGogek_id());
		
		
		if(b) {
			return "redirect:/skinsang_list_gogek";
		}else {
			return "error";
		}		 
		
	}

	
	
	
}