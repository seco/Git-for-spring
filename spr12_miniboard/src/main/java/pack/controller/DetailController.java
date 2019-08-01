package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.Board;
import pack.model.BoardDao;

@Controller
public class DetailController {
	@Autowired
	private BoardDao dao;
	
	@RequestMapping("detail")
	public ModelAndView detail(@RequestParam("num") String num) {
		Board board = new Board();
		dao.addCount(num);
		board = dao.detail(num);
		return new ModelAndView("detail","board",board);
	}
}
