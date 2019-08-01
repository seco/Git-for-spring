<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../../skin_jikwon_top_ver.jsp" %>
<h2> 신청 리스트 </h2>
<form>
<c:forEach var="a" items="${list}">
	${a.c_no}&nbsp;${a.c_phone}&nbsp;${a.c_name}&nbsp;${a.pro_name}&nbsp;${a.pro_order_cnt}&nbsp;${a.register_date}&nbsp;${a.pro_name}
	&nbsp; 
	<a href="#">승인</a> <br>
</c:forEach>

</form>
<%@ include file="../../bottom.jsp" %>
</body>
</html>