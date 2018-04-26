package moon.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProfileDTO {
	
	private String mp_id;
	private String mp_name;
	private String mp_jumin1;
	private String mp_gender;
	private String mp_phone;
	private String mp_addr1;
	private String mp_job;
	private String mp_pn;
	private String mp_pp;
	private MultipartFile file;
	
	public ProfileDTO() {}
	
	public ProfileDTO(String mp_id, String mp_name, String mp_jumin1, String mp_gender, String mp_phone,
			String mp_addr1, String mp_job, String mp_pn, String mp_pp, MultipartFile file) {
		super();
		this.mp_id = mp_id;
		this.mp_name = mp_name;
		this.mp_jumin1 = mp_jumin1;
		this.mp_gender = mp_gender;
		this.mp_phone = mp_phone;
		this.mp_addr1 = mp_addr1;
		this.mp_job = mp_job;
		this.mp_pn = mp_pn;
		this.mp_pp = mp_pp;
		this.file = file;
	}
	public String getMp_id() {
		return mp_id;
	}
	public void setMp_id(String mp_id) {
		this.mp_id = mp_id;
	}
	public String getMp_name() {
		return mp_name;
	}
	public void setMp_name(String mp_name) {
		this.mp_name = mp_name;
	}
	public String getMp_jumin1() {
		return mp_jumin1;
	}
	public void setMp_jumin1(String mp_jumin1) {
		this.mp_jumin1 = mp_jumin1;
	}
	public String getMp_gender() {
		return mp_gender;
	}
	public void setMp_gender(String mp_gender) {
		this.mp_gender = mp_gender;
	}
	public String getMp_phone() {
		return mp_phone;
	}
	public void setMp_phone(String mp_phone) {
		this.mp_phone = mp_phone;
	}
	public String getMp_addr1() {
		return mp_addr1;
	}
	public void setMp_addr1(String mp_addr1) {
		this.mp_addr1 = mp_addr1;
	}
	public String getMp_job() {
		return mp_job;
	}
	public void setMp_job(String mp_job) {
		this.mp_job = mp_job;
	}
	public String getMp_pn() {
		return mp_pn;
	}
	public void setMp_pn(String mp_pn) {
		this.mp_pn = mp_pn;
	}
	public String getMp_pp() {
		return mp_pp;
	}
	public void setMp_pp(String mp_pp) {
		this.mp_pp = mp_pp;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
}