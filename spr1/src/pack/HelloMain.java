package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		System.out.println("성공");
		
		Message1 message1 = new Message1();
		message1.sayHello("tom");
		MessageInter inter;
		inter = message1;
		inter.sayHello("james");
		
		System.out.println();
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		MessageInter inter2 = (MessageInter)context.getBean("mes1");
		inter2.sayHello("oscar");
		//스프링 환경을 통한 객체 생성, 스프링:객체 관리 컨테이너
		
		
		
	}

}
