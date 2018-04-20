package ho.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import ho.dto.CommentDTO;
import ho.dto.MemberDTO;
import ho.dto.RoomStarDTO;
import ho.dto.WishListDTO;
import ho.vo.PageVO;

public class RoomStarDAO extends SqlSessionDaoSupport{

	@Transactional(readOnly=true)
	public int uploadFile(RoomStarDTO rsDTO) {
		return getSqlSession().insert("uploadBstImg", rsDTO);
	}

	public int insertContents(RoomStarDTO rsDTO) {
		return getSqlSession().insert("insertBstContents", rsDTO);
	}

	public List<RoomStarDTO> checkBstNo(RoomStarDTO rsDTO) {
		return getSqlSession().selectList("checkBstNo",rsDTO);
				
	}



	public int getCountList() {
		return getSqlSession().selectOne("getBstCountList");
	}

//	public List<RoomStarDTO> getListContents(MemberDTO mbDTO) {
//		return getSqlSession().selectList("getListContents", mbDTO);
//	}
	

	public List<RoomStarDTO> getListContents(PageVO pageVO) {
		return getSqlSession().selectList("getListContents", pageVO);
	}

	public RoomStarDTO getContentBoard(RoomStarDTO roomStarDTO) {
		return getSqlSession().selectOne("getContentBoard",roomStarDTO);
	}
	public List<RoomStarDTO> getContentImages(RoomStarDTO roomStarDTO) {
		return getSqlSession().selectList("getContentImages", roomStarDTO);
	}

	
	public String insertComment(CommentDTO cDTO) {
		System.out.println("!!!!!!!!!!!!"+cDTO);
		if(getSqlSession().insert("insertComment", cDTO)==1) {
			return "댓글인설트성공";
		}else {
			return "댓글인설트실패";
		}
	}
	public CommentDTO getComment(CommentDTO cDTO) {
		return getSqlSession().selectOne("getComment", cDTO);
	}

	public int addWishList(WishListDTO wishDTO) {
		return getSqlSession().insert("addWishList", wishDTO);
	}

	public int oddWishList(WishListDTO wishDTO) {
		return getSqlSession().insert("oddWishList", wishDTO);

	}

	public List<CommentDTO> getCommentList(CommentDTO commentDTO) {
		return getSqlSession().selectList("getCommentList", commentDTO);
	}

	public List<WishListDTO> getWishListCheck(String user_id) {
		return getSqlSession().selectList("getWishListCheck", user_id);
	}

	public int getLikeCount(int bst_board_no) {
		return getSqlSession().selectOne("getLikeCount", bst_board_no);
	}

	public int updateBstView(RoomStarDTO roomStarDTO) {
		return getSqlSession().update("updateBstView", roomStarDTO);
	}
	
}
