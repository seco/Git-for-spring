package pack.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Aspect
@Component
public class GogekAdvice {
	
	@Autowired
	private GogekLoginClass loginClass;
	
	@Around("execution(* regist_gogek(..)) or execution(* sangpum_order_one(..)) or execution(* sangpum_order(..))")
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



