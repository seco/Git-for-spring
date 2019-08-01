package springapp.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import springapp.dao.BoardVo;
import springapp.dao.JdbcTemplateBoardDao;

public class BoardDeleteActionCommandController extends AbstractCommandController {

	private JdbcTemplateBoardDao boardDao;
	public void setBoardDao(JdbcTemplateBoardDao boardDao){
		this.boardDao = boardDao;
	}
	
	protected ModelAndView handle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, BindException arg3) throws Exception {
		BoardVo vo = (BoardVo)arg2;
		boardDao.delete(vo.getSeq(), vo.getGroups());
		
		return new ModelAndView("redirect:board_list.do");
	}
	
}
