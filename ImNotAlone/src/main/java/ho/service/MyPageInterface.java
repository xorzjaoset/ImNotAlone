package ho.service;

import java.util.List;

import ho.dto.MemberDTO;
import ho.dto.RoomStarDTO;
import ho.dto.WishListDTO;

public interface MyPageInterface {

//	public List<RoomStarDTO> getContentList(List<Integer> recentNoList); //getWishList
	public List<RoomStarDTO> getContentList(String string); //getWishList
	public int getWishCount(String user_id);


}
