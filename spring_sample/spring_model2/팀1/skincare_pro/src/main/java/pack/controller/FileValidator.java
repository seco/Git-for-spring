package pack.controller;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pack.model.UploadFile;

//파일 유무를 확인하기 위한 Validator
@Service
public class FileValidator implements Validator{
	
	public boolean supports(Class<?> arg0) {
		return false;
	}
	
	public void validate(Object uploadFile, Errors errors) {
		// 파일 업로드를 위한 FileUpload
		UploadFile file = (UploadFile)uploadFile;
		
		if(file.getFile().getSize() == 0) {
			errors.rejectValue("file", "", "업로드할 파일을 선택하시오");
		}
	}
}
