package springapp.board;

public class BoardPagingController {

	private int currentPage;			//현재 페이지 
	private int totalCount;				//전체 게시물 수
	private int totalPage;				//전체 페이지 수
	private int blockCount;				//한 페이지의 게시물의 수
	private int blockPage;				//한 화면에 보여줄 페이지의 수
	private int startCount;				//한 페이지에서 보여줄 게시물의 시작 번호
	private int endCount;				//한 페이지에서 보여줄 게시물의 끝 번호
	private int startPage;				//시작 페이지
	private int endPage;				//마지막 페이지
	private StringBuffer pagingHtml;
	
	public BoardPagingController(int currentPage, int totalCount, int blockCount,
			int blockPage, String keyField, String keyWord) {
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.blockCount = blockCount;
		this.blockPage = blockPage;
		
		totalPage = (int)Math.ceil((double)totalCount/blockCount);
		
		//총 페이지수가 0일때 조건문
		if(totalPage==0){
			totalPage=1;
		}
		
		//현재 페이지가 총페이지 보다 클때 조건문
		if(currentPage>totalPage){
			currentPage = totalPage;
		}
		
		startCount = (currentPage-1)*blockCount+1;
		endCount = startCount+blockCount-1;
		startPage = (int)((currentPage-1)/blockPage)*blockPage+1;
		endPage = startPage + blockPage-1;
		
		//마지막 페이지 번호가 총 페이지 번호보다 클때 조건문
		if(endPage>totalPage){
			endPage = totalPage;
		}
		
		pagingHtml = new StringBuffer();
		
		//검색을 하지 않았을때 페이징
		//검색을 하지 않았을때 keyField, keyWord에 null값이 들어가는 것을 방지하기 위해
		if(keyWord==null||keyWord==""){
			if(currentPage>blockPage){
				pagingHtml.append("<a href=board_list.do?currentPage="+(startPage-1)+">");
				pagingHtml.append("[이전]");
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
				pagingHtml.append("[다음]");
				pagingHtml.append("</a>");
			}
		} else {  //검색시 페이징
			if(currentPage>blockPage){
				pagingHtml.append("<a href=board_list.do?currentPage="+(startPage-1)+"&keyField="+keyField+"&keyWord="+keyWord+">");
				pagingHtml.append("[이전]");
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
				pagingHtml.append("[다음]");
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
