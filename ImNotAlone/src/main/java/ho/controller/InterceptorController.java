package ho.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ho.dto.MemberDTO;
@Controller
public class InterceptorController extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("----------------------interceptor 실행----------------------");
		System.out.println("prehandle 실행0");
		
		if(checkMember(request)) {
			System.out.println("prehandle 실행1");
			intoRegisterPage(request,response);
			System.out.println("----------------------interceptor 종료----------------------");
			return false;
		}else {
			System.out.println("prehandle 실행2");
			System.out.println("----------------------interceptor 종료----------------------");
			return true;
		}
	}

	private boolean checkMember(HttpServletRequest request) {
		MemberDTO member = (MemberDTO) request.getSession().getAttribute("member");
		System.out.println("checkmember실행");
		System.out.println(member);
		if(member == null) {
			System.out.println("checkmember실행1");
			return true;
		}else {
		System.out.println("checkmember실행2");
		return false;
		}
	}
	
	
	
	private void intoRegisterPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.sendRedirect("login");
	}
	
	
	
}
