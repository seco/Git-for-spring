<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자: attendance</title>
<link href="css/style_top.css" rel="stylesheet" type="text/css">
</head>
<body class="ter_atten_body" style="margin: 0;">
	<header style="margin: 0;">
	<div class="ter_atten_div">
		<a href="main_intro.jsp"><img src="image/logo_h.png" style="width: 300px;margin-top: 35px;"></a>
		<br>
			<div style="margin-top: 22px;">
				<a href="content" class="btn btn-1">Program</a> 
				<a href="skinsang_list_gogek" class="btn btn-1">Product</a> <a href="survey" class="btn btn-1">Comment</a>
				<a href="cartList" class="btn btn-1">Cart</a>
				<%if (session.getAttribute("gogek") != null) {%> 
				<a href="myPage" class="btn btn-1">MyPage</a>
				<a href="logout" class="btn btn-1">Logout</a>
				<%} else {%>
				<a href="gogek_login" class="btn btn-1">Login</a>
				<%} %>
			</div>
		</div>
	 </header>
</body>
</html>