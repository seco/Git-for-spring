package aop2anno;

import org.springframework.stereotype.Repository;

@Repository //자체적으로 new 가능, 가독성을 위해, db작업 클래스 임을 알리기 위해 
public class ArticleDao implements ArticleInter{
	public void selectAll() {
		System.out.println("db 자료 읽기 성공");
		
	}
}
