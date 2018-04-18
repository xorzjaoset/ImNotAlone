package ho.model;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import ho.dto.MemberDTO;
import ho.dto.RoomStarDTO;
import ho.dto.WishListDTO;

public class MyPageDAO extends SqlSessionDaoSupport{
	
	public List<RoomStarDTO> getWishList(List<Integer> bst_board_no){
		return getSqlSession().selectList("getWishList", bst_board_no);
	}

	public List<Integer> getWishNum(String user_id) {
		 List<Integer> getNum = getSqlSession().selectList("getWishNum",user_id);
		 if(getNum.isEmpty()) {
			 getNum.add(1);
			 return getNum; 
		 }
		return getNum;
	}

	public int getWishCount(String user_id) {
		return getSqlSession().selectOne("getWishListCount",user_id);
	}
	
}
