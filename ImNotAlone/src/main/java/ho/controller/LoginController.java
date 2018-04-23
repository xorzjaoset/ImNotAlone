package ho.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ho.dto.MemberDTO;
import ho.service.LoginService;
import ho.service.LoginServiceInterface;

@Controller
public class LoginController {
	
	@Autowired
	LoginServiceInterface loginService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginForm() {
		return "loginForm";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logoutMainView(HttpSession session) {
		MemberDTO.getRecent_list().clear();  //최근 리스트 삭제
		session.invalidate();
		return "mainView";
	}
	
	@RequestMapping(value="/login1", method=RequestMethod.POST)
	public String loginForm2(HttpSession session, MemberDTO dto, Model model, RedirectAttributes redirectAttr) {
		
		int result = loginService.login(dto);
		if(result == 1) {
			dto = loginService.getUserInformation(dto);
//			redirectAttr.addFlashAttribute("dto",dto);  //데이터를 보내고 사라짐.
			session.setAttribute("member", dto);   //세션값 데이터 저장.
			return "redirect:/share/main/mainView"; //로그인 성공
			
		}else if(result == 2){
			System.out.println("로그인 실패, 패스워드 불일치");
			return "redirect:/share/login"; //패스워드 불일치
		}else {
			System.out.println("로그인 실패, 회원정보 없음 or 이메일이 틀림");
			return "redirect:/share/login"; //회원정보 없음 
		}
		
		
		
	}
	
	
	
	
	
	
	
	@RequestMapping(value="/register")
	public String registerForm(MemberDTO dto) {
		
		return "registerForm";
	}
	
	@RequestMapping(value="/register2")
	public String registerForm2(MemberDTO dto) {
		
		String result = loginService.register(dto);
		System.out.println(result);
		
		return "redirect:/share/main/mainView";
	}
	
	
	
	
	
	
	
	
	
	
	 
}
