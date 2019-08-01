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
//�˻��� ��ȿ�� �˻�
function search(){
	if(document.getElementById("keyField").value=="0"){
		alert("�˻��׸��� �����ϼ���.");
		document.getElementById("keyField").value="";
		document.getElementById("keyField").focus();
		return;
	} else {
		if(document.getElementById("keyWord").value==""){
			alert("ã�� ������ �Է��ϼ���.");
			document.getElementById("keyWord").focus();
			return;
		}
	}
	document.forms[0].submit();  //form�±׿��� name�� ���� �� ���(forms[0])
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
	<!-- �Խñ��� �ҷ����� ���� forEach�� ���� -->
	<c:forEach var="vo" items="${boardList}">
	<tr height="27">
		<td align="center" background="./img/board_cont_bg.gif">${vo.seq}</td>
		<!-- �θ�� / ����� �����ϱ� ���� choose��(if���� ����� ���ǹ�) -->
		<c:choose>
		<c:when test="${vo.step==0}">
		<td align="left" background="./img/board_cont_bg.gif"><a href="board_detail.do?seq=${vo.seq}&currentPage=${currentPage}">${vo.title}</a></td>
		</c:when>
		<c:otherwise>
		<td align="left" background="./img/board_cont_bg.gif">
			<!-- ����϶� �θ�۰� ���̸� �ֱ����� ������� �ݺ��� ���� -->
			<c:forEach begin="1" end="${vo.step}" step="1">
				&nbsp;&nbsp;&nbsp;
			</c:forEach>
			<!-- ��� forEach �� -->
			<img src="./img/board_rep.gif" border="0"/><a href="board_detail.do?seq=${vo.seq}&currentPage=${currentPage}">${vo.title}</a>
		</td>
		</c:otherwise>
		</c:choose>
		<!-- choose�� �� -->
		<td align="center" background="./img/board_cont_bg.gif">${vo.writer}</td>
		<td align="center" background="./img/board_cont_bg.gif">${vo.regdate}</td>
		<td align="center" background="./img/board_cont_bg.gif">${vo.hit}</td>
	</tr>
	<tr>
		<td colspan="5" height="2"><img src="./img/board_separate.gif" width="735"/></td>
	</tr>
	</c:forEach>
	<!-- �Խñ� forEach�� �� -->	
	<tr height="30">
		<td align="right" colspan="5">
			<a href="board_list.do"><img src="./img/board_btn_list.gif" border="0"/></a>
			<a href="board_insert.do"><img src="./img/board_btn_write.gif" border="0"/></a>
		</td>		
	</tr>
	<tr height="30">
		<td colspan="5" align="center">
		<!-- ����¡ ���� -->
			${pagingHtml}
		<!-- ����¡ �� -->
		</td>
	</tr>
	<tr height="50">
		<td colspan="5" align="center">
			<select name="keyField">
				<option values="0">�����ϼ���.</option>
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