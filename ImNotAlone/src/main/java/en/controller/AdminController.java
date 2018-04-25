package en.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import en.dto.BlackDTO;
import en.service.BlackListService;

@Controller
public class AdminController {
	
	@Autowired
	BlackListService bws;

	
	@RequestMapping(value = "/blackwait", method = RequestMethod.GET)
	public String blackwait(BlackDTO dto, Model model) {
		System.out.println("블랙대기");

		List<BlackDTO> blackwait = bws.BlackWait(dto);

		model.addAttribute("blackwait", blackwait);
		System.out.println("dto : " + blackwait);

		return "blackwait";

	}
	
	@RequestMapping(value = "/WaitInsert", method = RequestMethod.POST)
	public String waitinsert(@ModelAttribute BlackDTO dto) {
		System.out.println("블랙대기컨트롤러");
		bws.waitinsert(dto);
		return "police112";
	}
	
	@RequestMapping(value = "/blacklist", method = RequestMethod.GET)
	public String blacklist(BlackDTO dto, Model model) {
		System.out.println("블랙확정");

		List<BlackDTO> blacklist = bws.BlackList(dto);

		model.addAttribute("blacklist", blacklist);
		System.out.println("dto : " + blacklist);

		return "blacklist";

	}
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String board() {
		System.out.println("게시판관리");
		return "board";

	}

	@RequestMapping(value = "/superhost", method = RequestMethod.GET)
	public String superhost() {
		System.out.println("슈퍼호스트");
		return "superhost";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() {
		System.out.println("관리자페이지");
		return "admin";
	}
	
	/*@RequestMapping(value = "/police112", method = RequestMethod.GET)
	   public String police112(@RequestParam("id") String id, Model model) {
		System.out.println("신고창");
		
		model.addAttribute("id", id);
		
		return "police112";
	   }*/
	
}