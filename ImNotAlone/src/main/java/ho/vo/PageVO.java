package ho.vo;

public class PageVO {

	private int pageSize; //������ �Խñۼ�
	private int pageBlock;//����¡ ������
	private int pageNum;   //��������ȣ
	private int startRowNum;//���� row��ȣ
	private int endRowNum;  //������ row��ȣ
	private int firstPageNum; //ù��° ������ ��ȣ 
	private int finalPageNum; //������ ������ ��ȣ
	private int prevPageNum; //���� ������ ��ȣ
	private int nextPageNum; //���� ������ ��ȣ
	private int startPageNum;//����������
	private int endPageNum;  //�� ������
	private int totalCount;  //�Խñ� ��ü��
	private int bst_board_no; // ���ȣ
	
	
	


	public void makePaging() {
		//�⺻������
		if(this.totalCount ==0)return;
		if(this.pageNum ==0) this.setPageNum(1);
		if(this.pageSize ==0) this.setPageSize(5);
		if(this.pageBlock ==0) this.setPageBlock(5);
		
		// ù������ ������������ ���
		int finalPage=(totalCount+(pageSize -1))/pageSize;
		this.setFirstPageNum(1);
		this.setFinalPageNum(finalPage);
		
		//���� ���� ���������
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
		
		//����¡ �� ���
		int startPage = ((pageNum-1)/pageBlock)*pageBlock+1;
		int endPage =startPage + pageBlock -1;
		
		//������ ������ �������������� ������ �����
		if(endPage > finalPage) {
			endPage = finalPage;
		}
		this.setStartPageNum(startPage); //����������
		this.setEndPageNum(endPage);    //��������
		
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
