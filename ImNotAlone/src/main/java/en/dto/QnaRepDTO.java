package en.dto;

import java.sql.Date;

public class QnaRepDTO {

	private String no;
	private String rep_no;
	private String id;
	private String rep_content;
	private Date rep_reg_tm;
	
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getRep_no() {
		return rep_no;
	}
	public void setRep_no(String rep_no) {
		this.rep_no = rep_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRep_content() {
		return rep_content;
	}
	public void setRep_content(String rep_content) {
		this.rep_content = rep_content;
	}
	public Date getRep_reg_tm() {
		return rep_reg_tm;
	}
	public void setRep_reg_tm(Date rep_reg_tm) {
		this.rep_reg_tm = rep_reg_tm;
	}
	
	
	@Override
	public String toString() {
		return "QnaRepDTO [no=" + no + ", rep_no=" + rep_no + ", id=" + id + ", rep_content=" + rep_content
				+ ", rep_reg_tm=" + rep_reg_tm + "]";
	}
	
	
	
	
}
