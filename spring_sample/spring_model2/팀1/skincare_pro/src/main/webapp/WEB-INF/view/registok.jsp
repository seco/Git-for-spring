<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<%@ include file="../../skin_jikwon_top_ver.jsp" %>
<script>		
	$(document).ready(function(){
		alert("등록완료");
	});		
</script>
<br><br>
	<h1 style="font-family:'Nirmala UI';" align="center">예약자 리스트</h1>

<form action="surgical" method="post">
	<input type="submit" value="목록보기"  style="font-size:11pt;font-family:'Nirmala UI';float:right;background-color:BLACK;color:white;width:100px;height:50px;margin-top:8px; margin-right: 170px;">
</form>

<br>
<br>
<br>
<table border="0" style="width: 80%; margin-left: 10%; text-align: center;">
	<tr><th style="background-color: rgb(200,200,160)">이름</th>
	<th style="background-color: rgb(200,200,160)">관리 프로그램</th>
	<th style="background-color: rgb(200,200,160)">횟수</th>
	<th style="background-color: rgb(200,200,160)">등록일</th></tr>
			<c:forEach var="rlist" items="${prodto}">
			<tr>
			<td style="LINE-HEIGHT: 250%">${rlist.gogek_name}</td>
			<td>${rlist.pro_name}</td>
			<td>${rlist.pro_order_cnt}</td>	
			<td>${rlist.register_date}</td>					
			</tr>
</c:forEach>
	<tr>
			<td><br><br></td>
		</tr>
		<tr>
			<td colspan="4" style="background-color: rgb(240,240,240)"><br></td>
		</tr>


</table><br><br><br><br>
<%@ include file="../../bottom.jsp" %>
</body>
</html>