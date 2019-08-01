<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr style="width:80%;margin-left: 105px;">
		<table style="width:80%;margin: 0 auto; margin-top: 20px; margin-bottom: 30px;">
		<tr>
		<td style="text-align: left;FONT-SIZE: 10pt;"><b>반갑습니다 고객님</b>, (주)SkincareJO 주식회사: 조미정 010.9451.6481</td>
		<td style="text-align: right;margin-left: 30px;margin-top: 15px;margin-bottom: 30px;FONT-SIZE: 10pt;">
		<%
		if(session.getAttribute("gogek") == null) {
			if(session.getAttribute("name") == null) {
		%>
			<a href="skinsang_list" style="color: #000;">관리자 로그인</a>
		<%}else {%>
			<a href="skinsang_list" style="color: #000;">관리자 화면으로</a>
		<%
			}
		}%>
		</td>
	</tr>
</table>
</body>
</html>