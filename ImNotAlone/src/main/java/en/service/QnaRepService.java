package en.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import en.dto.QnaRepDTO;
import en.model.QnaRepDAO;

@Service
public class QnaRepService {

	@Autowired
	QnaRepDAO dao;
	
	// 댓글 list
	public List<QnaRepDTO> selectQnaRep() {
		System.out.println("selectQnaRep QnaRepService");
		
		return dao.selectQnaRep();
	}
	
	// 댓글 insert
	public int qnaRepWrite(QnaRepDTO Rdto) {
		System.out.println("qnaRepWrite QnaRepService");
		System.out.println("Rdto : " + Rdto);
		
		return dao.qnaRepWrite(Rdto);
	}
	
	// 댓글 수정
	public int qnaRepModify(QnaRepDTO Rdto) {
		System.out.println("qnaRepModify QnaRepService");
		
		return dao.qnaRepModify(Rdto);
	}
	
	// 댓글 삭제 > 업데이트
	public void qnaRepDelete(String rep_no) {
		System.out.println("qnaRepDelete QnaRepService");
		
		dao.qnaRepDelete(rep_no);
	}
}
