package pack.upload;

import org.springframework.web.multipart.MultipartFile;

public class SkinSangUploadFile {  // FileDto
	
	private MultipartFile file;  // 여러개를 담으려면 List<MultipartFile> 사용
	
	public MultipartFile getFile() {
		return file;
	}
	
	public void setFile(MultipartFile file) {
		this.file = file;
		sang_image = file.getOriginalFilename();
	}
	
	private String sang_Bname,sang_Pname, sang_price, sang_su, sang_detail, sang_image;

	public String getSang_Bname() {
		return sang_Bname;
	}

	public void setSang_Bname(String sang_Bname) {
		this.sang_Bname = sang_Bname;
	}

	public String getSang_Pname() {
		return sang_Pname;
	}

	public void setSang_Pname(String sang_Pname) {
		this.sang_Pname = sang_Pname;
	}

	public String getSang_price() {
		return sang_price;
	}

	public void setSang_price(String sang_price) {
		this.sang_price = sang_price;
	}

	public String getSang_su() {
		return sang_su;
	}

	public void setSang_su(String sang_su) {
		this.sang_su = sang_su;
	}

	public String getSang_detail() {
		return sang_detail;
	}

	public void setSang_detail(String sang_detail) {
		this.sang_detail = sang_detail;
	}

	public String getSang_image() {
		return sang_image;
	}

	public void setSang_image(String sang_image) {
		System.out.println("set : " + file.getOriginalFilename());
		this.sang_image = file.getOriginalFilename();
	}
	
	
}
