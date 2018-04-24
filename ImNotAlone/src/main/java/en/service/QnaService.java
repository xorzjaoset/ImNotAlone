package en.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import en.dto.QnaDTO;
import en.model.QnaDAO;

@Service
public class QnaService {

	@Autowired
	QnaDAO dao;
	
	// qna list
	public List<QnaDTO> QnaList() {
		System.out.println("qna listService");
		
		return dao.selectQna();
	}
	
	// qna read
	public QnaDTO selectQnaOne(String no) {
		System.out.println("qna read");
		
		return dao.qnaRead(no);
	}
	
	// qna hit
	public void increaseHit(String no, HttpSession session) {
		long update_time = 0;
		
		if(session.getAttribute("update_time" + no) != null) {
			update_time = (long)session.getAttribute("update_time" + no);
		}
		
		long current_time = System.currentTimeMillis();
		
		if(current_time - update_time > 5 * 1000) {
			dao.increaseHit(no);
			
			session.setAttribute("update_time" + no, current_time);
		}
	}
	
	// qna write
	public void qnaInsert(QnaDTO dto) {
		System.out.println("qna writeService");
		
		dao.qnaInsert(dto);
	}
	
	// qna modify
	public void qnaModify(QnaDTO dto) {
		System.out.println("qna modifyService");
		
		dao.qnaModify(dto);
	}
	
	// qna delete
	public void qnaDelete(String no) {
		System.out.println("qna deleteService");
		
		dao.qnaDelete(no);
	}
	
}
