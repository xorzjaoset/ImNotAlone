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
		System.out.println("----------------------interceptor ����----------------------");
		System.out.println("prehandle ����0");
		
		if(checkMember(request)) {
			System.out.println("prehandle ����1");
			intoRegisterPage(request,response);
			System.out.println("----------------------interceptor ����----------------------");
			return false;
		}else {
			System.out.println("prehandle ����2");
			System.out.println("----------------------interceptor ����----------------------");
			return true;
		}
	}

	private boolean checkMember(HttpServletRequest request) {
		MemberDTO member = (MemberDTO) request.getSession().getAttribute("member");
		System.out.println("checkmember����");
		System.out.println(member);
		if(member == null) {
			System.out.println("checkmember����1");
			return true;
		}else {
		System.out.println("checkmember����2");
		return false;
		}
	}
	
	
	
	private void intoRegisterPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.sendRedirect("login");
	}
	
	
	
}
