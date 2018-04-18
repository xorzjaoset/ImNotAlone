package ho.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class CommentDTO {

	private String bst_by_id;
	private int bst_board_no;
	private int dg_board_no;
	private String dg_comment;
	private String dg_by_id;
	private String dg_board_date;
	

	public void setDg_board_date(String dg_board_date) {
		this.dg_board_date = dg_board_date;
	}

	public CommentDTO(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		setDg_board_date(sdf.format(new Timestamp(System.currentTimeMillis())));
	}

	public CommentDTO(String bst_by_id, int bst_board_no, String dg_comment, String dg_by_id) {
		super();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		setDg_board_date(sdf.format(new Timestamp(System.currentTimeMillis())));
		this.bst_by_id = bst_by_id;
		this.bst_board_no = bst_board_no;
		this.dg_comment = dg_comment;
		this.dg_by_id = dg_by_id;
	}
 



	public String getDg_board_date() {
		return dg_board_date;
	}

	public String getBst_by_id() {
		return bst_by_id;
	}
	public void setBst_by_id(String bst_by_id) {
		this.bst_by_id = bst_by_id;
	}
	public int getBst_board_no() {
		return bst_board_no;
	}
	public void setBst_board_no(int bst_board_no) {
		this.bst_board_no = bst_board_no;
	}

	public int getDg_board_no() {
		return dg_board_no;
	}
	public void setDg_board_no(int dg_board_no) {
		this.dg_board_no = dg_board_no;
	}
	public String getDg_comment() {
		return dg_comment;
	}
	public void setDg_comment(String dg_comment) {
		this.dg_comment = dg_comment;
	}
	public String getDg_by_id() {
		return dg_by_id;
	}
	public void setDg_by_id(String dg_by_id) {
		this.dg_by_id = dg_by_id;
	}

	@Override
	public String toString() {
		return "CommentDTO [bst_by_id=" + bst_by_id + ", bst_board_no=" + bst_board_no + ", dg_board_no=" + dg_board_no
				+ ", dg_comment=" + dg_comment + ", dg_by_id=" + dg_by_id + ", dg_board_date=" + dg_board_date + "]";
	}

	
}
