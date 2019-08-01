<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../../skin_jikwon_top_ver.jsp" %>

<br><br> 
<br><br>
	<h1 style="font-family:'Nirmala UI';" align="center">고객 리스트</h1>
	<br><br><br>
<form action="blist" method="post">
   <input type="submit" value="비승인목록" style="font-size:11pt;font-family:'Nirmala UI';background-color:BLACK;color:white;text-align:center;margin-left:84%;width:100px;height:30px;margin-top:20px;">
</form> 
<table border="0" style="width: 80%; margin-left: 10%; text-align: center;">
	<tr><th style="background-color: rgb(200,200,160)">고객번호</th>
	<th style="background-color: rgb(200,200,160)">이름</th>
	<th style="background-color: rgb(200,200,160)">전화번호</th></tr>
	<c:forEach var="s" items="${data}">
		<tr>
			<td style="LINE-HEIGHT: 250%">${s.gogek_id}</td>
			<td><a href="reserve?gogek_id=${s.gogek_id}">${s.gogek_name}</a></td>
			<td>${s.gogek_phone}</td>			
		</tr>	
	</c:forEach>
	<!--검색!!! -->
	 <tr>
		<td colspan="3">
		<form action="search" method="post">
		고객명: <input type="text" name="searchValue">  
		<input type="submit" value="검색" style="font-size:11pt;font-family:'Nirmala UI';background-color:BLACK;color:white;width:50px;height:30px;margin-top:20px;">
		</form>
		</td>
	</tr> 
		<tr>
			<td><br><br></td>
		</tr>
		<tr>
			<td colspan="3" style="background-color: rgb(240,240,240)"><br></td>
		</tr>

</table>
<br><br>

	<h1 style="font-family:'Nirmala UI';" align="center">예약자 리스트</h1>
	<br><br><br>
<table border="0" style="width: 80%; margin-left: 10%; text-align: center;">

	<tr><th style="background-color: rgb(200,200,160)">이름</th>
	<th style="background-color: rgb(200,200,160)">관리 프로그램</th>
	<th style="background-color: rgb(200,200,160)">횟수</th>
	<th style="background-color: rgb(200,200,160)">등록일</th></tr>
		
	<c:forEach var="alist" items="${prodto}">
			<tr>
			<td style="LINE-HEIGHT: 250%">${alist.gogek_name}</td>
			<td>${alist.pro_name}</td>
			<td>${alist.pro_order_cnt}</td>	
			<td>${alist.register_date}</td>					
			</tr>		
	</c:forEach>	
	 <tr>
		<td colspan="4">
		<form action="search1" method="post">
		고객명: <input type="text" name="searchValue">  
		<input type="submit" value="검색" style="font-size:11pt;font-family:'Nirmala UI';background-color:BLACK;color:white;width:50px;height:30px;margin-top:20px;">
		</form>
		</td>
	</tr> 

	<tr>
			<td><br><br></td>
		</tr>
		<tr>
			<td colspan="4" style="background-color: rgb(240,240,240)"><br></td>
		</tr>
	
	
</table>
<br><br><br><br>
<%@ include file="../../bottom.jsp" %>
</body>
</html>