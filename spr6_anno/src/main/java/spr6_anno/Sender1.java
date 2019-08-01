package spr6_anno;

import org.springframework.stereotype.Component;

@Component //스스로 객체를 만듦 : @Component("Sender1") 과 같음
public class Sender1 implements SenderInter{
	public void show() {
		System.out.println("sender 1 처리");
		
	}
}
