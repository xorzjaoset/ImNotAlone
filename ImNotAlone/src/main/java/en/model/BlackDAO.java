package en.model;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import en.dto.BlackDTO;

public class BlackDAO extends SqlSessionDaoSupport {

	public List<BlackDTO> selectBlack(BlackDTO dto) {
		System.out.println("블랙대기리스트 들어가니?");
		return getSqlSession().selectList("enadmin.BlackWait", dto);
	}
	
	public int waitinsert(BlackDTO dto) {
		System.out.println("블랙대기 인서트 들어가니?");
		return getSqlSession().insert("enadmin.WaitInsert", dto);
	}
	
	public List<BlackDTO> selectBlack1(BlackDTO dto) {
		System.out.println("블랙확정 들어가니?");
		return getSqlSession().selectList("enadmin.BlackList", dto);
	}
}
