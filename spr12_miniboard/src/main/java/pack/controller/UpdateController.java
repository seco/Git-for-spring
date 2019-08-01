package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pack.model.BoardDao;

@Controller
public class UpdateController {
	@Autowired
	private BoardDao dao;
	
	@RequestMapping("update")
	public String update(BoardBean bean) {
		int b = dao.update(bean);
		if (b > 0)
			return "redirect:/list"; //list Controller 만남
		else
			return "redirect:/error.jsp"; //root에서 찾음
	}
}
