package spr6_anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component //스스로 인스턴스
//@Service //비즈니스 로직에선 가독성을 위해 변경 가능. Service("SenderProcess")와 같음 
public class SenderProcess {
	@Autowired //setter 작업을 내부적으로 실행 
	@Qualifier("sender1")
	private SenderInter inter;
	
//	public void setInter(SenderInter inter) {
//		this.inter = inter;
//	}
	
	public void ShowData() {
		inter.show();
		
	}
	
}
