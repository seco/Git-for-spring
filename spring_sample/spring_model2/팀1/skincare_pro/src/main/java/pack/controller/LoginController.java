package pack.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.GogekDto;
import pack.model.JikwonDto;
import pack.model.SkinSangDaoInter;

@Controller
public class LoginController {
	@Autowired
	private SkinSangDaoInter inter;
	
	@RequestMapping(value="jikwon_login", method=RequestMethod.GET)
	public String goLogin() {
		return "jikwon_login";
	}
	
	@RequestMapping(value="jikwon_login", method=RequestMethod.POST)
	public String summitLogin(HttpSession session,
			@RequestParam("jikwon_id") String jikwon_id,
			@RequestParam("jikwon_password") String jikwon_password) {
		
		//System.out.println(jikwon_id + " " + jikwon_password + " 2");
		
		JikwonDto dto = inter.getLoginInfo(jikwon_id);
		
		//System.out.println(dto.getJikwon_id());
		
		if(dto != null) {
			String retPassword = dto.getJikwon_password();
			//System.out.println("나오나");
			if(retPassword.equals(jikwon_password)) {
				session.setAttribute("name", jikwon_id);
			}
		}
		return "redirect:/main_intro.jsp";
	}
	
	@RequestMapping("logout")
	public String getLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/main_intro.jsp";
	}
	
	// 고객 로그인
	
	@RequestMapping(value="gogek_login", method=RequestMethod.GET)
	public String gogekLogin() {
		return "gogek_login";
	}
	
	@RequestMapping(value="gogek_login", method=RequestMethod.POST)
	public String gogekLogin(HttpSession session,
			@RequestParam("gogek_id") String gogek_id,
			@RequestParam("gogek_password") String gogek_password) {
		
		System.out.println(gogek_id + " " + gogek_password + " 2");
		
		GogekDto dto = inter.gogekLogin(gogek_id);
		
		System.out.println(dto.getGogek_id());
		
		if(dto != null) {
			String retPassword = dto.getGogek_password();
			System.out.println("나오나");
			if(retPassword.equals(gogek_password)) {
				session.setAttribute("gogek", gogek_id);
			}
		}
		
		return "redirect:/main_intro.jsp";
	}
	
	@RequestMapping("gogek_logout")
	public String gogekLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/main_intro.jsp";
	}
}