package ho.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class WishListDTO {
	private String user_id;
	private int bst_board_no;
	private String wish_date;

	public WishListDTO() {
		super();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		setWish_date(sdf.format(new Timestamp(System.currentTimeMillis())));
	}
	
	public WishListDTO(String user_id, int bst_board_no) {
		super();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		setWish_date(sdf.format(new Timestamp(System.currentTimeMillis())));
		this.user_id = user_id;
		this.bst_board_no = bst_board_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getBst_board_no() {
		return bst_board_no;
	}

	public void setBst_board_no(int bst_board_no) {
		this.bst_board_no = bst_board_no;
	}

	public String getWish_date() {
		return wish_date;
	}

	public void setWish_date(String wish_date) {
		this.wish_date = wish_date;
	}

	@Override
	public String toString() {
		return "WishListDTO [user_id=" + user_id + ", bst_board_no=" + bst_board_no + ", wish_date=" + wish_date
				+ ", getUser_id()=" + getUser_id() + ", getBst_board_no()=" + getBst_board_no() + ", getWish_date()="
				+ getWish_date() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
}
