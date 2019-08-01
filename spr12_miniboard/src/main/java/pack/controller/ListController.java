package pack.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BoardDao;

@Controller
public class ListController {
	@Autowired
	@Qualifier("boardDao")
	private BoardDao dao;
	
	@RequestMapping("list")
	public ModelAndView list() {
		List list = dao.getList();
		//리스트로 리턴받음
		
		return new ModelAndView("list", "list", list);
				//list.jsp 에 list라는 키에 list데이터를 담아서 보냄(뷰파일,키,데이터)
	}
}
