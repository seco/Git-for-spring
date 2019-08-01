package aop2anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service //비즈니스 로직 운영
//객체 변수 logicImpl
public class LogicImpl implements LogicInter{
	@Autowired //타입에 의한 매핑
	@Qualifier("articleDao") //어떤타입인지
	
	private ArticleInter articleinter;
	/*
	public LogicImpl(ArticleInter articleInter) {
		this.articleinter = articleInter;
	}
	*/
	public void selectData_process() {
		System.out.println("selectData_process 수행");
		articleinter.selectAll();
		//articleinter의 자식클래스 articleDao의 함수 사용가능
	}
}
