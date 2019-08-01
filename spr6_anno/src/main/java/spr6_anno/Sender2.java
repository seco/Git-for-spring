package spr6_anno;

import org.springframework.stereotype.Component;

@Component
public class Sender2 implements SenderInter{
	public void show() {
		System.out.println("sender 2 처리");
		
	}
}
