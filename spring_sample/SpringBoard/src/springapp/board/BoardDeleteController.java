package springapp.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import springapp.dao.BoardVo;
import springapp.dao.JdbcTemplateBoardDao;

public class BoardDeleteController implements Controller {

	private JdbcTemplateBoardDao boardDao;
	public void setBoardDao(JdbcTemplateBoardDao boardDao){
		this.boardDao = boardDao;
	}
	
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		String seq = arg0.getParameter("seq");
		BoardVo vo = boardDao.findBySeq(seq);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardVo", vo);
		mav.setViewName("delete");
		return mav;
	}
	
}
