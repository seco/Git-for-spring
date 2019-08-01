package aop1;

public class LogicImpl implements LogicInter{
	
	private ArticleInter articleinter;
	
	public LogicImpl(ArticleInter articleInter) {
		this.articleinter = articleInter;
	}
	
	public void selectData_process() {
		System.out.println("selectData_process 수행");
		articleinter.selectAll();
		
	}
}
