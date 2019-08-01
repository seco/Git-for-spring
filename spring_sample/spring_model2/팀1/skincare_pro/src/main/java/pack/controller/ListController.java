package pack.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.SkinDaoInter;
import pack.model.SkinSangDaoInter;

@Controller
public class ListController {
	
	// 고객의 예약화면에서 보여줄  time table 가져오는 로직 
	@Autowired
	@Qualifier("skinDaoImpl")
	private SkinDaoInter daoInter;
	
	@RequestMapping("list")
	public ModelAndView timeList(HttpSession session, Model model,HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView();
		
		String gogek_id = (String)session.getAttribute("gogek");
	
		view.addObject("progRsvList", daoInter.getProgRsv(gogek_id)); //
		view.setViewName("list");
		return view;
	}
	
	@RequestMapping("rsvlist")
	public ModelAndView rsvList(HttpSession session) {
		String gogek_id = (String)session.getAttribute("gogek");
	
		ModelAndView view = new ModelAndView();
		
		view.addObject("reserveList", daoInter.getRsvList(gogek_id));
		view.setViewName("rsvlist");
		return view;
	}
	

	@RequestMapping("updateRsv")
	public String submit(SkinBean bean) {
		daoInter.updateRsv(bean);
		return "redirect:/rsvlist";
	}
	
	@RequestMapping("deleteRsv")
	public String delRsv(@RequestParam("time_reserve_no") String time_reserve_no,
						 @RequestParam("prog_order_no") String prog_order_no) {
		daoInter.delRsv(time_reserve_no);
		daoInter.subRsv(prog_order_no);
		return "redirect:/rsvlist";
	}
}
