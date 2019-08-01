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
	<%@ include file="../../skin_gogek_top_ver.jsp" %>

	<div style="margin-top: 50px;text-align:center;">
		<a href="sang_order_list?gogek_id=<%= session.getAttribute("gogek") %>" class="btn btn-1" style="margin: 25px 1em 0;font-weight: 500; font-size: 18px;">상품 구매 목록</a>
		<a href="registok_gogek?gogek_id=<%= session.getAttribute("gogek") %>" class="btn btn-1" style="margin: 25px 1em 0;font-weight: 500; font-size: 18px;">프로그램 구매 목록</a>
		<a href="list" class="btn btn-1" style="margin: 25px 1em 0;font-weight: 500; font-size: 18px;">예약</a>
		<a href="join_membershipUpdate?gogek_id=<%= session.getAttribute("gogek") %>" class="btn btn-1" style="margin: 25px 1em 0;font-weight: 500; font-size: 18px;">회원수정</a>
		<img src="./image/myPage.jpg" style="width: 100%; height:100%;margin-top: 30px;">
	</div>
	<%@ include file="../../bottom.jsp" %>
</body>
</html>