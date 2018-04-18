package main.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {

	
	@RequestMapping(value="/main/mainView")
	public String mainView(HttpSession session) {
		
		System.out.println("메인.멤버정보확인 : "+session.getAttribute("member"));
		return "mainView";
	}
	
	
}
