<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="boardVo" class="springapp.dao.BoardVo" scope="request"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Spring Board</title>
<script>
//수정시 패스워드 확인
function fn_passCheck() {
	var pass = document.getElementById("password").value;
	if(pass!="${boardVo.password}"){
		alert("패스워드가 틀립니다.");
		document.getElementById("password").focus();
		return;
	}
	document.forms[0].submit();
}
</script>
</head>
<body>
<form method="post" action="board_update_action.do">
<input type="hidden" name="seq" value="${boardVo.seq}"/>
<table width="735" border="0" cellspacing="0" cellpadding="5" align="center" style="border:solid 1px">
<tr>
	<td><img src="./img/board_logo.gif" width="735"/></td>
</tr>
<tr>
	<td>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr height="27">
			<td align="center" bgcolor="#333436" width="100"><img src="./img/board_title_title.gif"/></td>
			<td background="./img/board_cont_bg.gif">&nbsp;&nbsp;<input type="text" name="title" class="form_id" style="width:612px;height:18px" value="${boardVo.title }"/></td>
		</tr>
		<!-- 작성자도 수정할 때 사용 -->
		<!-- 작성자 수정시 JdbcTemplateBoardDao.java에서 쿼리도 수정해줘야 한다 -->
		<!-- 
		<tr height="27">
			<td align="center" bgcolor="#333436" width="100"><img src="./img/board_title_writer.gif"/></td>
			<td background="./img/board_cont_bg.gif">&nbsp;&nbsp;<input type="text" name="writer" class="form_id" style="width:612px;height:18px" value="${boardVo.writer}"/></td>
		</tr> 
		-->
		<tr height="27">
			<td align="center" bgcolor="#333436" width="100"><img src="./img/board_title_pass.gif"/></td>
			<td background="./img/board_cont_bg.gif">&nbsp;&nbsp;<input type="password" name="password" id="password" class="form_id" style="width:612px;height:18px"/></td>
		</tr>
		<tr>
			<td align="center" bgcolor="#333436" width="100"><img src="./img/board_title_content.gif"/></td>
			<td>
				&nbsp;&nbsp;<textarea name="content" rows="10" cols="85" class="form_id">${boardVo.content}</textarea>
			</td>
		</tr>		 
		</table>
	</td>
</tr>
<tr>
	<td align="right">
		<a href="#" onClick="fn_passCheck()"><img src="./img/board_btn_submit.gif" border="0"/></a>
		<img src="./img/board_btn_reset.gif" border="0" onClick="reset()" style="cursor:hand"/>
		<a href="board_list.do"><img src="./img/board_btn_list.gif" border="0"/></a>
	</td>
</tr>
</table>
</form>
</body>
</html>