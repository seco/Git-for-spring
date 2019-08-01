package aa.bb.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SangpumController {
	@Autowired
	@Qualifier("sangpumModel")
	private SangpumModel sangpumModel;
	
	@RequestMapping(value="sangpum", method=RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute("my") SangpumBean bean){
		ModelAndView view = new ModelAndView();
		view.setViewName("result");
		view.addObject("data", sangpumModel.compute(bean));
		return view;
	}
}
