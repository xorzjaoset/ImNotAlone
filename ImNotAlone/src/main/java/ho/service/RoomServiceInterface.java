package ho.service;

import java.util.List;

import ho.dto.CommentDTO;
import ho.dto.MemberDTO;
import ho.dto.RoomStarDTO;
import ho.dto.WishListDTO;
import ho.vo.PageVO;

public interface RoomServiceInterface {

	public String contentsUpload(RoomStarDTO rsDTO) throws Exception;
	public int getCountList();
	public List<RoomStarDTO> getListContents(PageVO pageVO);
	public RoomStarDTO getBstContents(RoomStarDTO roomStarDTO);
	public List<RoomStarDTO> getBstImages(RoomStarDTO roomStarDTO);
	public CommentDTO getComment(CommentDTO commentDTO);
	void insertComment(CommentDTO cDTO);
	public String addWishList(WishListDTO wishDTO);
	public String oddWishList(WishListDTO wishDTO);
	public List<CommentDTO> getCommentList(CommentDTO commentDTO);
	public String getWishListCheck(String user_id);
	public int getLikeCount(int bst_board_no);
	
}
