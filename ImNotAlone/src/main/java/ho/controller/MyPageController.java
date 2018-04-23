package ho.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ho.dto.MemberDTO;
import ho.dto.RoomStarDTO;
import ho.dto.WishListDTO;
import ho.service.MyPageInterface;

@Controller
public class MyPageController {

	@Autowired
	MyPageInterface mpService;

	public void setMpService(MyPageInterface mpService) {
		this.mpService = mpService;
	}
	
	@ModelAttribute
	public MemberDTO saveMember(HttpSession session) {
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		if(session.getAttribute("member") == null) {
			member = new MemberDTO("guest");
			System.out.println("아이디값 확인(1) : " + member.getUser_id());
			return member;
		}else {
			member = (MemberDTO) session.getAttribute("member");
			return member;
		}
	} 
	
	@RequestMapping(value="/wishList")
		public String wishListView(MemberDTO member, Model model) {
		List<RoomStarDTO> wishList = new ArrayList<RoomStarDTO>();
		wishList = mpService.getContentList(member.getUser_id());
		int wishListCount = mpService.getWishCount(member.getUser_id());	
		
		System.out.println("wishList 확인 " + wishList);
		model.addAttribute("wishList", wishList);
		model.addAttribute("wishListCount", wishListCount);
		
		return "wishListView";
		}

	
	
}
