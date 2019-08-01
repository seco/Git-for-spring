package aop1;

public class ArticleDao implements ArticleInter{
	public void selectAll() {
		System.out.println("db 자료 읽기 성공");
		
	}
}
