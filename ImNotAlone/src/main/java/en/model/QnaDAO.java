package en.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import en.dto.QnaDTO;

public class QnaDAO extends SqlSessionDaoSupport {

	// qna 리스트
	public List<QnaDTO> selectQna() {
		System.out.println("qna listDAO");

		return getSqlSession().selectList("enadmin.selectQna");
	}

	// qna 읽기
	public QnaDTO qnaRead(String no) {
		System.out.println("qna ReadDAO");

		return getSqlSession().selectOne("enadmin.selectQnaOne", no);
	}
	
	// qna 조회수 ++
	public void increaseHit(String no) {
		System.out.println("qna increaseHitDAO");
		
		getSqlSession().update("enadmin.increaseHit", no);
	}

	// qna 쓰기
	public int qnaInsert(QnaDTO dto) {
		System.out.println("qna InsertDAO");

		return getSqlSession().insert("enadmin.qnaWrite", dto);

	}

	// qna 수정
	public void qnaModify(QnaDTO dto) {
		System.out.println("qna ModifyDAO");

		getSqlSession().update("enadmin.qnaModify", dto);

	}
	
	// qna 삭제 > update해서 데이터 남겨둠
	public void qnaDelete(String no) {
		System.out.println("qna DeleteDAO");
		
		getSqlSession().update("enadmin.qnaDelete", no);
	}

}
