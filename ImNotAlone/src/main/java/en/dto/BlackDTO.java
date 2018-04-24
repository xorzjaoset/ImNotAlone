package en.dto;

import java.sql.Date;

public class BlackDTO {

	private int no;
	private String id;
	private Date reg_dt;
	private String reason;
	private Date release;

	
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getRelease() {
		return release;
	}

	public void setRelease(Date release) {
		this.release = release;
	}

	
	@Override
	public String toString() {
		return "BlackDTO [no=" + no + ", id=" + id + ", reg_dt=" + reg_dt + ", reason=" + reason + ", release="
				+ release + "]";
	}

}
