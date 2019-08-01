package springapp.board;

public class BoardPagingController {

	private int currentPage;			//���� ������ 
	private int totalCount;				//��ü �Խù� ��
	private int totalPage;				//��ü ������ ��
	private int blockCount;				//�� �������� �Խù��� ��
	private int blockPage;				//�� ȭ�鿡 ������ �������� ��
	private int startCount;				//�� ���������� ������ �Խù��� ���� ��ȣ
	private int endCount;				//�� ���������� ������ �Խù��� �� ��ȣ
	private int startPage;				//���� ������
	private int endPage;				//������ ������
	private StringBuffer pagingHtml;
	
	public BoardPagingController(int currentPage, int totalCount, int blockCount,
			int blockPage, String keyField, String keyWord) {
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.blockCount = blockCount;
		this.blockPage = blockPage;
		
		totalPage = (int)Math.ceil((double)totalCount/blockCount);
		
		//�� ���������� 0�϶� ���ǹ�
		if(totalPage==0){
			totalPage=1;
		}
		
		//���� �������� �������� ���� Ŭ�� ���ǹ�
		if(currentPage>totalPage){
			currentPage = totalPage;
		}
		
		startCount = (currentPage-1)*blockCount+1;
		endCount = startCount+blockCount-1;
		startPage = (int)((currentPage-1)/blockPage)*blockPage+1;
		endPage = startPage + blockPage-1;
		
		//������ ������ ��ȣ�� �� ������ ��ȣ���� Ŭ�� ���ǹ�
		if(endPage>totalPage){
			endPage = totalPage;
		}
		
		pagingHtml = new StringBuffer();
		
		//�˻��� ���� �ʾ����� ����¡
		//�˻��� ���� �ʾ����� keyField, keyWord�� null���� ���� ���� �����ϱ� ����
		if(keyWord==null||keyWord==""){
			if(currentPage>blockPage){
				pagingHtml.append("<a href=board_list.do?currentPage="+(startPage-1)+">");
				pagingHtml.append("[����]");
				pagingHtml.append("</a>");
			}
			pagingHtml.append("&nbsp;&nbsp;&nbsp;&nbsp;");
			for(int i=startPage;i<=endPage;i++){
				if(i>totalPage){
					break;
				}
				if(i==currentPage){
					pagingHtml.append("&nbsp;<b><font color='red'>");
					pagingHtml.append(i);
					pagingHtml.append("</font></b>");
				} else {
					pagingHtml.append("&nbsp;<b><a href='board_list.do?currentPage=");
					pagingHtml.append(i);
					pagingHtml.append("'>");
					pagingHtml.append(i);
					pagingHtml.append("</a></b>");
				}
				pagingHtml.append("&nbsp;");
			}
			pagingHtml.append("&nbsp;&nbsp;&nbsp;&nbsp;");
			if(totalPage-startPage>=blockPage){
				pagingHtml.append("<a href=board_list.do?currentPage="+(endPage+1)+">");
				pagingHtml.append("[����]");
				pagingHtml.append("</a>");
			}
		} else {  //�˻��� ����¡
			if(currentPage>blockPage){
				pagingHtml.append("<a href=board_list.do?currentPage="+(startPage-1)+"&keyField="+keyField+"&keyWord="+keyWord+">");
				pagingHtml.append("[����]");
				pagingHtml.append("</a>");
			}
			pagingHtml.append("&nbsp;&nbsp;&nbsp;&nbsp;");
			for(int i=startPage;i<=endPage;i++){
				if(i>totalPage){
					break;
				}
				if(i==currentPage){
					pagingHtml.append("&nbsp;<b><font color='red'>");
					pagingHtml.append(i);
					pagingHtml.append("</font></b>");
				} else {
					pagingHtml.append("&nbsp;<b><a href='board_list.do?currentPage=");
					pagingHtml.append(i+"&keyField="+keyField+"&keyWord="+keyWord);
					pagingHtml.append("'>");
					pagingHtml.append(i);
					pagingHtml.append("</a></b>");
				}
				pagingHtml.append("&nbsp;");
			}
			pagingHtml.append("&nbsp;&nbsp;&nbsp;&nbsp;");
			if(totalPage-startPage>=blockPage){
				pagingHtml.append("<a href=board_list.do?currentPage="+(endPage+1)+"&keyField="+keyField+"&keyWord="+keyWord+">");
				pagingHtml.append("[����]");
				pagingHtml.append("</a>");
			}
		}
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getBlockCount() {
		return blockCount;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public int getStartCount() {
		return startCount;
	}

	public int getEndCount() {
		return endCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public StringBuffer getPagingHtml() {
		return pagingHtml;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public void setStartCount(int startCount) {
		this.startCount = startCount;
	}

	public void setEndCount(int endCount) {
		this.endCount = endCount;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public void setPagingHtml(StringBuffer pagingHtml) {
		this.pagingHtml = pagingHtml;
	}
	
}
