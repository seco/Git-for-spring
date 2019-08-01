package pack.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAdvice {
	@Autowired
	private LoginClass loginClass;
	
	@Around("execution(* list(..))")
	public Object aopProcess(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("1");
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		
		for(Object obj:joinPoint.getArgs()) {
			
			//System.out.println(obj);
			
			if(obj instanceof HttpServletResponse) {
				response = (HttpServletResponse)obj;
			}
			
			if(obj instanceof HttpServletRequest) {
				request = (HttpServletRequest)obj;
			}
		}
		
		// 세션 체크 후 로그인하지 않은 경우 로그인 창으로 이동
		if(loginClass.loginCheck(request, response)) {
			return null;
		}
		   
		Object object = joinPoint.proceed();
		return object;
	}
	
	
}



