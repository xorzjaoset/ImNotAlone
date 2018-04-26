package ho.service;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ho.dto.MemberDTO;
import ho.model.MemberDAO;

@Service
public class LoginService implements LoginServiceInterface {

	@Autowired
	MemberDAO dao;
	
	public MemberDTO getUserInformation(MemberDTO dto) {
		dto = dao.getUserInformation(dto);
		return dto;
	}
 

	public int login(MemberDTO dto) {

		String userPasswd = dao.checkUser(dto.getUser_email());

		if (userPasswd != null) {
			if (dto.getUser_password().equals(userPasswd)) {
				return 1; // 로그인성공
			} else {
				return 2; // 비밀번호 틀림
			}

		} else {
			return 0; // 회원정보가 없음.
		}
	}

	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}

	public String register(MemberDTO dto) {
		
		if(dao.registerUser(dto)==1) {
		return "임무성공";
		}
		return "임무실패";
	}


	@Override
	public MemberDTO jsonToString(String apiResult) {
		MemberDTO member = null;
		
		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObj = (JSONObject) jsonParser.parse(apiResult);
			System.out.println(jsonObj+"11111");
			System.out.println(jsonObj.get("response")+"2222");
			JSONObject tempObj = (JSONObject) jsonObj.get("response");
			
			System.out.println(tempObj.get("name")+" "+tempObj.get("email")+tempObj.get("age")+"!!!!!");
			
			
			String user_email = (String) tempObj.get("email");
			String user_age = (String) tempObj.get("age");
			String user_name = (String) tempObj.get("name");
			String user_gender = (String) tempObj.get("gender");
			String id= (String) tempObj.get("email");
			int index = id.indexOf("@");
			String user_id = id.substring(0, index);
			member = new MemberDTO(user_id, user_name, user_email, user_gender, user_age);
			
			
		        } catch (ParseException e) {
					e.printStackTrace();
				}
				
//			if(result == 1) {
//				member = loginService.getUserInformation(member);
//			//	redirectAttr.addFlashAttribute("member",member);  //데이터를 보내고 사라짐.
//				session.setAttribute("member", member);   //세션값 데이터 저장.
//				return "redirect:/share/main/mainView"; //로그인 성공
//				
//			}else if(result == 2){
//				System.out.println("로그인 실패, 패스워드 불일치");
//				return "redirect:/share/login"; //패스워드 불일치
//			}else {
//				System.out.println("로그인 실패, 회원정보 없음 or 이메일이 틀림");
//				return "redirect:/share/login"; //회원정보 없음 
//			}
		return member;
	}
}
