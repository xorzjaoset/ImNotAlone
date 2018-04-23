package ho.dto;

import java.sql.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class MemberDTO {

	private String user_id;
	private String user_password;
	private String user_name;
	private String user_email;
	private Date user_sign_in;
	private static LinkedHashSet<Integer> recent_list = null;
	public MemberDTO(){}


	//게스트일경우
	public MemberDTO(String user_id) {
		super();
		this.user_id = user_id;
	}

	public MemberDTO(String user_id, String user_password, String user_name, String user_email, Date user_sign_in) {
		super();
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_sign_in = user_sign_in;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public Date getUser_sign_in() {
		return user_sign_in;
	}

	public void setUser_sign_in(Date user_sign_in) {
		this.user_sign_in = user_sign_in;
	}
	public static LinkedHashSet<Integer> getRecent_list() {
		if(recent_list == null) {
			recent_list = new LinkedHashSet<Integer>();
		}
		return (LinkedHashSet<Integer>) recent_list;
	}
	@SuppressWarnings("static-access")
	public void setRecent_list(int recentNo) {
		if(recent_list ==null) {
			this.getRecent_list().add(recentNo);
		}
		this.recent_list.add(recentNo);
	}

	@Override
	public String toString() {
		return "MemberDTO [user_id=" + user_id + ", user_password=" + user_password + ", user_name=" + user_name
				+ ", user_email=" + user_email + ", user_sign_in=" + user_sign_in + ", recent_list=" + recent_list
				+ "]";
	}

			
	
	
}
