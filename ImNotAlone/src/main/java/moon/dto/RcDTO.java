package moon.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.web.multipart.MultipartFile;

public class RcDTO {
	
	private String rc_no;
	private String rc_id;
	private String rc_content;
	private String rc_date;
	private String mp_pn;
	private MultipartFile file;
	
	
	public RcDTO() {
		 super();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		 setRc_date(sdf.format(new Timestamp(System.currentTimeMillis())));
		
		
	}
	

	public RcDTO(String rc_no, String rc_id, String rc_content, String rc_date, String mp_pn, MultipartFile file) {
		super();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		 setRc_date(sdf.format(new Timestamp(System.currentTimeMillis())));
		this.rc_no = rc_no;
		 this.rc_id = rc_id;
		this.rc_content = rc_content;
		this.rc_date = rc_date;
		this.mp_pn = mp_pn;
		this.file = file;
	}


	public String getRc_no() {
		return rc_no;
	}


	public void setRc_no(String rc_no) {
		this.rc_no = rc_no;
	}


	public String getMp_pn() {
		return mp_pn;
	}


	public void setMp_pn(String mp_pn) {
		this.mp_pn = mp_pn;
	}


	public String getRc_date() {
		return rc_date;
	}
	public void setRc_date(String rc_date) {
		this.rc_date = rc_date;
	}
	public String getRc_id() {
		return rc_id;
	}
	public void setRc_id(String rc_id) {
		this.rc_id = rc_id;
	}
	public String getRc_content() {
		return rc_content;
	}
	public void setRc_content(String rc_content) {
		this.rc_content = rc_content;
	}
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}
