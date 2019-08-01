package pack.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.MysangDto;
import pack.model.SkinSangDaoInter;

@Controller
public class MysangController {
	
	@Autowired
	SkinSangDaoInter skinSangDaoInter;
	
	@RequestMapping("mysang")
	public ModelAndView mysangpum(@RequestParam("gogek_id") String gogek_id,HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println(request.getParameter("flage"));
		if(request.getParameter("flage") == null) {
			
		}else {
			String sang_no = request.getParameter("sang_no");
			String sang_Pname = request.getParameter("sang_Pname");
			String sang_su = request.getParameter("count");
			
			MysangDto dto = new MysangDto();
			dto.setGogek_id(gogek_id);
			dto.setSang_no(sang_no);
			dto.setSang_Pname(sang_Pname);
			dto.setSang_su(sang_su);
			skinSangDaoInter.insertMysang(dto);
		}
		System.out.println("hi");
		List<MysangDto> list = skinSangDaoInter.mysang(gogek_id);			
		System.out.println("bye");
		
		System.out.println("list" + list.size());
		
		return new ModelAndView("redirect:/skinsang_list_gogek","list",list);
	}
}
