package pack.model;

public class TimeDto {
	private String time_no, time_avail, time_unit, prog_order_no, reserve_date;

	public String getProg_order_no() {
		return prog_order_no;
	}
	public void setProg_order_no(String prog_order_no) {
		this.prog_order_no = prog_order_no;
	}
	public String getTime_no() {
		return time_no;
	}

	public void setTime_no(String time_no) {
		this.time_no = time_no;
	}

	public String getTime_avail() {
		return time_avail;
	}

	public void setTime_avail(String time_avail) {
		this.time_avail = time_avail;
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
