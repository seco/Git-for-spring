package aa.bb.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import aa.bb.model.HelloModel;

@Service
@ComponentScan("aa.bb.model") //패키지를 스캔가능함
@Controller
public class HelloController {
	@Autowired
	@Qualifier("helloModel") //찾을때 사용할 클래스변수 이름 설정
	private HelloModel helloModel;
	
	@RequestMapping("hello") //index에서 hello요청이 들어오면 hi함수가 받음, get/post구분하지 않음
	public String hi(Model model){
		String result = helloModel.getGreeting();
		
		model.addAttribute("msg", result); //request에 요청함
		return "list"; //뷰 파일
	}
}
