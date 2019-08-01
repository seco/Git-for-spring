package pack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/*
 * public class TestController implements Controller{
 * 
 * @Override public ModelAndView handleRequest(HttpServletRequest request,
 * HttpServletResponse response) throws Exception { // 모델이 있는 곳을 찾아서 데이터 연결하는 등
 * 비즈니스로직 수행 String msg = "모델에서 자료 읽음"; ModelAndView andView = new
 * ModelAndView(); andView.addObject("say", msg); //키와 값담음
 * andView.setViewName("list");
 * 
 * return andView; } }
 */
@org.springframework.stereotype.Controller
public class TestController{
	
	@RequestMapping("index.do") //index를 만날때 abc를 실행시키도록 함 
	public ModelAndView abc() {
		String msg = "모델에서 자료 읽음"; 
		
		ModelAndView andView = new ModelAndView(); 
		andView.addObject("say", msg); //request 객체에 담겨서 포워딩(서버에서 서버로)함
		andView.setViewName("list"); //list.jsp를 부름 
		return andView; //모델앤뷰를 리턴
	}
	
}