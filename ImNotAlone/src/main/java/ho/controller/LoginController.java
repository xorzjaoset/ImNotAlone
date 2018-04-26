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
		
		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
        
        //https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
        //redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
        System.out.println("네이버:" + naverAuthUrl);
        
        //네이버 
        model.addAttribute("url", naverAuthUrl);

        /* 생성한 인증 URL을 View로 전달 */
        
		return "loginForm";
	}
	
	@RequestMapping(value="/logout",method = { RequestMethod.GET, RequestMethod.POST })
	public String logoutMainView(HttpSession session) {
		MemberDTO.getRecent_list().clear();  //최근 리스트 삭제
		session.invalidate();
		return "mainView";
	}
	
	@RequestMapping(value="/login1",method = { RequestMethod.GET, RequestMethod.POST })
	public String loginForm2(HttpSession session, MemberDTO member, Model model, 
			RedirectAttributes redirectAttr) {
		
		int result = loginService.login(member);
		if(result == 1) {
			member = loginService.getUserInformation(member);
//			redirectAttr.addFlashAttribute("member",member);  //데이터를 보내고 사라짐.
			session.setAttribute("member", member);   //세션값 데이터 저장.
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
	
	
	
	
	
	/////////////////////////////////////////네이버 로그인 부분
	 /* NaverLoginBO */
    private NaverLoginBO naverLoginBO;
    private String apiResult = null;
    
    @Autowired
    private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
        this.naverLoginBO = naverLoginBO;
    }

    //로그인 첫 화면 요청 메소드
    @RequestMapping(value = "/naverlogin", method = { RequestMethod.GET, RequestMethod.POST })
    public String login(Model model, HttpSession session) {
        
        /* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
        
        //https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
        //redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
        System.out.println("네이버:" + naverAuthUrl);
        
        //네이버 
        model.addAttribute("url", naverAuthUrl);

        /* 생성한 인증 URL을 View로 전달 */
        return "NaverLogin";
    }

    //네이버 로그인 성공시 callback호출 메소드
    @RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
    public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
            throws IOException {
        System.out.println("여기는 callback");
        OAuth2AccessToken oauthToken;
        oauthToken = naverLoginBO.getAccessToken(session, code, state);
        //로그인 사용자 정보를 읽어온다.
        apiResult = naverLoginBO.getUserProfile(oauthToken);
        System.out.println(naverLoginBO.getUserProfile(oauthToken).toString());
        model.addAttribute("result", apiResult);
        System.out.println("result"+apiResult);

        //네이버 로그인
        MemberDTO member = loginService.jsonToString(apiResult);
        session.setAttribute("member", member);
        System.out.println(member);
        
        return "redirect:/share/main/mainView";
    }
}
