package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

   public static void main(String[] args) {
      //ApplicationContext context = new ClassPathXmlApplicationContext("myinit.xml");
      //ApplicationContext context = new ClassPathXmlApplicationContext("classpath:pack/myinit.xml");
      //메타 파일의 경로 지정 : classpath:pack/myinit.xml
	  //root 경로 : src/main/resources
      ApplicationContext context = new ClassPathXmlApplicationContext("classpath:myinit.xml");
      
      MessageImpl impl = (MessageImpl)context.getBean("mbean");
      impl.sayhi();
      
      MessageImpl impl2 = (MessageImpl)context.getBean("mbean");
      impl2.sayhi();
      
      System.out.println("주소는 "+impl + " "+ impl2);
      
      //Messageinter inter = (MessageImpl)context.getBean("mbean");
      //Messageinter inter = (Messageinter)context.getBean("mbean");
      Messageinter inter = context.getBean("mbean", Messageinter.class); //뒤에서 캐스팅
      inter.sayhi();
   }

}