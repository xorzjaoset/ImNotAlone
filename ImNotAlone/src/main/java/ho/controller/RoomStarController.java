package ho.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ho.dto.CommentDTO;
import ho.dto.MemberDTO;
import ho.dto.RoomStarDTO;
import ho.dto.WishListDTO;
import ho.service.RoomServiceInterface;
import ho.vo.PageVO;
import net.sf.json.JSONObject;

@Controller
public class RoomStarController {

	@Autowired
	RoomServiceInterface rsService;

	@RequestMapping(value = "/roomStar", method = RequestMethod.GET)
	public String roomStarView() {
			
		return "roomStarView";
	}

	@RequestMapping(value = "/roomStar2", method = RequestMethod.GET)
	public String roomStarView2() {
		return "roomStarView2";
	}

	@RequestMapping(value = "/roomStar3", method = RequestMethod.GET)
	public String roomStarView3() {
		return "roomStarView3";
	}
	
	
	
	@RequestMapping(value="/roomStar4")
	public String roomStarView5(@RequestParam(defaultValue="1", value="pageNum",
		required=false)String pageNum, MemberDTO member, Model model) {
		System.out.println("아이디 값 확인(2) : " + member.getUser_id());
		PageVO vo = new PageVO();
		List<RoomStarDTO> contentsList;
		
		vo.setTotalCount(rsService.getCountList());
		vo.setPageNum(Integer.parseInt(pageNum));
		vo.makePaging();
		contentsList = rsService.getListContents(vo);
		String checkWish = rsService.getWishListCheck(member.getUser_id());
		
		model.addAttribute("checkWish", checkWish); 
		model.addAttribute("bst_contents", contentsList);
		model.addAttribute("pageVO", vo);
		
		
		return "roomStarView4";
	}
		
	
	
	
	
	@RequestMapping(value = "/roomStarRegisterForm", method = RequestMethod.GET)
	public String registerForm(HttpSession session) {
		return "roomStarRegisterForm";
	}
	
	@RequestMapping(value = "/roomStarReviewView", method = RequestMethod.GET)
	public String contentReView(MemberDTO member) {
		System.out.println("아이디 값 확인(2) : " + member.getUser_id());
		return "roomStarReviewView";
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
	
	@RequestMapping(value = "/roomStarContentView", method = RequestMethod.GET)
	public String contentView(MemberDTO member, RoomStarDTO roomStarDTO, 
			CommentDTO commentDTO, Model model) {
		System.out.println("아이디 값 확인(2) : " + member.getUser_id());
		
		System.out.println("방번호 확인 ::::"+roomStarDTO.getBst_board_no());
		List<RoomStarDTO> imgList = new ArrayList<RoomStarDTO>();
		List<CommentDTO> cmList = new ArrayList<CommentDTO>();
		
		roomStarDTO = rsService.getBstContents(roomStarDTO);
		imgList = rsService.getBstImages(roomStarDTO);
		cmList = rsService.getCommentList(commentDTO);
		System.out.println(roomStarDTO.getBst_board_no()+"!!!!!!!!!");
		int likeCount = rsService.getLikeCount(roomStarDTO.getBst_board_no());
		
		
		model.addAttribute("likeCount", likeCount);
		model.addAttribute("contents", roomStarDTO);
		model.addAttribute("type_of_list", roomStarDTO.getType_of()); //list타입
		model.addAttribute("imgList", imgList);
		model.addAttribute("cmList", cmList);
		
		
		
		System.out.println("---------확인--------");
		System.out.println(roomStarDTO);
		System.out.println(imgList);
		System.out.println("---------확인--------");
		
		return "roomStarContentView";
	}
	
	
	@RequestMapping(value="/roomStarUpload")
	public String fileUpload(RoomStarDTO roomStarDTO) throws Exception {
		
		String result = rsService.contentsUpload(roomStarDTO);
		System.out.println(result);
		return "redirect:/share/roomStar4";
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/registerComment", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public String registerComment(HttpServletResponse resp, MemberDTO member, CommentDTO commentDTO) throws Exception {
		resp.setContentType("text/html; charset=UTF-8");

		commentDTO = new CommentDTO(commentDTO.getBst_by_id(), commentDTO.getBst_board_no(),commentDTO.getDg_comment(), member.getUser_id());
		System.out.println("commentDTO확인 :" + commentDTO);
		rsService.insertComment(commentDTO);
		
		 JSONObject jso = new JSONObject();
		 jso.put("dg_comment", commentDTO.getDg_comment());
		 jso.put("dg_by_id", commentDTO.getDg_by_id());
		 jso.put("dg_board_date", commentDTO.getDg_board_date());

		return jso.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/addWishList")
	public String addWishList(HttpServletResponse resp, MemberDTO member, WishListDTO wishDTO) {
		resp.setContentType("text/html; charset=UTF-8");	
		if(member.getUser_id().equals("guest")) {
		 JSONObject jso = new JSONObject();
		 jso.put("goBackToLogin",2);
		return jso.toString();
		}else {
		wishDTO = new WishListDTO(member.getUser_id(), wishDTO.getBst_board_no());
		String result = rsService.addWishList(wishDTO);
		System.out.println(result);
		return null;
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/oddWishList")
	public String oddWishList(HttpServletResponse resp, MemberDTO member, WishListDTO wishDTO) {
		resp.setContentType("text/html; charset=UTF-8");	
		if(member.getUser_id().equals("guest")) {
			 JSONObject jso = new JSONObject();
			 jso.put("goBackToLogin",2);
			return jso.toString();
		}else {
		wishDTO = new WishListDTO(member.getUser_id(), wishDTO.getBst_board_no());
		String result = rsService.oddWishList(wishDTO);
		System.out.println(result);
		JSONObject jso = new JSONObject();
		jso.put("check",1);
		return jso.toString();
		}
	}
	
	
}