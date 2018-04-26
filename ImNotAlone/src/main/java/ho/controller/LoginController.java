package ho.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ho.dto.MemberDTO;
import ho.service.LoginServiceInterface;

import com.github.scribejava.core.model.OAuth2AccessToken;
@Controller
public class LoginController {
	
	@Autowired
	LoginServiceInterface loginService;
	
	@RequestMapping(value="/login",  method = { RequestMethod.GET, RequestMethod.POST })
	public String loginForm(Model model, HttpSession session) {
		
		/* ���̹����̵�� ���� URL�� �����ϱ� ���Ͽ� naverLoginBOŬ������ getAuthorizationUrl�޼ҵ� ȣ�� */
        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
        
        //https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
        //redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
        System.out.println("���̹�:" + naverAuthUrl);
        
        //���̹� 
        model.addAttribute("url", naverAuthUrl);

        /* ������ ���� URL�� View�� ���� */
        
		return "loginForm";
	}
	
	@RequestMapping(value="/logout",method = { RequestMethod.GET, RequestMethod.POST })
	public String logoutMainView(HttpSession session) {
		MemberDTO.getRecent_list().clear();  //�ֱ� ����Ʈ ����
		session.invalidate();
		return "mainView";
	}
	
	@RequestMapping(value="/login1",method = { RequestMethod.GET, RequestMethod.POST })
	public String loginForm2(HttpSession session, MemberDTO member, Model model, 
			RedirectAttributes redirectAttr) {
		
		int result = loginService.login(member);
		if(result == 1) {
			member = loginService.getUserInformation(member);
//			redirectAttr.addFlashAttribute("member",member);  //�����͸� ������ �����.
			session.setAttribute("member", member);   //���ǰ� ������ ����.
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
	
	
	
	
	
	/////////////////////////////////////////���̹� �α��� �κ�
	 /* NaverLoginBO */
    private NaverLoginBO naverLoginBO;
    private String apiResult = null;
    
    @Autowired
    private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
        this.naverLoginBO = naverLoginBO;
    }

    //�α��� ù ȭ�� ��û �޼ҵ�
    @RequestMapping(value = "/naverlogin", method = { RequestMethod.GET, RequestMethod.POST })
    public String login(Model model, HttpSession session) {
        
        /* ���̹����̵�� ���� URL�� �����ϱ� ���Ͽ� naverLoginBOŬ������ getAuthorizationUrl�޼ҵ� ȣ�� */
        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
        
        //https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
        //redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
        System.out.println("���̹�:" + naverAuthUrl);
        
        //���̹� 
        model.addAttribute("url", naverAuthUrl);

        /* ������ ���� URL�� View�� ���� */
        return "NaverLogin";
    }

    //���̹� �α��� ������ callbackȣ�� �޼ҵ�
    @RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
    public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
            throws IOException {
        System.out.println("����� callback");
        OAuth2AccessToken oauthToken;
        oauthToken = naverLoginBO.getAccessToken(session, code, state);
        //�α��� ����� ������ �о�´�.
        apiResult = naverLoginBO.getUserProfile(oauthToken);
        System.out.println(naverLoginBO.getUserProfile(oauthToken).toString());
        model.addAttribute("result", apiResult);
        System.out.println("result"+apiResult);

        //���̹� �α���
        MemberDTO member = loginService.jsonToString(apiResult);
        session.setAttribute("member", member);
        System.out.println(member);
        
        return "redirect:/share/main/mainView";
    }
}
