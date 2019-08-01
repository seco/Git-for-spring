<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${requestScope.say}
${say}
<% String ss = (String)request.getAttribute("say"); 
out.print(ss);%>
 
</body>
</html>