<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="boardVo" class="springapp.dao.BoardVo" scope="request"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Spring Board</title>
</head>
<body>
<form action="board_reply_action.do" method="post">
<input type="hidden" name="seq" value="${boardVo.seq}"/>
<input type="hidden" name="groups" value="${boardVo.groups}"/>
<input type="hidden" name="step" value="${boardVo.step}"/>
<input type="hidden" name="levels" value="${boardVo.levels}"/>
<table width="735" border="0" cellspacing="0" cellpadding="5" align="center" style="border:solid 1px">
<tr>
	<td><img src="./img/board_logo.gif" width="735"/></td>
</tr>
<tr>
	<td>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr height="27">
			<td align="center" bgcolor="#333436" width="100"><img src="./img/board_title_title.gif"/></td>
			<td background="./img/board_cont_bg.gif">&nbsp;&nbsp;<input type="text" name="title" class="form_id" style="width:612px;height:18px"/></td>
		</tr>
		<tr height="27">
			<td align="center" bgcolor="#333436" width="100"><img src="./img/board_title_writer.gif"/></td>
			<td background="./img/board_cont_bg.gif">&nbsp;&nbsp;<input type="text" name="writer" class="form_id" style="width:612px;height:18px"/></td>
		</tr>
		<tr height="27">
			<td align="center" bgcolor="#333436" width="100"><img src="./img/board_title_pass.gif"/></td>
			<td background="./img/board_cont_bg.gif">&nbsp;&nbsp;<input type="password" name="password" class="form_id" style="width:612px;height:18px"/></td>
		</tr>
		<tr>
			<td align="center" bgcolor="#333436" width="100"><img src="./img/board_title_content.gif"/></td>
			<td>&nbsp;&nbsp;<textarea name="content" cols="85" rows="10" class="form_id"></textarea></td>
		</tr>
		</table>
	</td>
</tr>
<tr>
	<td align="right">
		<a href="#" onClick="submit()"><img src="./img/board_btn_submit.gif" border="0"/></a>
		<img src="./img/board_btn_reset.gif" border="0" onClick="reset()" style="cursor:hand"/>
		<a href="board_list.do"><img src="./img/board_btn_list.gif" border="0"/></a>
	</td>
</tr>
</table>
</form>
</body>
</html>