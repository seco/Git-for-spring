package springapp.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import springapp.dao.BoardVo;
import springapp.dao.JdbcTemplateBoardDao;

public class BoardDetailController implements Controller {

	private JdbcTemplateBoardDao boardDao;
	
	public void setBoardDao(JdbcTemplateBoardDao boardDao){
		this.boardDao = boardDao;
	}
	
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		BoardVo vo = null;
		String seq = arg0.getParameter("seq");
		vo = boardDao.findBySeq(seq);
		
		String content = vo.getContent();
		
		content = content.replaceAll("\r\n", "<br/>");		//엔터를 <br/>로 바꿈
		content = content.replaceAll("\u0020", "&nbsp;");	//스페이스를 &nbsp;
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("detail");
		modelAndView.addObject("boardVo", vo);
		modelAndView.addObject("content", content);
		
		return modelAndView;
	}
	
}
