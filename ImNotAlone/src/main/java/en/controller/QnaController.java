package en.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import en.dto.QnaDTO;
import en.dto.QnaRepDTO;
import en.service.QnaRepService;
import en.service.QnaService;
import ho.dto.MemberDTO;

@Controller
public class QnaController {

	@Autowired
	QnaService qnas;
	
	@Autowired
	QnaRepService qrs;

	/*
	 * 문의게시판
	 */
	// 문의게시판 list
	@RequestMapping(value="/qna")
	public ModelAndView qna(ModelAndView modelAndView, HttpSession session) throws Exception {
		System.out.println("문의게시판");
		MemberDTO member = (MemberDTO) session.getAttribute("member");  // session id 돌게함.

		List<QnaDTO> qnalist = qnas.QnaList();
		// ModelAndView - 모델과 뷰
		modelAndView.setViewName("qna"); // 뷰를 qna.jsp로 설정
		modelAndView.addObject("qnalist", qnalist);

		System.out.println("dto : " + qnalist);

		return modelAndView;
	}

	// 문의게시판 write
	@RequestMapping(value="/qnaWrite", method=RequestMethod.GET)
	public String qnaWrite(@ModelAttribute QnaDTO dto, Model model, HttpSession session) {
		System.out.println("문의글쓰기 페이지");

		model.addAttribute("dto", dto);  // 수정버튼 누르면 dto 가져옴.
		
		MemberDTO member = (MemberDTO) session.getAttribute("member");  // session 이용해서 id받아옴
		String id = member.getUser_id();
		System.out.println("id : " + id);
		dto.setId(id);  // QnaDTO id에 저장
		
		return "qnaWrite";
	}

	// 문의게시판 insert
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String qnaInsert(@ModelAttribute QnaDTO dto) {
		System.out.println("문의글쓰기");
		
		// no가 없으면 insert / no가 있으면 modify
		String no = dto.getNo();
		if(no == null || "".equals(dto.getNo()))
			qnas.qnaInsert(dto);
		else
			qnas.qnaModify(dto);
		
		System.out.println("Insert dto : " + dto);

		return "redirect:qna";
	}

	// 문의게시판 read
	@RequestMapping(value="/qnaRead", method=RequestMethod.GET)
	public String qnaRead(HttpServletRequest request, ModelMap modelMap, HttpSession session, QnaDTO dto) {
		System.out.println("문의글보기");
		
		//session id 와 QnaDTO id 가 같으면 읽기 가능
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		String id = member.getUser_id();
		System.out.println("Memeber userId : " + member.getUser_id());
		dto.setId(id);
		System.out.println("QnaDTO id : " + id);
		/*if(member.getUser_id().equals(dto.getId())) {
			
		}*/
		
		String no = request.getParameter("no");
		
		// 조회수 증가 처리
		qnas.increaseHit(no, session);

		dto = qnas.selectQnaOne(no);
		modelMap.addAttribute("dto", dto);

		return "qnaRead";
	}
	
	// 문의게시판 delete > update로 데이터 남겨둠
	@RequestMapping(value="/qnaDelete", method=RequestMethod.GET)
	public String qnaDelete(HttpServletRequest request) {
		System.out.println("문의글삭제");
		
		String no = request.getParameter("no");
		
		qnas.qnaDelete(no);
		
		return "redirect:qna";
	}
	
	
	/*	
	 *문의게시판 댓글	
	 */	
	//댓글 리스트
	@ResponseBody
	@RequestMapping(value="/qnaRep", method=RequestMethod.GET)
	public List<QnaRepDTO> selectQnaRep(Model model) {
		
		return qrs.selectQnaRep();
	}
	
	// 댓글 쓰기
	@ResponseBody
	@RequestMapping(value="/qnaRepInsert", method=RequestMethod.POST)
	public int qnaRepWrite(@RequestParam String no, @RequestParam String rep_content, HttpSession session) {
		
		QnaRepDTO Rdto = new QnaRepDTO();
		Rdto.setNo(no);
		Rdto.setRep_content(rep_content);
		
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		String id = member.getUser_id();
		Rdto.setId(id);
		
		
		return qrs.qnaRepWrite(Rdto);
	}
	
	// 댓글 수정
	@ResponseBody
	@RequestMapping(value="/qnaRepModify", method=RequestMethod.GET)
	public int qnaRepModify(@RequestParam String rep_no, @RequestParam String rep_content) {
		
		QnaRepDTO dto = new QnaRepDTO();
		dto.setRep_no(rep_no);
		dto.setRep_content(rep_content);
		
		return qrs.qnaRepModify(dto);
	}
	
	// 댓글 삭제 > 업데이트
	@ResponseBody
	@RequestMapping(value="/qnaRepDelete", method=RequestMethod.GET)
	public void qnaRepDelete(@PathVariable String rep_no) {
		
		qrs.qnaRepDelete(rep_no);
	}
	
	
	
	
	/*	
	 *광고문의게시판
	 */
	// 광고문의게시판
	@RequestMapping(value="/adqna", method=RequestMethod.GET)
	public String adqna() {
		System.out.println("광고문의게시판");
		return "adqna";
	}

}
