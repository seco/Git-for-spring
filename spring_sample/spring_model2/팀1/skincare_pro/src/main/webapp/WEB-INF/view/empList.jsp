<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 리스트</title>
<link rel="stylesheet" href="resources/css/intro_test.css">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=cE7lhZj2k4iN7JUliTjQ&submodules=geocoder"></script> -->
</head>
<body>
<%@ include file="../../skin_jikwon_top_ver.jsp" %>
	<br><br>
	<div class="wrapper" style="text-align: center;">
		<h1 style="width: 20%; margin-left: 40%" ><a href="upload"><font color="white">직원 등록</font></a></h1>
		<div class="clear"></div>
		<div class="items" style="margin-left: 30%;" >
			<!-- single item -->
			<c:forEach var="e" items="${empList}">
				<div class="item" style="margin-bottom: 100px">
					<img
					src="resources/images/${e.emp_img}"
					alt="item" />
					<h2> ${e.emp_name}</h2>
					<p>
						<em> ${e.emp_job} </em>
					</p>
					<a href="update?emp_no=${e.emp_no}">수정</a>
					<a href="delete?emp_no=${e.emp_no}">삭제</a>
				</div>
			</c:forEach>
		</div><br>	
	</div>

<%@ include file="../../bottom.jsp" %>	
</body>
</html>