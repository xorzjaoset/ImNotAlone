package moon.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class MtRoomDTO {
	
	private String mt_no;
	private String mt_id;
	private String mt_date;
	

	public MtRoomDTO() {
		super();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		 setMt_date(sdf.format(new Timestamp(System.currentTimeMillis())));
	}
	
	public MtRoomDTO(String mt_no, String mt_id, String mt_date) {
		super();
		
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		 setMt_date(sdf.format(new Timestamp(System.currentTimeMillis())));
		this.mt_no = mt_no;
		this.mt_id = mt_id;
		this.mt_date = mt_date;
	}
	public String getMt_no() {
		return mt_no;
	}
	public void setMt_no(String mt_no) {
		this.mt_no = mt_no;
	}
	public String getMt_id() {
		return mt_id;
	}
	public void setMt_id(String mt_id) {
		this.mt_id = mt_id;
	}
	public String getMt_date() {
		return mt_date;
	}
	public void setMt_date(String mt_date) {
		this.mt_date = mt_date;
	}
	

}
