package aa.bb.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*
 * @Controller public class LoginController {
 * 
 * @RequestMapping(value="login", method=RequestMethod.GET) public ModelAndView
 * submit(HttpServletRequest request){ String id = request.getParameter("id");
 * //request 객체를 사용 String pwd = request.getParameter("pwd");
 * 
 * String data = ""; if(id.equals("aa") && pwd.equals("11")) data = "로그인 성공1";
 * else data = "로그인 실패1";
 * 
 * ModelAndView view = new ModelAndView(); view.setViewName("result"); //기본은
 * forward //view.setViewName("redirect:/view/result.jsp"); //redirect방식
 * view.addObject("data", data); return view; } }
 */

@Controller
@RequestMapping("login")                        //type level mapping
public class LoginController {
	@RequestMapping(method=RequestMethod.GET)   //method level mapping
	public ModelAndView submit(
		@RequestParam("id") String id,   
		@RequestParam("pwd") String pwd ) {
		String data = "";
		if(id.equals("aa") && pwd.equals("11"))
		//if(id.equals("aa") && pwd == 11)    //int type으로 읽은 경우 비교
			data = "로그인 성공2";
		else
			data = "로그인 실패2";
		
		ModelAndView view = new ModelAndView();
		view.setViewName("result");
		view.addObject("data", data);
		return view;
	}
}