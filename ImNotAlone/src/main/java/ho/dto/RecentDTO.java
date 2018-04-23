package ho.dto;

public class RecentDTO {

	private String user_id;
	private int bst_board_no;
	
	RecentDTO(){}
	
	public RecentDTO(String user_id, int bst_board_no) {
		super();
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
	@Override
	public String toString() {
		return "RecentDTO [user_id=" + user_id + ", bst_board_no=" + bst_board_no + "]";
	}
	
	
}
