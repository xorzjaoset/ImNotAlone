package moon.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import moon.dto.ProfileDTO;
import moon.dto.roomUpDTO;
import moon.model.ProfileDAO;

public class ProfileService {

	
	@Autowired
	ProfileDAO dao;
	
	public void insertProfile(ProfileDTO dto) {
		
		dao.insertProfile(dto);
		
	}
	
	// 여기서부터 방 둘러보기의 일반 조건 검색
	
	public List<roomUpDTO> getShare(String string){
		
	return 	dao.getShare(string);
		
	}

	public List<roomUpDTO> getRmate(String string){
		
	return 	dao.getRmate(string);
		
}
	public List<roomUpDTO> getOffice(String string){
		
	return 	dao.getOffice(string);
		
}
	public List<roomUpDTO> getOther(String string){
		
	return 	dao.getOther(string);
		
}
	//ajax 이용해서 가격 순, 평점 순 조건 검색

	//11
	public List getShare1(HashMap<String, String> map) {
		
		return dao.getShare1(map);
	}
	//12
	public List getShare2(HashMap<String,String>map) {
		
		return dao.getShare2(map);
		
	}
	//21
	public List getShare5(HashMap<String,String>map) {
		
		return dao.getShare5(map);
		
	}
	//22
	public List getShare6(HashMap<String,String>map) {
		
		return dao.getShare6(map);
		
	}

	public int profilecheck(String mp_id) {
		System.out.println("여기까지 왔나???!!?!?");
		String userid = dao.profilecheck(mp_id);
		
		if(userid !=null) {
			return 1;
	
}
		return 2;
}
	public ProfileDTO ProfileInfo(String mp_id) {
		
		return dao.profileInfo(mp_id);
		
	}

	public String updateProfile(ProfileDTO dto) {

		return dao.profileUpdate(dto);
	}
}
