package pack.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import pack.model.EmpBean;
import pack.model.EmpDaoInter;
import pack.model.UploadFile;

@Controller
public class UploadController {

	@Autowired
	private EmpDaoInter empDaoInter;
	
	// 파일 유무를 확인하기 위한 Validator
	@Autowired
	private FileValidator fileValidator;
	
	@RequestMapping(value="upload", method=RequestMethod.GET)
	public String getUploadForm(@ModelAttribute("uploadFile") UploadFile uploadFile) {
		return "uploadform";
	}
	
	@RequestMapping(value="upload", method=RequestMethod.POST)
	public String postUploadForm(@ModelAttribute("uploadFile") UploadFile uploadFile, BindingResult result, EmpBean empBean) {
		//System.out.println("empNo: " + empBean.getEmp_no()+ "empName: " + empBean.getEmp_name() + " img:"+empBean.getEmp_img());
	
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		//System.out.println("post upload 호출: uploadFile : " + uploadFile);
		// 에러 검사
		MultipartFile file = uploadFile.getFile();
		//System.out.println("post upload 호출: uploadFile.getFile : " + file);
		fileValidator.validate(uploadFile, result);
		
		String fileName = file.getOriginalFilename();
		//System.out.println("post upload 호출: file.originalFileName : " + fileName);
		if(result.hasErrors()) {
			return "redirect:/uploadform";
		}
		
		try {
			inputStream = file.getInputStream();
			
			File newFile = new File("C:\\Users\\문경영\\eclipse-workspace\\skincare_pro\\src\\main\\webapp\\resources\\images\\", fileName);
			
			if(!newFile.exists()) {
				newFile.createNewFile();
			}
			
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];
			
			while((read = inputStream.read(bytes)) != -1) { // EOF까지 읽는다.
				outputStream.write(bytes, 0, read);	
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (Exception e2) {
				
			}
		}
		
		empBean.setEmp_img(fileName); 
		
		if(empDaoInter.insertEmp(empBean))
			return "redirect:/intro";
		else 
			return "redirect:/err";
	}
}