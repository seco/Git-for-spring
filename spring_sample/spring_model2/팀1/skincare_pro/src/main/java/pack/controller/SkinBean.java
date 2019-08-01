package pack.controller;

public class SkinBean {
	private String time_reserve_no, prog_order_no, reserve_date, time_unit, careManager_no;

	public String getTime_reserve_no() {
		return time_reserve_no;
	}
	public void setTime_reserve_no(String time_reserve_no) {
		this.time_reserve_no = time_reserve_no;
	}
	public String getCareManager_no() {
		return careManager_no;
	}
	public void setCareManager_no(String careManager_no) {
		this.careManager_no = careManager_no;
	}
	public String getProg_order_no() {
		return prog_order_no;
	}
	public void setProg_order_no(String prog_order_no) {
		this.prog_order_no = prog_order_no;
	}
	
	public String getReserve_date() {
		return reserve_date;
	}

	public void setReserve_date(String reserve_date) {
		this.reserve_date = reserve_date;
	}

	public String getTime_unit() {
		return time_unit;
	}

	public void setTime_unit(String time_unit) {
		this.time_unit = time_unit;
	}
}