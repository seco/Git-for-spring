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
	private int totalCount;			//총 게시물 수
	private int blockCount = 10;	//한 페이지의 게시물 수
	private int blockPage = 10;		//한 화면에 보여줄 페이지 수
	private String pagingHtml;		//페이징을 구현한 HTML
	
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
	
		//arg0.getParameter("currentPage")값은 문자형식으로 받아 오기 때문에 임시로
		//담아둘 PageNo 변수 선언
		//Integer.parseInt(arg0.getParameter("currentPage"))로 정수로 변환을 미리하면
		//null값 처리가 힘들므로 나중에 변환하는게 좋다.
		String keyField = arg0.getParameter("keyField");
		String keyWord = arg0.getParameter("keyWord");
		String PageNo = arg0.getParameter("currentPage");
		
		int currentPage = 0;	//현재 페이지의 초기값 설정
		
		//현재 페이지에 null값이 들어올때 처리를 위한 조건문
		if(PageNo==null){
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(PageNo);
		}
		
		totalCount = boardDao.getRowCount(keyField, keyWord);
		
		//PagingAction객체생성
		page = new BoardPagingController(currentPage, totalCount, blockCount, blockPage, keyField, keyWord);
		
		pagingHtml = page.getPagingHtml().toString();	//페이지HTML 생성
		
		int lastCount = page.getEndCount();
		
		//DB에서 받아온 총 글수가 마지막 글수 보다 작을 때 처리하기 위한 조건문
		if(page.getEndCount()>totalCount){
			lastCount = totalCount;
		}
		
		List boardList = boardDao.list(page.getStartCount(), lastCount, keyField, keyWord);
		
		//데이터 전송을 위한 클래스 ModelAndView
		//boardList, pagingHtml, currentPage를 list(list.jsp)로 전송
		//실제 /board/list.jsp로 적어 줘야하지만 springapp-seervlet.xml에서
		//설정해줬기 때문에 list로 적는다
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList);
		mav.addObject("pagingHtml", pagingHtml);
		mav.addObject("currentPage", currentPage);
		mav.setViewName("list");
		
		return mav;
	}
}
