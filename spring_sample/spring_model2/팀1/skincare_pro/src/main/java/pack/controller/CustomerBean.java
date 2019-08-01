package pack.controller;

public class CustomerBean { //추가, 수정 작업이 있다면 code, sang, su, dan 처리
	//여기선 검색만함. 수정 추가 앞 프로젝트에서 했기때문에 생략함.
			
	private String c_no, c_name, c_phone;	
	
	
	public String getC_no() {
		return c_no;
	}

	public void setC_no(String c_no) {
		this.c_no = c_no;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_phone() {
		return c_phone;
	}

	public void setC_phone(String c_phone) {
		this.c_phone = c_phone;
	}

	

	private String searchValue;  //검색변수
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	
	public String getSearchValue() {
		return searchValue;
	}

}