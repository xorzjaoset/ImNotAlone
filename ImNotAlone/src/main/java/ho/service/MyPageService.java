package ho.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import ho.dto.RoomStarDTO;
import ho.dto.WishListDTO;
import ho.model.MyPageDAO;

@Service
public class MyPageService implements MyPageInterface{

	@Autowired
	MyPageDAO mpDAO;

	public void setMpDAO(MyPageDAO mpDAO) {
		this.mpDAO = mpDAO;
	}
	
	
	@RequestMapping(value="/wishList")
	public String wishListView() {
		return "wishListView";
	}


	@Override
	public List<RoomStarDTO> getWishList(String user_id) {
		List<Integer> bst_board_no = new ArrayList<Integer>();
		List<RoomStarDTO> wishList = new ArrayList<RoomStarDTO>();

		bst_board_no = mpDAO.getWishNum(user_id);
		System.out.println("번호 확인 :" +bst_board_no+"리스트 사이즈 확인"+bst_board_no.size());
		wishList = mpDAO.getWishList(bst_board_no);
		
		return wishList;
	}


	@Override
	public int getWishCount(String user_id) {
		return mpDAO.getWishCount(user_id);
	}

	
}
