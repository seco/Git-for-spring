package pack.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import pack.model.ProgramAllDto;
import pack.model.SurgicalInter;

@Controller
public class RegistokController {
	
	@Autowired
	private SurgicalInter surgicalInter;
		
	
	@RequestMapping(value="registok" , method = RequestMethod.POST)
	public ModelAndView regist(ProgramAllBean probean) {
		
		System.out.println("들옴");
		
		surgicalInter.reserveData(probean);
		System.out.println("너가 문제");
		ModelAndView view = new ModelAndView();
		List<ProgramAllDto> prodto = surgicalInter.reservelist();
		view.setViewName("registok");
		view.addObject("probean", probean);
		view.addObject("prodto", prodto);
		
		return view;
	
	}
	
	@RequestMapping(value="registok")
	public ModelAndView regist_gogek(String count, ProgramAllBean probean,HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("너냐 : " + probean.getPro_order_cnt());
		
		probean.setPro_order_cnt(count);
		
		ModelAndView view = new ModelAndView();
		surgicalInter.reserveData_gogek(probean);
		List<ProgramAllDto> prodto = surgicalInter.reservelist_gogek(probean.getGogek_id());
		view.setViewName("registok_gogek");
		view.addObject("prodto", prodto);
		System.out.println(prodto.get(0).getState());
		
		return view;
	
	}
	
	@RequestMapping(value="registok_gogek")
	public ModelAndView regist_list_gogek(String gogek_id,HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView view = new ModelAndView();
		
		List<ProgramAllDto> prodto = surgicalInter.reservelist_gogek(gogek_id);
		view.setViewName("registok_gogek");
		view.addObject("prodto", prodto);
		
		System.out.println(prodto.get(0).getState());
		
		return view;
	
	}
}