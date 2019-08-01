package pack.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component
public class LoginClass {
	
	public boolean loginCheck(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		
		System.out.println("너?" + request);
		
		if(session.getAttribute("name") == null) {
			System.out.println("2");
			response.sendRedirect("jikwon_login");
			return true;
		}else {
			return false;
		}
	}
	
}
