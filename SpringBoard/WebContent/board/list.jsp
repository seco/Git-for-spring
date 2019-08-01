<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="boardList" type="java.util.List" scope="request"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Spring Board</title>
<script>
//검색시 유효성 검사
function search(){
	if(document.getElementById("keyField").value=="0"){
		alert("검색항목을 선택하세요.");
		document.getElementById("keyField").value="";
		document.getElementById("keyField").focus();
		return;
	} else {
		if(document.getElementById("keyWord").value==""){
			alert("찾을 내용을 입력하세요.");
			document.getElementById("keyWord").focus();
			return;
		}
	}
	document.forms[0].submit();  //form태그에서 name이 없을 때 사용(forms[0])
}
</script>
<link href="./css/style.css" rel="stylesheet" type="text/css"></link>
</head>
<body>
<form method="post">
<table width="735" border="0" cellpadding="0" cellspacing="1" bordercolor="#333436" align="center">
	<tr>
		<td colspan="5"><img src="./img/board_logo.gif" width="735"/></td>
	</tr>
	<tr bgcolor="#333436" height="20">
		<td align="center" width="85"><img src="./img/board_title_no.gif"/></td>
		<td align="center" width="400"><img src="./img/board_title_title.gif"/></td>
		<td align="center" width="100"><img src="./img/board_title_writer.gif"/></td>
		<td align="center" width="100"><img src="./img/board_title_date.gif"/></td>
		<td align="center" width="50"><img src="./img/board_title_hit.gif"/></td>
	</tr>
	<!-- 게시글을 불러오기 위한 forEach문 시작 -->
	<c:forEach var="vo" items="${boardList}">
	<tr height="27">
		<td align="center" background="./img/board_cont_bg.gif">${vo.seq}</td>
		<!-- 부모글 / 댓글을 구분하기 위한 choose문(if문과 비슷한 조건문) -->
		<c:choose>
		<c:when test="${vo.step==0}">
		<td align="left" background="./img/board_cont_bg.gif"><a href="board_detail.do?seq=${vo.seq}&currentPage=${currentPage}">${vo.title}</a></td>
		</c:when>
		<c:otherwise>
		<td align="left" background="./img/board_cont_bg.gif">
			<!-- 댓글일때 부모글과 차이를 주기위한 띄워쓰기 반복문 시작 -->
			<c:forEach begin="1" end="${vo.step}" step="1">
				&nbsp;&nbsp;&nbsp;
			</c:forEach>
			<!-- 댓글 forEach 끝 -->
			<img src="./img/board_rep.gif" border="0"/><a href="board_detail.do?seq=${vo.seq}&currentPage=${currentPage}">${vo.title}</a>
		</td>
		</c:otherwise>
		</c:choose>
		<!-- choose문 끝 -->
		<td align="center" background="./img/board_cont_bg.gif">${vo.writer}</td>
		<td align="center" background="./img/board_cont_bg.gif">${vo.regdate}</td>
		<td align="center" background="./img/board_cont_bg.gif">${vo.hit}</td>
	</tr>
	<tr>
		<td colspan="5" height="2"><img src="./img/board_separate.gif" width="735"/></td>
	</tr>
	</c:forEach>
	<!-- 게시글 forEach문 끝 -->	
	<tr height="30">
		<td align="right" colspan="5">
			<a href="board_list.do"><img src="./img/board_btn_list.gif" border="0"/></a>
			<a href="board_insert.do"><img src="./img/board_btn_write.gif" border="0"/></a>
		</td>		
	</tr>
	<tr height="30">
		<td colspan="5" align="center">
		<!-- 페이징 시작 -->
			${pagingHtml}
		<!-- 페이징 끝 -->
		</td>
	</tr>
	<tr height="50">
		<td colspan="5" align="center">
			<select name="keyField">
				<option values="0">선택하세요.</option>
				<option values="title">title</option>
				<option values="writer">writer</option>
			</select>
			<input type="text" name="keyWord" size="20" class="form_search" style="height:18px" onkeyDown="if(event.keyCode==13){search();}"/>
			<input type="image" src="./img/board_btn_search.gif" height="19" onClick="search()" align="absmiddle"/>
		</td>
	</tr>
</table>
</form>
</body>
</html>