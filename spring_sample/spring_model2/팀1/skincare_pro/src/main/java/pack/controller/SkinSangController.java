package pack.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import pack.model.CartSangBean;
import pack.model.SangOrderDto;
import pack.model.SkinDaoInter;
import pack.model.SkinSangDaoInter;
import pack.upload.SkinSangFileValidator;
import pack.upload.SkinSangUploadFile;

@Controller
public class SkinSangController {
	
	@Autowired
	SkinSangDaoInter skinSangDaoInter;
	
	@RequestMapping("skinsang_list")
	public Model list(Model model,HttpServletRequest request, HttpServletResponse response) {
		
		//System.out.println("skinsang_list");
		
		model.addAttribute("data", skinSangDaoInter.getDataAll());
		
		// System.out.println(memDaoInter.getDataAll());
		
		return model;
	}
	
	@RequestMapping("skinsang_list_gogek")
	public Model list_gogek(Model model,HttpServletRequest request, HttpServletResponse response) {
		
		//System.out.println("skinsang_list");
		System.out.println("들어옴?");
		model.addAttribute("data", skinSangDaoInter.getDataAll());
		
		// System.out.println(memDaoInter.getDataAll());
		
		return model;
	}
	
	@RequestMapping(value="skinsang_update", method=RequestMethod.GET)
	public ModelAndView form(@RequestParam("sang_no") String sang_no) {
		//System.out.println(skinSangDaoInter.selectPart(sang_no));
		return new ModelAndView("upform","data", skinSangDaoInter.selectPart(sang_no));
	}
	
	@RequestMapping(value="skinsang_update", method=RequestMethod.POST)
	public String update(SkinSangBean bean) {
		
		System.out.println(bean.getSang_su());
		
		boolean b = skinSangDaoInter.updateData(bean);
		
		if(b) {
			return "redirect:/skinsang_list";
		}else {
			return "error";
		}

	}

	// 파일 유무를 확인하기 위한 Validator
	@Autowired
	private SkinSangFileValidator fileValidator;

	@RequestMapping(value = "skinsang_insert", method = RequestMethod.GET)
	public String form(@ModelAttribute("uploadFile") SkinSangUploadFile uploadFile) {
		return "insform";
	}

	@RequestMapping(value = "skinsang_insert", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute("uploadFile") SkinSangUploadFile uploadFile, BindingResult result) {

		System.out.println("들어는 오나------------");
		System.out.println(uploadFile.getSang_Pname());
		System.out.println(uploadFile.getSang_Bname());
		System.out.println(uploadFile.getSang_detail());
		System.out.println(uploadFile.getSang_price());
		System.out.println(uploadFile.getSang_su());
		System.out.println(uploadFile.getFile().getOriginalFilename());
		System.out.println("BindingResult : " + result);

		InputStream inputStream = null;
		OutputStream outputStream = null;

		// 에러 검사
		MultipartFile file = uploadFile.getFile();

		System.out.println("->" + uploadFile.getFile());
		System.out.println("->" + uploadFile.getFile());

		fileValidator.validate(uploadFile, result);
		System.out.println("여기까진 옴1");

		String fileName = file.getOriginalFilename();

		System.out.println(result.hasErrors());

		if (result.hasErrors()) {
			return new ModelAndView("redirect:/skinsang_list");
		}

		System.out.println("여기까진 옴2");

		try {
			System.out.println("여기까진 옴3");
			inputStream = file.getInputStream();

			File newFile = new File("C:\\Users\\문경영\\eclipse-workspace\\skincare_pro\\src\\main\\webapp\\image\\" + fileName);

			if (!newFile.exists()) {
				newFile.createNewFile();
			}

			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		System.out.println("----------------------------------");

		System.out.println("sql?");
		boolean b = skinSangDaoInter.insertData(uploadFile);
		System.out.println("sql!");
		if (b) {
			return new ModelAndView("redirect:/skinsang_list", "filename", fileName);
		} else {
			return new ModelAndView("err");
		}
	}
	
	@RequestMapping("skinsang_delete")
	public String delete(@RequestParam("sang_no") String sang_no) {
		
		boolean b = skinSangDaoInter.deleteData(sang_no);
		
		if(b) {
			return "redirect:/skinsang_list";
		}else {
			return "error";
		}
		
	}
	
	@RequestMapping("skinsang_detail")
	public Model detail(Model model,@RequestParam("sang_no") String no) {
		//System.out.println(no);
		model.addAttribute("data", skinSangDaoInter.selectPart(no));
		
		// System.out.println(memDaoInter.getDataAll());
		
		return model;
	}
	
	@RequestMapping("skinsang_detail_gogek")
	public Model list_gogek(Model model,@RequestParam("sang_no") String no) {
		//System.out.println(no);
		model.addAttribute("data", skinSangDaoInter.selectPart(no));
		
		// System.out.println(memDaoInter.getDataAll());
		
		return model;
	}
	
	@RequestMapping("sang_order")
	public ModelAndView sangpum_order_one(@ModelAttribute SangOrderDto dto,String count ,HttpServletRequest request,HttpServletResponse response) {
		//System.out.println(no);
		//System.out.println(memDaoInter.getDataAll());
		
		System.out.println("나" + dto.getGogek_id());
		
		dto.setSang_order_cnt(count);
		int max = skinSangDaoInter.sang_order(dto);
		dto.setSang_order_no(max);
		boolean b = skinSangDaoInter.sang_order_one(dto);
		List<SangOrderDto> list = skinSangDaoInter.sang_order_list(dto.getGogek_id());
		
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("list",list);
		view.setViewName("sang_order");
		
		return view;
	}
	
	@RequestMapping("sang_order_jang")
	public ModelAndView sangpum_order(HttpSession session,SangOrderDto dto,HttpServletRequest request,HttpServletResponse response) {
		//System.out.println(no);
		// System.out.println(memDaoInter.getDataAll());
		
		int max = skinSangDaoInter.sang_order(dto);
		List<CartSangBean> list = (List<CartSangBean>)session.getAttribute("cartSangList");
		
		System.out.println("문경영");
		
		for(int i=0; i < list.size(); i++) {
			SangOrderDto sangdto = new SangOrderDto();
			sangdto.setSang_order_no(max);
			sangdto.setSang_no(list.get(i).getSang_no());
			sangdto.setSang_order_cnt(list.get(i).getCount());
			skinSangDaoInter.sang_order_detail(sangdto);
		}
		
		List<SangOrderDto> list2 = skinSangDaoInter.sang_order_list(dto.getGogek_id());
		
		ModelAndView view = new ModelAndView();
		view.setViewName("sang_order");
		view.addObject("list",list2);
		
		return view;
	}
	
	@RequestMapping("sang_order_list")
	public ModelAndView sangpum_order_list(String gogek_id,HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView view = new ModelAndView();
		List<SangOrderDto> list = skinSangDaoInter.sang_order_list(gogek_id);
		view.setViewName("sang_order");
		view.addObject("list",list);
		
		return view;
	}
	
	@RequestMapping("myPage")
	public String myPage() {
		return "myPage";
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////

	
}
