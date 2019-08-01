package springapp.board;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import springapp.dao.JdbcTemplateBoardDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardListController implements Controller {

	private JdbcTemplateBoardDao boardDao;
	private BoardPagingController page;
	private int totalCount;			//�� �Խù� ��
	private int blockCount = 10;	//�� �������� �Խù� ��
	private int blockPage = 10;		//�� ȭ�鿡 ������ ������ ��
	private String pagingHtml;		//����¡�� ������ HTML
	
	public JdbcTemplateBoardDao getBoardDao() {
		return boardDao;
	}
	public void setBoardDao(JdbcTemplateBoardDao boardDao) {
		this.boardDao = boardDao;
	}
	public BoardPagingController getPage() {
		return page;
	}
	public void setPage(BoardPagingController page) {
		this.page = page;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getBlockCount() {
		return blockCount;
	}
	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}
	public int getBlockPage() {
		return blockPage;
	}
	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}
	public String getPagingHtml() {
		return pagingHtml;
	}
	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}
	
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
	
		//arg0.getParameter("currentPage")���� ������������ �޾� ���� ������ �ӽ÷�
		//��Ƶ� PageNo ���� ����
		//Integer.parseInt(arg0.getParameter("currentPage"))�� ������ ��ȯ�� �̸��ϸ�
		//null�� ó���� ����Ƿ� ���߿� ��ȯ�ϴ°� ����.
		String keyField = arg0.getParameter("keyField");
		String keyWord = arg0.getParameter("keyWord");
		String PageNo = arg0.getParameter("currentPage");
		
		int currentPage = 0;	//���� �������� �ʱⰪ ����
		
		//���� �������� null���� ���ö� ó���� ���� ���ǹ�
		if(PageNo==null){
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(PageNo);
		}
		
		totalCount = boardDao.getRowCount(keyField, keyWord);
		
		//PagingAction��ü����
		page = new BoardPagingController(currentPage, totalCount, blockCount, blockPage, keyField, keyWord);
		
		pagingHtml = page.getPagingHtml().toString();	//������HTML ����
		
		int lastCount = page.getEndCount();
		
		//DB���� �޾ƿ� �� �ۼ��� ������ �ۼ� ���� ���� �� ó���ϱ� ���� ���ǹ�
		if(page.getEndCount()>totalCount){
			lastCount = totalCount;
		}
		
		List boardList = boardDao.list(page.getStartCount(), lastCount, keyField, keyWord);
		
		//������ ������ ���� Ŭ���� ModelAndView
		//boardList, pagingHtml, currentPage�� list(list.jsp)�� ����
		//���� /board/list.jsp�� ���� ��������� springapp-seervlet.xml����
		//��������� ������ list�� ���´�
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList);
		mav.addObject("pagingHtml", pagingHtml);
		mav.addObject("currentPage", currentPage);
		mav.setViewName("list");
		
		return mav;
	}
}
