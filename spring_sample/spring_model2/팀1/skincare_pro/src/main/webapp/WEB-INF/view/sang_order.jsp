<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	   var counter = 1;
	   var proPrice = parseInt($("#proPrice").text());
	   
	   $("#order").click(function(){
		  $("#order");
	   });
	   
});
</script>
</head>
<body>
	<%@ include file="../../skin_gogek_top_ver.jsp" %>
	<br><br><br><br>
	<div style="text-align: center;"><font style="font-size: 30px;">상품 주문 목록</font></div>
	<br><br><br>
	<c:choose>
		<c:when test="${list.size() eq 0}">
		<h2 style="text-align: center;">구매내역이 없습니다</h2>
		</c:when>
	<c:otherwise>
	<table style="width: 60%; margin-left: 20%" border="0">
		<tr>
			<th style="background-color: rgb(200,200,160)">주문번호</th>
			<th style="background-color: rgb(200,200,160)">주문 시간</th>
			<th style="background-color: rgb(200,200,160)">상품명</th>
			<th style="background-color: rgb(200,200,160)">수량</th>
			<th style="background-color: rgb(200,200,160)">상태</th>
		</tr>
		<c:forEach var="s" items="${list}" varStatus="status">
		<tr>
			<th>${s.sang_order_no }</th>
			<th>${s.register_date }</th>
			<th>${s.sang_Pname }</th>
			<th>${s.sang_order_cnt }</th>
			<th>${s.state }</th>
		</tr>
		</c:forEach>
		<tr>
			<td><br><br></td>
		</tr>
		<tr>
			<td colspan="5" style="background-color: rgb(240,240,240)"><br></td>
		</tr>
		
	</table>
	</c:otherwise>
	</c:choose>
	<br><br><br><br><br><br>
	<%@ include file="../../bottom.jsp" %>
</body>
</html>