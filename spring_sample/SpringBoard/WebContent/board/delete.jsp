<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="boardVo" class="springapp.dao.BoardVo" scope="request"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Spring Board</title>
<link href="./css/style.css" rel="stylesheet" type="text/css"/>
<script>
function fn_passCheck(){
	var pass = document.getElementById("password").value;
	if(pass!="${boardVo.password}"){
		alert("패스워드가 틀립니다.");
		document.getElementById("password").value="";
		document.getElementById("password").focus();
		return;
	} else {
		alert("삭제되었습니다.");
		document.forms[0].submit();
		window.opener.parent.location.href = "board_list.do";
	}
	window.close();
}
</script>
</head>
<body topmargin="0" leftmargin="0">
<center>
<form action="board_delete_action.do" method="post">
<input type="hidden" name="seq" value="${boardVo.seq}"/>
<input type="hidden" name="groups" value="${boardVo.groups}"/>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
<tr height="50">
	<td bgcolor="#333436" align="center"><img src="./img/board_pass_check.gif" border="0"/></td>
</tr>
<tr height="50">
	<td>
		<input type="password" name="password" class="form_id"/>
		<a href="#" onClick="fn_passCheck()"><img src="./img/board_btn_submit.gif" border="0" align="absmiddle"/></a>
	</td>
</tr>
</table>
</form>
</center>
</body>
</html>