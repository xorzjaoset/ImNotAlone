package moon.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import moon.dto.RcDTO;
import moon.dto.RinqDTO;
import moon.dto.roomUpDTO;
import moon.model.RcDAO;


public class RcService{
	
	@Autowired
	RcDAO dao;
	
	
	
	public void insertComment(RcDTO dto1) {
		
		dao.insertComment(dto1);
		
	}
	
	public roomUpDTO getArticle(String rp_board_no) {
		
		return dao.selectRoomInfo(rp_board_no); 
		
	}
	
	
	public List getPhoto(String rp_board_no) {
		System.out.println(rp_board_no);
		return dao.getPhoto(rp_board_no);
	}
	
	public void insertInquiry(RinqDTO dto) {
		 dao.insertInquiry(dto);
		
	}
	public int profilecheck(String mp_id) {

		String userid = dao.profilecheck(mp_id);
		
		if(userid !=null) {
			return 1;
		}
		
		return 2;
	}

	public List getComment(String rp_board_no) {

		return dao.getComment(rp_board_no);
	}
	
	

}
