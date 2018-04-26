package moon.model;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import moon.dto.RcDTO;
import moon.dto.RinqDTO;
import moon.dto.roomUpDTO;

public class RcDAO extends SqlSessionDaoSupport{
	
	public String insertComment(RcDTO dto1) {
		
		return getSqlSession().selectOne("profile.insertcomment",dto1);
		
	}
	
	public roomUpDTO selectRoomInfo(String rp_board_no) {
		
		return getSqlSession().selectOne("profile.selectRoomInfo",rp_board_no);
		
		
	}
	public List<roomUpDTO> getPhoto(String rp_board_no){
		System.out.println(rp_board_no);
		return getSqlSession().selectList("profile.selectphoto",rp_board_no);
		
	}
	
	public String insertInquiry(RinqDTO dto) {
		
		return getSqlSession().selectOne("profile.insertInquiry",dto);
		
	}

	public String profilecheck(String mp_id) {
		
		return getSqlSession().selectOne("profile.checkComment",mp_id);
	}

	public List getComment(String rp_board_no) {

		return getSqlSession().selectList("profile.getComment",rp_board_no);
	}

}
