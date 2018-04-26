package moon.model;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import moon.dto.ProfileDTO;
import moon.dto.roomUpDTO;

public class ProfileDAO extends SqlSessionDaoSupport{
	
	public String insertProfile(ProfileDTO dto) {

		return getSqlSession().selectOne("profile.insertprofile",dto);
			
	}
//조건 1번째 쉐어룸 검색
	public List<roomUpDTO> getShare(String string){
		
		return getSqlSession().selectList("profile.getShare",string);
		
	}
	//조건 2번째 룸메이트/하우스메이트 검색
	public List<roomUpDTO> getRmate(String string){
		
		return getSqlSession().selectList("profile.getRmate",string);
		
	}
	//조건 3번째 오피스텔(원룸/투룸) 검색
	public List<roomUpDTO> getOffice(String string){
		
		return getSqlSession().selectList("profile.getOffice",string);
		
	}
	//조건 4번째 기타 검색
	public List<roomUpDTO> getOther(String string){
		
		return getSqlSession().selectList("profile.getOther",string);
		
	}

	public List getShare1(HashMap<String, String> map) {
		
		return getSqlSession().selectList("profile.getShare1",map);
		
	}
	public List getShare2(HashMap<String,String>map) {
		
		return getSqlSession().selectList("profile.getShare2",map);
		
	}
	public List getShare5(HashMap<String,String>map) {
		return getSqlSession().selectList("profile.getShare5",map);
		
	}
	
	public List getShare6(HashMap<String,String>map) {
		return getSqlSession().selectList("profile.getShare6",map);
		
	}
	
	public String profilecheck(String mp_id) {
		
		return getSqlSession().selectOne("profile.checkProfile",mp_id);
		
	}
	public ProfileDTO profileInfo(String mp_id) {
	
		return getSqlSession().selectOne("profile.profileInfo",mp_id);
	}
	public String profileUpdate(ProfileDTO dto) { 
		
		return getSqlSession().selectOne("profile.profileUpdate",dto);
		
	}


	
	

}
