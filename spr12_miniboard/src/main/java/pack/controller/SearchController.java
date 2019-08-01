package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BoardDao;

@Controller
public class SearchController {
	@Autowired
	private BoardDao dao;
	
	@ModelAttribute("command") //다른 annotation보다 먼저 실행
	BoardBean init() {
		return new BoardBean();
	}
	@RequestMapping("search")
	public ModelAndView search(BoardBean bean) {
		List list = dao.search(bean);
		return new ModelAndView("list", "list", list );
	}
}
