<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../../skin_jikwon_top_ver.jsp" %>
<h3>업로드된 파일 정보</h3>
파일명: ${filename}<br>

<form action="download" method="post">
<input type="hidden" name="filename" value="${filename}">
<input type="submit" value="download">

</form>
<%@ include file="../../bottom.jsp" %>
</body>
</html>