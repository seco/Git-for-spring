package spr6_anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

   public static void main(String[] args) {
      //ApplicationContext context = new ClassPathXmlApplicationContext("myinit.xml");
      //ApplicationContext context = new ClassPathXmlApplicationContext("classpath:pack/myinit.xml");
      //메타 파일의 경로 지정 : classpath:pack/myinit.xml
	  //root 경로 : src/main/resources
      ApplicationContext context = new ClassPathXmlApplicationContext("classpath:init.xml");
      
      SenderProcess process = (SenderProcess)context.getBean("senderProcess");
      process.ShowData();
   }

}