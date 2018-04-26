package en.model;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import en.dto.QnaDTO;
import en.dto.QnaRepDTO;

public class QnaRepDAO extends SqlSessionDaoSupport {
	
	// 댓글 갯수
	public int qnaRepCount() {
		System.out.println("qnaRepCount QnaRepDAO");
		
		return getSqlSession().selectOne("enadmin.qnaRepCount");
	}
	
	// 댓글 list
	public List<QnaRepDTO> selectQnaRep() {
		System.out.println("selectQnaRep QnaRepDAO");
		
		return getSqlSession().selectList("enadmin.selectQnaRep");
	}
	
	// 댓글 쓰기
	public int qnaRepWrite(QnaRepDTO Rdto) {
		System.out.println("qnaRepWrite QnaRepDAO");
		System.out.println("Rdto : " + Rdto);
		
		return getSqlSession().insert("enadmin.qnaRepWrite", Rdto);
	}
	
	// 댓글 수정
	public int qnaRepModify(QnaRepDTO Rdto) {
		System.out.println("qnaRepModify QnaRepDAO");
		
		return getSqlSession().update("enadmin.qnaRepModify", Rdto);
	}
	
	// 댓글 삭제 > 업데이트
	public void qnaRepDelete(String rep_no) {
		System.out.println("qnaRepDelete QnaRepDAO");
		
		getSqlSession().update("enadmin.qnaRepDelete", rep_no);
	}

}
