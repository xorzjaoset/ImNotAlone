package en.dto;

import java.sql.Date;

public class QnaDTO {
	
	private String no;
	private String id;
	private String title;
	private String content;
	private Date reg_dt;
	private int hit;
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
	@Override
	public String toString() {
		return "QnaDTO [no=" + no + ", id=" + id + ", title=" + title + ", content=" + content + ", reg_dt=" + reg_dt
				+ ", hit=" + hit + "]";
	}
	
	
	
}
