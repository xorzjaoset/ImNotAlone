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
		MemberDTO.getRecent_list().clear();  //�ֱ� ����Ʈ ����
		session.invalidate();
		return "mainView";
	}
	
	@RequestMapping(value="/login1", method=RequestMethod.POST)
	public String loginForm2(HttpSession session, MemberDTO dto, Model model, RedirectAttributes redirectAttr) {
		
		int result = loginService.login(dto);
		if(result == 1) {
			dto = loginService.getUserInformation(dto);
//			redirectAttr.addFlashAttribute("dto",dto);  //�����͸� ������ �����.
			session.setAttribute("member", dto);   //���ǰ� ������ ����.
			return "redirect:/share/main/mainView"; //�α��� ����
			
		}else if(result == 2){
			System.out.println("�α��� ����, �н����� ����ġ");
			return "redirect:/share/login"; //�н����� ����ġ
		}else {
			System.out.println("�α��� ����, ȸ������ ���� or �̸����� Ʋ��");
			return "redirect:/share/login"; //ȸ������ ���� 
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
