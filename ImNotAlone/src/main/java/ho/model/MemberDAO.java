package ho.model;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import ho.dto.MemberDTO;

public class MemberDAO extends SqlSessionDaoSupport {

	public String checkUser(String userEmail) {
		return getSqlSession().selectOne("checkUserEmailForLogin", userEmail);		
	}

	public int registerUser(MemberDTO dto) {
		return getSqlSession().insert("insertMember",dto);
	}

	public MemberDTO getUserInformation(MemberDTO dto) {
		return getSqlSession().selectOne("getUserInformation", dto);
	}

	 
}
