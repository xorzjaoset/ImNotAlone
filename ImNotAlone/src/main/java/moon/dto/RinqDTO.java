package moon.dto;

public class RinqDTO {
	
	private int ri_no;
	private String ri_email;
	private String ri_content;
	
	
	public RinqDTO() {}
	
	public RinqDTO(int ri_no, String ri_email, String ri_content) {
		super();
		this.ri_no = ri_no;
		this.ri_email = ri_email;
		this.ri_content = ri_content;
	}
	public int getRi_no() {
		return ri_no;
	}
	public void setRi_no(int ri_no) {
		this.ri_no = ri_no;
	}
	public String getRi_email() {
		return ri_email;
	}
	public void setRi_email(String ri_email) {
		this.ri_email = ri_email;
	}
	public String getRi_content() {
		return ri_content;
	}
	public void setRi_content(String ri_content) {
		this.ri_content = ri_content;
	}
	
	
	

}
