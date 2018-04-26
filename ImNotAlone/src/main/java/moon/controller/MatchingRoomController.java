package moon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ho.dto.MemberDTO;
import moon.dto.MtRoomDTO;
import moon.dto.ProfileDTO;
import moon.dto.roomUpDTO;
import moon.service.MtService;

@Controller
public class MatchingRoomController {
	
	@Autowired
	MtService service;

	
	@RequestMapping(value="/moon/mtRoom",method=RequestMethod.GET)
	public String matchingForm(@ModelAttribute roomUpDTO dto,HttpSession session, Model model) {

		MemberDTO member = (MemberDTO)session.getAttribute("member");
		model.addAttribute("dto",dto);
		String mp_id = member.getUser_id();
		System.out.println("매칭:"+mp_id);
		
		
		int result = service.hostcheck(mp_id);
		
		if(result == 1) {//호스트일 경우 방 신청 인원현황 보여준다. 아직 안됨~
			
			return "matchingRoom";
			
		}else {
			//게스트일 경우 내가 매칭신청한 목록들 보여준다.
			
			return "mtRoomGuest";
		}
		
		
		
		
	}
	@RequestMapping(value="/moon/matchsub",method=RequestMethod.POST)
	public String matchsubForm(MtRoomDTO dto) {
		
		service.insertMtRoom(dto);
		
		return "redirect:/share/moon/roomdetail";
	}

	
	@RequestMapping(value="/mtPro.do",method=RequestMethod.GET)
	public ModelAndView form(String mt_id) {
	
		ModelAndView mv = new ModelAndView();
		ProfileDTO dto = service.getArticle(mt_id);
		mv.addObject("mtPro",dto);
		mv.setViewName("mtRoomPro");
		System.out.println(mv.toString());
		return mv;
	}

}
