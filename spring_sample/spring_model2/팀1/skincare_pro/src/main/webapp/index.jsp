<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<link href="css/style_top.css" rel="stylesheet" type="text/css">
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head>
	<body>
	<br><br>
	<c:url value="/showMessage.html" var="messageUrl" />
	<div style="margin-left: 70%">
	<a href="skinsang_list">관리자 로그인</a>
	<a href="cartList">나의 장바구니</a>
	<%if(session.getAttribute("gogek") != null){ %>
		<a href="logout">로그아웃</a>
	<%}else{ %>
		<a href="gogek_login">고객로그인</a>
	<%} %>
	</div>
	<br>
		<i style="margin-left: 100px"><a href="main.jsp">메인으로</a></i>
		<i style="margin-left: 100px"><a href="skinsang_list_gogek">상품목록</a></i>
		<i style="margin-left: 100px"><a href="content">프로그램 안내</a></i>
		<i style="margin-left: 100px"><a href="survey">칭찬/불만</a></i>
		<i style="margin-left: 100px"><a href="surgical">시술 리스트</a></i>
		<i style="margin-left: 100px"><a href="intro">소개</a></i>
		<i style="margin-left: 100px"><a href="upload">업로드</a></i>
		<i style="margin-left: 100px"><a href="approvalList">승인화면</a></i>
		<br><br>
		<hr>
	</body>
</html>
