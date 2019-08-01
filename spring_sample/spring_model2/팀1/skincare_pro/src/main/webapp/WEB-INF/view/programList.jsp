<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로그램 안내</title>
<link href="css/style_top.css" rel="stylesheet" type="text/css">
</head>
<body class="ter_atten_body">
<%
	if(session.getAttribute("name") != null) {
%>
	<%@ include file="../../skin_jikwon_top_ver.jsp" %>
<%
	}else{
%>
	<%@ include file="../../skin_gogek_top_ver.jsp" %>
<%
	}
%>
	<div style="margin-top: 50px;text-align:center;">
		<c:forEach var="c" items="${programCate}">
			<a href="program_list?pro_cate=${c.cate_no}" class="btn btn-1" style="margin: 25px 1em 0;font-weight: 700; font-size: 22px;"> ${c.cate_name}</a>
		</c:forEach>
		<br>
		<c:forEach var="c" items="${programList}">
			<a href="program_detail?pro_no=${c.pro_no}" class="btn btn-1" style="margin: 25px 1em 0;">${c.pro_name}</a>
		</c:forEach><br><br>
		<%if(session.getAttribute("name") != null) {  %>
		<form action="program_insert">
			<div style="margin-left: 42%">
				<input type="submit" value="프로그램 등록" style="font-size:11pt;font-family:'Nirmala UI';background-color:BLACK;color:white;width:230px;float:left;height:50px;margin-top:20px;">
			</div>
		</form><br><br>
		<%} %>
		
		<img src="./image/program.jpeg" style="width: 100%; height:100%;margin-top: 30px;">
	</div>
	
	<%@ include file="../../bottom.jsp" %>
</body>
</html>