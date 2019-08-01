package pack.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component
public class GogekLoginClass {
	
	public boolean loginCheck(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		System.out.println("너?" + request);
		HttpSession session = request.getSession();
		
		if(session.getAttribute("gogek") == null) {
			System.out.println("2");
			response.sendRedirect("gogek_login");
			return true;
		}else {
			return false;
		}
	}
}
