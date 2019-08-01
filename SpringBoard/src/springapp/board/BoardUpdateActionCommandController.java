package springapp.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;
import org.springframework.web.servlet.view.RedirectView;

import springapp.dao.BoardVo;
import springapp.dao.JdbcTemplateBoardDao;

public class BoardUpdateActionCommandController extends AbstractCommandController {

	private JdbcTemplateBoardDao boardDao;
	
	public void setBoardDao(JdbcTemplateBoardDao boardDao){
		this.boardDao = boardDao;
	}
	
	protected ModelAndView handle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, BindException arg3) throws Exception {
		BoardVo vo = (BoardVo)arg2;
		boardDao.update(vo);
		//RedirectView 뷰를 자동으로 이동하게 해주는 클래스
		return new ModelAndView(new RedirectView("board_list.do"));
	}
	
}
