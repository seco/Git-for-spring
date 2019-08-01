<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	if(session.getAttribute("name") == null) {
	%>
		<script>
		$(document).ready(function(){
			alert("등록완료");
		});	
		</script>
	<%
	response.sendRedirect("survey");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
<%@ include file="../../skin_gogek_top_ver.jsp" %>
	<br><br><br>
	<h3 style="text-align:center;">칭찬 / 불만 리스트</h3>
	<br>
	
	<table border="0" style="width: 60%; margin-left: 20%">
	<tr>
		<th style="background-color: rgb(200,200,160)">칭찬/불만</th>
		<th style="background-color: rgb(200,200,160)">이름</th>
		<th style="background-color: rgb(200,200,160)">전화번호</th>
		<th style="background-color: rgb(200,200,160)">내용</th>
	</tr>
	<c:forEach var="s" items="${data}">
	<tr>
	<th>${s.comment}</th>  <!--칭찬/불만 --> 
	<th>${s.name}</th> <!--이름  -->
	<th>${s.phone}</th> <!--번호 -->
	<th>${s.text}</th> <!--내용  -->
	</tr>
	</c:forEach>
	<tr>
  		<th><br><br></th>
  	</tr>
  	<tr>
  		<th colspan="4" style="background-color: rgb(240,240,240)"><br></th>
  	</tr>
</table>
<br><br><br><br><br><br>
<%@ include file="../../bottom.jsp" %>
</body>
</html>