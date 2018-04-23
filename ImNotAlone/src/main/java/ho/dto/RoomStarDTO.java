package ho.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class RoomStarDTO {
	private int num;  //필요없음
	private String user_id;
	private int bst_board_no;
	private String bst_title;
	private String bst_contents;
	private Date bst_board_date;
	private int bst_like;
	private int bst_view;
	private String bst_type_of;
	private MultipartFile user_file2;
	private int count;
	private List<MultipartFile> user_file;
	private int bst_img_no;
	private String bst_img_path;
	private String bst_img_oname;
	private String bst_img_sname;
	private long bst_img_size;
	private List<String> type_of;
	private String whoLikes;
	
	public RoomStarDTO() {
		super();
	}
	
	public int getBst_view() {
		return bst_view;
	}

	public void setBst_view(int bst_view) {
		this.bst_view = bst_view;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public List<String> getType_of() {
		return type_of;
	}
	public void setType_of(List<String> type_of) {
		this.type_of = type_of;
	}
	public MultipartFile getUser_file2() {
		return user_file2;
	}
	public void setUser_file2(MultipartFile user_file2) {
		this.user_file2 = user_file2;
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
	public String getBst_title() {
		return bst_title;
	}
	public void setBst_title(String bst_title) {
		this.bst_title = bst_title;
	}
	public String getBst_contents() {
		return bst_contents;
	}
	public void setBst_contents(String bst_contents) {
		this.bst_contents = bst_contents;
	}
	public Date getBst_board_date() {
		return bst_board_date;
	}
	public void setBst_board_date(Date bst_board_date) {
		this.bst_board_date = bst_board_date;
	}
	public int getBst_like() {
		return bst_like;
	}
	public void setBst_like(int bst_like) {
		this.bst_like = bst_like;
	}
	public String getBst_type_of() {
		return bst_type_of;
	}
	public void setBst_type_of(String bst_type_of) {
		this.bst_type_of = bst_type_of;
	}
	public List<MultipartFile> getUser_file() {
		return user_file;
	}
	public void setUser_file(List<MultipartFile> user_file) {
		this.user_file = user_file;
	}
	public int getBst_img_no() {
		return bst_img_no;
	}
	public void setBst_img_no(int bst_img_no) {
		this.bst_img_no = bst_img_no;
	}
	public String getBst_img_path() {
		return bst_img_path;
	}
	public void setBst_img_path(String bst_img_path) {
		this.bst_img_path = bst_img_path;
	}
	public String getBst_img_oname() {
		return bst_img_oname;
	}
	public void setBst_img_oname(String bst_img_oname) {
		this.bst_img_oname = bst_img_oname;
	}
	public String getBst_img_sname() {
		return bst_img_sname;
	}
	public void setBst_img_sname(String bst_img_sname) {
		this.bst_img_sname = bst_img_sname;
	}

	public long getBst_img_size() {
		return bst_img_size;
	}

	public void setBst_img_size(long bst_img_size) {
		this.bst_img_size = bst_img_size;
	}


	public String getWhoLikes() {
		return whoLikes;
	}

	public void setWhoLikes(String whoLikes) {
		this.whoLikes = whoLikes;
	}

	@Override
	public String toString() {
		return "RoomStarDTO [num=" + num + ", user_id=" + user_id + ", bst_board_no=" + bst_board_no + ", bst_title="
				+ bst_title + ", bst_contents=" + bst_contents + ", bst_board_date=" + bst_board_date + ", bst_like="
				+ bst_like + ", bst_view=" + bst_view + ", bst_type_of=" + bst_type_of + ", user_file2=" + user_file2
				+ ", count=" + count + ", user_file=" + user_file + ", bst_img_no=" + bst_img_no + ", bst_img_path="
				+ bst_img_path + ", bst_img_oname=" + bst_img_oname + ", bst_img_sname=" + bst_img_sname
				+ ", bst_img_size=" + bst_img_size + ", type_of=" + type_of + ", whoLikes=" + whoLikes + "]";
	}
}
