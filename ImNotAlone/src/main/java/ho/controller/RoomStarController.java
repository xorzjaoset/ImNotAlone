package ho.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ho.dto.CommentDTO;
import ho.dto.MemberDTO;
import ho.dto.RecentDTO;
import ho.dto.RoomStarDTO;
import ho.dto.WishListDTO;
import ho.service.MyPageInterface;
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
	
	
	//리스트 페이지
	@RequestMapping(value="/roomStar4")
	public String roomStarView5(@RequestParam(defaultValue="1", value="pageNum",
		required=false)String pageNum, MemberDTO member, Model model, HttpSession session) {
		System.out.println("아이디 값 확인(2) : " + member.getUser_id());
		PageVO vo = new PageVO();
		List<RoomStarDTO> contentsList = new ArrayList<RoomStarDTO>();
		List<RoomStarDTO> recent_list = new ArrayList<RoomStarDTO>();
		vo.setTotalCount(rsService.getCountList());
		vo.setPageNum(Integer.parseInt(pageNum));
		vo.makePaging();
		contentsList = rsService.getListContents(vo);
		String checkWish = rsService.getWishListCheck(member.getUser_id());
		
		
		model.addAttribute("checkWish", checkWish); 
		model.addAttribute("bst_contents", contentsList);
		model.addAttribute("pageVO", vo);
			
		
		//최근 리스트 가지고오기
		System.out.println("member.getRecent_list() 확인 ::: " + MemberDTO.getRecent_list());
		recent_list = rsService.getContentsList(member);
		model.addAttribute("recent_list",recent_list);

		//누가 좋아요 했는지 가지고 오기
		List<String> whoLikes = new ArrayList<String>();
		
			
		
		
  		return "roomStarView4";
	}
	
	
	
	//컨텐츠 뷰 페이지
	@RequestMapping(value = "/roomStarContentView", method = RequestMethod.GET)
	public String contentView(MemberDTO member, RoomStarDTO roomStarDTO, 
			CommentDTO commentDTO, Model model, RecentDTO recentDTO, 
			HttpSession session) {
		// dto = recentDTO;
		System.out.println("아이디 값 확인(2) : " + member.getUser_id());
		
		System.out.println("방번호 확인 ::::"+roomStarDTO.getBst_board_no());
		List<RoomStarDTO> imgList = new ArrayList<RoomStarDTO>();
		List<CommentDTO> cmList = new ArrayList<CommentDTO>();
		
		roomStarDTO = rsService.getBstContents(roomStarDTO);
		imgList = rsService.getBstImages(roomStarDTO);
		cmList = rsService.getCommentList(commentDTO);
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
		
		
		//bst_view 업데이트
		rsService.updateBstView(roomStarDTO);
		//recent_bst 업데이트
		recentDTO.setUser_id(member.getUser_id());
		recentDTO.setBst_board_no(roomStarDTO.getBst_board_no());
		try {
			rsService.addRecentBst(recentDTO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//recent_bst_t
		member.setRecent_list(roomStarDTO.getBst_board_no());
		session.setAttribute("member", member);
		
		return "roomStarContentView";
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