
public class EmployeeDetails {

	private String employeName;
	private String checkinTime;
	private String checkouttime;
	private String date;
	private String dept;

	public String getEmployeName() {
		return employeName;
	}

	public void setEmployeName(String employeName) {
		this.employeName = employeName;
	}

	public String getCheckinTime() {
		return checkinTime;
	}

	public void setCheckinTime(String checkinTime) {
		this.checkinTime = checkinTime;
	}

	public String getCheckouttime() {
		return checkouttime;
	}

	public void setCheckouttime(String checkouttime) {
		this.checkouttime = checkouttime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [employeName=" + employeName + ", checkinTime=" + checkinTime + ", checkouttime="
				+ checkouttime + ", date=" + date + ", dept=" + dept + "]";
	}
	
	

}
