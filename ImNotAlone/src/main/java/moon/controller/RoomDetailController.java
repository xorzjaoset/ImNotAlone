package moon.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ho.dto.MemberDTO;
import moon.dto.ProfileDTO;
import moon.dto.RcDTO;
import moon.dto.RinqDTO;
import moon.dto.roomUpDTO;
import moon.service.RcService;
import net.sf.json.JSONObject;

@Controller
public class RoomDetailController {
	
	@Autowired
	RcService service;
	
	

	@RequestMapping(value="/moon/roomdetail",method=RequestMethod.GET)
	public ModelAndView roomdetailForm(String rp_board_no,RedirectAttributes redirectAttr) {
		
		redirectAttr.addFlashAttribute("r_board_no",rp_board_no);

		ModelAndView mv = new ModelAndView();
		roomUpDTO dto = service.getArticle(rp_board_no); // 방 상세정보들 보여주기~ !!!!!
		mv.addObject("roominfo",dto);
		
		List a = service.getComment(rp_board_no);
		
		mv.addObject("comment",a);
		List b = service.getPhoto(rp_board_no);
		System.out.println(b);
		mv.addObject("rp_board_no",rp_board_no);
		mv.addObject("roomphoto",b);
		mv.setViewName("roomDetail");
		
		
		return mv;
		
	}
	@ResponseBody
	@RequestMapping(value="/moon/roomComment",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String insertForm(HttpServletResponse resp, ProfileDTO dto, RcDTO dto1,  HttpSession session,@RequestParam("r_board_no") String r_board_no, @RequestParam("rc_content") String rc_content)throws Exception {
		
		System.out.println("rc_content"+rc_content);
		resp.setContentType("text/html; charset=UTF-8");
		
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		String mp_id = member.getUser_id();
		int result = service.profilecheck(mp_id);
		System.out.println("result:::::::"+result);
		if(result == 1){ //1일 경우 프로필 등록이 되어있기에 댓글 입력하면 등록이 된다
			System.out.println("여기로 오느냐?");
			String rc_id = mp_id;
			String rc_no = r_board_no;
			
			dto1 = new RcDTO();
			dto1.setRc_id(rc_id);
			dto1.setRc_content(rc_content);
			dto1.setRc_no(rc_no);
			
			service.insertComment(dto1);
			
			System.out.println("id::::"+dto1.getRc_id());
			System.out.println("content:::::"+dto1.getRc_content());
			System.out.println("no::::"+dto1.getRc_no());
			
			JSONObject jso = new JSONObject();
			jso.put("rc_content", dto1.getRc_content());
			jso.put("rc_id", dto1.getRc_id());
			jso.put("rc_date", dto1.getRc_date());
			
			return jso.toString();
			
		}else { // 아닌 겨우 프로필 등록 페이지로 넘어간다.
			dto.setMp_id(mp_id);
			String mp_name = member.getUser_name();
			dto.setMp_name(mp_name);
			return "insertProfile";
		}
		
		
		
		
	}
	@RequestMapping(value="/moon/roomInquiry", method=RequestMethod.POST)
	public String insertInquiry(RinqDTO dto) {
		
		service.insertInquiry(dto);
		
		return "redirect:/share/moon/roomdetail";
		
	}
	
}
