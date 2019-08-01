<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="boardVo" class="springapp.dao.BoardVo" scope="request"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Spring Board</title>
<script>
//삭제하기
function fn_delete_form(){
	var oWin = window.open("board_delete.do?seq=${boardVo.seq}&groups=${boardVo.groups}","",
			"scrollbars=no,status=no,resizable=no,width=400,height=150");
}
</script>
<link href="./css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<table width="735" cellpadding="0" cellspacing="0" border="0" align="center">
<tr>
	<td><img src="./img/board_logo.gif" width="735"/></td>
</tr>
<tr>
	<td>
		<table width="735" cellpadding="0" cellspacing="0" border="1" bordercolor="#333436">
		<tr height="27">
			<td width="100" align="center" bgcolor="#333436"><img src="./img/board_title_no.gif"/></td>
			<td width="100" align="center">${boardVo.seq}</td>
			<td width="100" align="center" bgcolor="#333436"><img src="./img/board_title_date.gif"/></td>
			<td align="center">${boardVo.regdate}</td>
			<td width="100" align="center" bgcolor="#333436"><img src="./img/board_title_hit.gif"/></td>
			<td width="135" align="center">${boardVo.hit}</td>
		</tr>
		<tr height="27">
			<td align="center" bgcolor="#333436"><img src="./img/board_title_title.gif"/></td>
			<td colspan="3" align="left">&nbsp;${boardVo.title}</td>
			<td align="center" bgcolor="#333436"><img src="./img/board_title_writer.gif"/></td>
			<td align="center">${boardVo.writer}</td>
		</tr>
		<tr>
			<td align="center" bgcolor="#333436"><img src="./img/board_title_content.gif"/></td>
			<td colspan="5">
				<table width="100%" cellpadding="5" cellspacing="0" border="0">
				<tr>
					<td align="left">${content}</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
	</td>
</tr>
<tr height="50">
	<td align="right">
		<a href="board_reply.do?seq=${boardVo.seq}"><img src="./img/board_btn_reply.gif" border="0"/></a>
		<a href="board_update.do?seq=${boardVo.seq}"><img src="./img/board_btn_edit.gif" border="0"/></a>
		<a href="#" onClick="fn_delete_form()"><img src="./img/board_btn_delete.gif" border="0"/></a>
		<a href="board_list.do"><img src="./img/board_btn_list.gif" border="0"/></a>
	</td>
</tr>
</table>
</body>
</html>