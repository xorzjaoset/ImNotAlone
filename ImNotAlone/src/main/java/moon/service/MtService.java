package moon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import moon.dto.MtRoomDTO;
import moon.dto.ProfileDTO;
import moon.model.MtDAO;

public class MtService {
	
	
	@Autowired
	MtDAO dao;
	
	public void insertMtRoom(MtRoomDTO dto) {
		
		dao.insertMtRoom(dto);
		

		
	}
	public List<MtRoomDTO> selectMtRoom(MtRoomDTO dto) {
		
	return dao.selectMtRoom(dto);
	}

	
	public ProfileDTO getArticle(String mt_id){
		System.out.println("service::::"+mt_id);
		return  dao.selectMtPro(mt_id);
		
		
	}
	public int hostcheck(String mp_id) {
		String userid = dao.hostcheck(mp_id);
		System.out.println("왜 값이 안넘어오지::::::"+userid);
		if(userid !=null) {
			return 1;
		}
		return 2;
	}

}
