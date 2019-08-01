package pack.model;

public class ReserveDto {
	private String time_reserve_no, emp_no, emp_name, prog_order_no, pro_name, reserve_date, time_unit, time_avail,
			pro_order_cnt, pro_order_reserve_cnt;

	public String getTime_reserve_no() {
		return time_reserve_no;
	}

	public void setTime_reserve_no(String time_reserve_no) {
		this.time_reserve_no = time_reserve_no;
	}

	public String getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public String getPro_name() {
		return pro_name;
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

	public String getTime_avail() {
		return time_avail;
	}

	public void setTime_avail(String time_avail) {
		this.time_avail = time_avail;
	}

	public String getPro_order_cnt() {
		return pro_order_cnt;
	}

	public void setPro_order_cnt(String pro_order_cnt) {
		this.pro_order_cnt = pro_order_cnt;
	}

	public String getPro_order_reserve_cnt() {
		return pro_order_reserve_cnt;
	}

	public void setPro_order_reserve_cnt(String pro_order_reserve_cnt) {
		this.pro_order_reserve_cnt = pro_order_reserve_cnt;
	}

}
