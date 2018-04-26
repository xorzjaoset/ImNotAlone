package moon.dto;

public class RoomPtDTO {

	private int rp_board_no;
	private String rp_id;
	private String rp_img_no;
	private String rp_path;
	private String rp_oname;
	private String rp_sname;
	private int rp_img_size;
	
	
	public RoomPtDTO() {}
	
	public RoomPtDTO(int rp_board_no, String rp_id, String rp_img_no, String rp_path, String rp_oname, String rp_sname,
			int rp_img_size) {
		super();
		this.rp_board_no = rp_board_no;
		this.rp_id = rp_id;
		this.rp_img_no = rp_img_no;
		this.rp_path = rp_path;
		this.rp_oname = rp_oname;
		this.rp_sname = rp_sname;
		this.rp_img_size = rp_img_size;
	}
	public int getRp_board_no() {
		return rp_board_no;
	}
	public void setRp_board_no(int rp_board_no) {
		this.rp_board_no = rp_board_no;
	}
	public String getRp_id() {
		return rp_id;
	}
	public void setRp_id(String rp_id) {
		this.rp_id = rp_id;
	}
	public String getRp_img_no() {
		return rp_img_no;
	}
	public void setRp_img_no(String rp_img_no) {
		this.rp_img_no = rp_img_no;
	}
	public String getRp_path() {
		return rp_path;
	}
	public void setRp_path(String rp_path) {
		this.rp_path = rp_path;
	}
	public String getRp_oname() {
		return rp_oname;
	}
	public void setRp_oname(String rp_oname) {
		this.rp_oname = rp_oname;
	}
	public String getRp_sname() {
		return rp_sname;
	}
	public void setRp_sname(String rp_sname) {
		this.rp_sname = rp_sname;
	}
	public int getRp_img_size() {
		return rp_img_size;
	}
	public void setRp_img_size(int rp_img_size) {
		this.rp_img_size = rp_img_size;
	}
	
	
	
}
