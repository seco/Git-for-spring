<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>고객 주문 목록</title>
</head>
<body>
	<%@ include file="../../skin_gogek_top_ver.jsp" %>
	<br><br><br><br>
	<div style="text-align: center;"><font style="font-size: 30px;">프로그램 주문 목록</font></div>
	<br><br><br>
	<table border="0" style="width: 80%; margin-left: 10%; text-align: center;">
	<tr>
		<th style="background-color: rgb(200,200,160)">이름</th>
		<th style="background-color: rgb(200,200,160)">시술명</th>
		<th style="background-color: rgb(200,200,160)">남은 횟수</th>
		<th style="background-color: rgb(200,200,160)">등록일</th>
		<th style="background-color: rgb(200,200,160)">승인상태</th>
	</tr>
	<c:forEach var="rlist" items="${prodto}">
		<tr>
			<td style="LINE-HEIGHT: 250%">${rlist.gogek_name}</td>
			<td>${rlist.pro_name}</td>
			<td>${rlist.pro_order_cnt}</td>	
			<td>${rlist.register_date}</td>
			<td>${rlist.state}</td>					
		</tr>
	</c:forEach>
		<tr>
			<td><br><br></td>
		</tr>
		<tr>
			<td colspan="5" style="background-color: rgb(240,240,240)"><br></td>
		</tr>
	</table>	
	<br><br><br><br><br><br>
	<%@ include file="../../bottom.jsp" %>
</body>
</html>