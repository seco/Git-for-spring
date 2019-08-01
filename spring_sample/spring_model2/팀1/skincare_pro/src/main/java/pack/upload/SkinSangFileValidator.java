package pack.upload;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

//파일 유무를 확인하기 위한 Validator
@Service
public class SkinSangFileValidator implements Validator{
	
	public boolean supports(Class<?> arg0) {  // 뭔가 넘어오는게 없어서 아무작업도 안함.
		return false;
	}
	
	public void validate(Object uploadFile, Errors errors) {
		// 파일 업로드를 위한 FileUpload
		SkinSangUploadFile file = (SkinSangUploadFile)uploadFile;
		
		System.out.println(file.getFile());
		
		if(file.getFile().getSize() == 0) {
			errors.rejectValue("file", "", "업로드할 파일을 선택하시오");
		}
	}
}
