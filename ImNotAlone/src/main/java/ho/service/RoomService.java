package ho.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import ho.dto.CommentDTO;
import ho.dto.MemberDTO;
import ho.dto.RecentDTO;
import ho.dto.RoomStarDTO;
import ho.dto.WishListDTO;
import ho.model.RoomStarDAO;
import ho.vo.PageVO;

@Service
@Transactional
public class RoomService implements RoomServiceInterface, ApplicationContextAware {

	@Autowired
	RoomStarDAO rsDAO;

	MultipartFile uploadFile;
	String oname;
	String sname;
	String path;
	long size;
	String result;
	private WebApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = (WebApplicationContext) applicationContext;
	}

	
	@Override
	@Transactional
	public String contentsUpload(RoomStarDTO rsDTO) throws Exception {
		String type_of = "";
		int check = 0;
		int check2 = 0;
		int de = 0;
		int like = 0;
		int view = 0;
		
		/*type_of �߰�*/
		for(int i = 0; i < rsDTO.getType_of().size(); i++) {
			if(rsDTO.getType_of().size() == i+1) {
			type_of += rsDTO.getType_of().get(i);
			break;
			}
			type_of += rsDTO.getType_of().get(i) + ",";
		}
		
		
		String[] a = type_of.split(",");
		System.out.println("type_of Ȯ�� : " + type_of);
		rsDTO.setBst_type_of(type_of);
		rsDTO.setBst_like(like);
		rsDTO.setBst_view(view);
		
		// (1)������ ���ε�
		check = rsDAO.insertContents(rsDTO);

		// (2)���Ͼ��ε�
		if (check == 1) {
			check = 0;
			for (int i = 0; i < rsDTO.getUser_file().size(); i++) {
				uploadFile = rsDTO.getUser_file().get(i);
				oname = rsDTO.getUser_file().get(i).getOriginalFilename();
				sname = System.currentTimeMillis() + "_" + new Random().nextInt(10) + "_" + oname;
				size = rsDTO.getUser_file().get(i).getSize();
				path = context.getServletContext().getRealPath("/uploadedFile");
				// path =
				// "C:/xor4/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ImNotAlone/uploadedFile/"
				// + sname;

				rsDTO.setBst_img_oname(oname);
				rsDTO.setBst_img_sname(sname);
				rsDTO.setBst_img_path(path + "\\" + sname);
				rsDTO.setBst_img_size(size);
				
				
				// ���ȣȮ��
				//������ �ͼ��� �߻�
//				rsDAO.tranTest();
				List<RoomStarDTO> list = rsDAO.checkBstNo(rsDTO);
				
				if (list.get(0).getBst_board_no() == 0) {
					list.get(0).setBst_board_no(0);
				}
				rsDTO.setBst_board_no(list.get(0).getBst_board_no());
				
				// (2-1)���� ���ε�
				check2 = rsDAO.uploadFile(rsDTO);
				System.out.println("-----------------");
				System.out.println(i + "��° �ε��� ���� ���ε� ����");
				
				// (3)���ε� ���� ������ ���� �̵�.
				if (check2 == 1) {
				check2 = 0;
				try {
					rsDTO.getUser_file().get(i).transferTo(new File(rsDTO.getBst_img_path()));
					System.out.println(i + "��° �ε��� ���� �̵� ����");

				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
					System.out.println(i + "��° �ε��� ���� �̵� ����");
				}
			}//if 
				
			}// for
		} // if

		return "�ӹ�����";
	}// contentsUpload





	@Override
	public int getCountList() {
		int count = rsDAO.getCountList();
		return count ;
	}



	@Override
	public List<RoomStarDTO> getListContents(PageVO pageVO){
		List<RoomStarDTO> contentsList = new ArrayList<RoomStarDTO>();
		contentsList = rsDAO.getListContents(pageVO);
		return contentsList;
	}



	@Override
	public RoomStarDTO getBstContents(RoomStarDTO roomStarDTO) {
		roomStarDTO = rsDAO.getContentBoard(roomStarDTO);
		List<String> tokenList = new ArrayList<String>();
		StringTokenizer token = new StringTokenizer(roomStarDTO.getBst_type_of().trim(),",");
		while(token.hasMoreTokens()) {
			tokenList.add(token.nextToken());
		}
		roomStarDTO.setType_of(tokenList);
		
		return roomStarDTO;
	}
	
	@Override
	public List<RoomStarDTO> getBstImages(RoomStarDTO roomStarDTO){
		List<RoomStarDTO> boardContents = new ArrayList<RoomStarDTO>();
		boardContents = rsDAO.getContentImages(roomStarDTO);
		return boardContents;
	}

	@Override
	public void insertComment(CommentDTO cDTO) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh24:mi:ss");
//		String dg_board_date = (sdf.format(new Timestamp(System.currentTimeMillis())));
//		System.out.println("dg_board_date : " + dg_board_date);
		String result = rsDAO.insertComment(cDTO);
		System.out.println(result);
	}

	@Override
	public CommentDTO getComment(CommentDTO cDTO) {
		cDTO = rsDAO.getComment(cDTO);
		return cDTO;
	}


	@Override
	public String addWishList(WishListDTO wishDTO) {
		if(rsDAO.addWishList(wishDTO) == 1) {
			return "addWishList ����" ;
		}else {
			return "addWishList ����";
		}
	}
	
	@Override
	public String oddWishList(WishListDTO wishDTO) {
		if(rsDAO.oddWishList(wishDTO) == 1) {
			return "oddWishList ����" ;
		}else {
			return "oddWishList ����";
		}
	}


	@Override
	public List<CommentDTO> getCommentList(CommentDTO commentDTO) {
		List<CommentDTO> commentList = rsDAO.getCommentList(commentDTO);
		return commentList;
	}


	@Override
	public String getWishListCheck(String user_id) {
		List<WishListDTO> wishCheckList = rsDAO.getWishListCheck(user_id);
		String wishCheck = "";
		for(int i = 0; i < wishCheckList.size(); i++) {
			wishCheck += wishCheckList.get(i).getBst_board_no()+",";
		}
		System.out.println("wichCheck �� ������ üũ!!!"+wishCheck);
		return wishCheck;
	}


	@Override
	public int getLikeCount(int bst_board_no) {
		return rsDAO.getLikeCount(bst_board_no);
	}


	@Override
	public void updateBstView(RoomStarDTO roomStarDTO) {
		int result = rsDAO.updateBstView(roomStarDTO);
		if(result == 1)System.out.println("�� ������Ʈ����");else System.out.println("�� ������Ʈ ����");		
	}


	@Override
	public void addRecentBst(RecentDTO reDTO) throws SQLException {
		int addResult = 0, listCheck, recentList, checkList = 0;
	
		listCheck = rsDAO.checkForAddRecentBst(reDTO);
		if(listCheck == 0)
		addResult = rsDAO.addRecentBst(reDTO);
		if(addResult != 0) {
			recentList = rsDAO.selectRecentBst(reDTO); /*�������� 3���̻����� Ȯ��*/
			if(recentList >3 ) {
				checkList = rsDAO.oddRecentBst(reDTO);/*3�� �̻��̶�� ����*/
				if(checkList == 1)System.out.println("�ֱٸ���Ʈ ���� ����");
				else System.out.println("�ֱٸ���Ʈ ���� ����?");}
			
			System.out.println("�ֱٸ���Ʈ �߰� ����");
		}else {
			System.err.println("�ֱٸ���Ʈ �߰� ����");
		}
	}


	@Override
	public List<RecentDTO> getRecentNoList(String user_id) {
		return rsDAO.getRecentNoList(user_id);
	}


	@Override
	public List<RoomStarDTO> getContentsList(MemberDTO member) {
		List<Integer> recentNoList = new ArrayList<Integer>();
		List<RoomStarDTO> contentsList = new ArrayList<RoomStarDTO>();
		Iterator<Integer> itr =  MemberDTO.getRecent_list().iterator();
			while(itr.hasNext()) {
				recentNoList.add(itr.next());
				contentsList = rsDAO.getContentList(recentNoList);

				//�۾��ؾ���
//				if(recent_list.size() > 3) {
//					recent_list.remove(0);
//					System.out.println("recent_list.size() !!!" + recent_list.size());
//				}
			}
		return contentsList;
	}




	

}
