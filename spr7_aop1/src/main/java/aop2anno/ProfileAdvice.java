package aop2anno;
//추가하고 싶은 관심사항
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class ProfileAdvice { // advice, aspect : 관심사항을 가진 클래스
	
	@Around("execution(public * aop2anno..*(..))")
	//수행하려는 핵심 메소드들
	//execution에 |나 & 사용 가능
	public Object kbs(ProceedingJoinPoint joinPoint) throws Throwable{
		
		System.out.println("핵심 메소드 수행 전 작업 : 로그인 , 보안, 트랜잭션...");
		Object object = joinPoint.proceed(); //핵심 메소드 찾아서 수행 
		System.out.println("핵심 메소드 수행 후 하고 싶은 작업 ");
		return object;
	}
}
