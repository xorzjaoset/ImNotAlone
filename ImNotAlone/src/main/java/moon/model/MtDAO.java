package moon.model;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import moon.dto.MtRoomDTO;
import moon.dto.ProfileDTO;

public class MtDAO extends SqlSessionDaoSupport{
	
	public String insertMtRoom(MtRoomDTO dto) {
		
		return getSqlSession().selectOne("profile.insertMtRoomsub",dto);
		
	}
	public List<MtRoomDTO> selectMtRoom(MtRoomDTO dto) {
		
		return getSqlSession().selectList("profile.selectMtRoomsub",dto);
		
	}
	public ProfileDTO selectMtPro(String mt_id){
	
		return getSqlSession().selectOne("profile.selectMtProsub",mt_id);
		
		
	}
	public String hostcheck(String mp_id) {
		String  str = getSqlSession().selectOne("profile.mtHostCheck",mp_id);
		System.out.println("!!!");
		System.out.println(str);
		return str;
		
	}
	
	

}
