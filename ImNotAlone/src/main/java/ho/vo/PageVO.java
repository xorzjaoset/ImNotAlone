package ho.vo;

public class PageVO {

	private int pageSize; //보여줄 게시글수
	private int pageBlock;//페이징 사이즈
	private int pageNum;   //페이지번호
	private int startRowNum;//시작 row번호
	private int endRowNum;  //마지막 row번호
	private int firstPageNum; //첫번째 페이지 번호 
	private int finalPageNum; //마지막 페이지 번호
	private int prevPageNum; //이전 페이지 번호
	private int nextPageNum; //다음 페이지 번호
	private int startPageNum;//시작페이지
	private int endPageNum;  //끝 페이지
	private int totalCount;  //게시글 전체수
	private int bst_board_no; // 방번호
	
	
	


	public void makePaging() {
		//기본값설정
		if(this.totalCount ==0)return;
		if(this.pageNum ==0) this.setPageNum(1);
		if(this.pageSize ==0) this.setPageSize(5);
		if(this.pageBlock ==0) this.setPageBlock(5);
		
		// 첫페이지 마지막페이지 계산
		int finalPage=(totalCount+(pageSize -1))/pageSize;
		this.setFirstPageNum(1);
		this.setFinalPageNum(finalPage);
		
		//이전 다음 페이지계산
		boolean isNowFirst = pageNum ==1? true:false;
		boolean isNowFinal = pageNum == finalPage?true:false;
		if(isNowFirst) {
			this.setPrevPageNum(1);
		}else {
			this.setPrevPageNum(((pageNum-1)<1?1:(pageNum-1)));
		}
		if(isNowFinal) {
			this.setNextPageNum(finalPage);
		}else {
			this.setNextPageNum(((pageNum+1)>finalPage?finalPage:(pageNum+1)));
		}
		
		//페이징 블럭 계산
		int startPage = ((pageNum-1)/pageBlock)*pageBlock+1;
		int endPage =startPage + pageBlock -1;
		
		//끝으로 갔을때 마지막페이지가 끝으로 만들기
		if(endPage > finalPage) {
			endPage = finalPage;
		}
		this.setStartPageNum(startPage); //시작페이지
		this.setEndPageNum(endPage);    //끝페이지
		
		int startRowNum = ((pageNum-1) *pageSize)+1;
		int endRowNum = pageNum*pageSize;
		
		setStartRowNum(startRowNum);
		setEndRowNum(endRowNum);
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public int getPageBlock() {
		return pageBlock;
	}
	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getStartRowNum() {
		return startRowNum;
	}
	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}
	public int getEndRowNum() {
		return endRowNum;
	}
	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}
	public int getFirstPageNum() {
		return firstPageNum;
	}
	public void setFirstPageNum(int firstPageNum) {
		this.firstPageNum = firstPageNum;
	}
	public int getFinalPageNum() {
		return finalPageNum;
	}
	public void setFinalPageNum(int finalPageNum) {
		this.finalPageNum = finalPageNum;
	}
	public int getPrevPageNum() {
		return prevPageNum;
	}
	public void setPrevPageNum(int prevPageNum) {
		this.prevPageNum = prevPageNum;
	}
	public int getNextPageNum() {
		return nextPageNum;
	}
	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}
	public int getStartPageNum() {
		return startPageNum;
	}
	public void setStartPageNum(int startPageNum) {
		this.startPageNum = startPageNum;
	}
	public int getEndPageNum() {
		return endPageNum;
	}
	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.makePaging();
	}
	public int getBst_board_no() {
		return bst_board_no;
	}
	public void setBst_board_no(int bst_board_no) {
		this.bst_board_no = bst_board_no;
	}
	
	
	
}
