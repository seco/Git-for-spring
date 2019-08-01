package pack.model;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {  // FileDto
	
	private MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}
	
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}
