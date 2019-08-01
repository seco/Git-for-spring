package springapp.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import springapp.dao.BoardVo;
import springapp.dao.JdbcTemplateBoardDao;

public class BoardUpdateController implements Controller {

	private JdbcTemplateBoardDao boardDao;
	
	public void setBoardDao(JdbcTemplateBoardDao boardDao){
		this.boardDao = boardDao;
	}
	
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		BoardVo vo = null;
		String seq = arg0.getParameter("seq");
		vo = boardDao.findBySeq(seq);
		
		arg0.setAttribute("boardVo", vo);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("update");
		
		return modelAndView;
	}
	
}
