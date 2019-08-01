package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.ProgramDaoInter;

@Controller
public class ProgramController {
	
	@Autowired
	private ProgramDaoInter daoInter;
	
	@RequestMapping("content")
	public ModelAndView content() {
		System.out.println("컨트롤러 실행");
		
//		return new ModelAndView("programList", "content", daoInter.getDataAll());
//		return new ModelAndView("programList", "programCate", daoInter.getAllCate());
		
		ModelAndView view = new ModelAndView();
		view.setViewName("programList");
		view.addObject("programCate", daoInter.getAllCate());
		System.out.println("1");
		view.addObject("programList", daoInter.getProgramByCate("1"));
		System.out.println("3");
		return view;
	}
	
	@RequestMapping("program_list")
	public ModelAndView programlist(@RequestParam("pro_cate") String pro_cate) {
		System.out.println("list");
		System.out.println("pro_cate: " + pro_cate);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("programList");
		view.addObject("programCate", daoInter.getAllCate());
		view.addObject("programList", daoInter.getProgramByCate(pro_cate));
		return view;
	}
	
	@RequestMapping("program_detail")
	public ModelAndView detail(@RequestParam("pro_no") String pro_no) {
		System.out.println("pro_no: " + pro_no);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("programDetail");
		view.addObject("programCate", daoInter.getAllCate());
		view.addObject("programDetail", daoInter.getProgramDetail(pro_no));
		return view;
	}
	
	@RequestMapping("program_insert")
	public ModelAndView insert() {
		
		List<String> list = daoInter.selectcate();
		
		System.out.println(list.get(0));
		
		return new ModelAndView("program_insert","list",list);
	}
	
	@RequestMapping(value="program_insert", method=RequestMethod.POST)
	public String insert_program(ProgramBean bean) {
		
		System.out.println(bean);
		
		boolean b = daoInter.insertData(bean);
		
		if(b) {
			return "redirect:/program_list?pro_cate=1";
		}
		
		return "program_list";
	}
	
	@RequestMapping(value="programUpdate", method=RequestMethod.GET)
	public ModelAndView form(@RequestParam("pro_no") String pro_no) {
		
		// System.out.println("여기까지 1");
		
		ModelAndView view = new ModelAndView();
		view.setViewName("programUpdate");
		view.addObject("list", daoInter.selectcate());
		view.addObject("data", daoInter.getProgramDetail(pro_no));
		// System.out.println("여기까지 2");
		return view;
	}

	@RequestMapping(value="programUpdate", method=RequestMethod.POST)
	public String programUpdate(ProgramBean bean) {
		boolean b = daoInter.updateData(bean);
		
		if(b) {
			return "redirect:/content";
		}else {
			return "error";
		}
	}
	
	@RequestMapping("programDelete")
	public String delete(@RequestParam("pro_no") String pro_no) {
		
		boolean b = daoInter.deleteData(pro_no);
		
		if(b) {
			return "redirect:/content";
		}else {
			return "error";
		}
		
	}
}
