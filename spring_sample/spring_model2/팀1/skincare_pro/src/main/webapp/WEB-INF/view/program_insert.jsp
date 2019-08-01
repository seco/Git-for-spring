<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로그램 등록 화면</title>
</head>
<body>
	<%@ include file="../../skin_jikwon_top_ver.jsp" %>
	<br>
	<h1 style="font-family:'Nirmala UI';" align="center">상품 등록</h1>
	<form action="program_insert" method="post">
		<table style="margin: 0 auto;width:470px;text-align:center" class="duoxi">
		<tr><hr style="width:470px;"></tr>
		<tr>
		<td style="text-align:center;">
				<label style="display:block;line-height:40px;width:120px; height:40px;margin-top:20px; font-size:15px;">
					<b>프로그램명</b>
				</label>
			</td>
			<td>
				<input name="pro_name" style="font-size:15px;text-align:center;margin-top:20px;width:340px; height:30px;">
			</td>
		</tr>
		<tr>
		<td style="text-align:center;">
				<label style="display:block;line-height:40px;width:120px; height:40px;margin-top:20px; font-size:15px;">
					<b>가격</b>
				</label>
			</td>
			<td>
				<input name="pro_price" style="font-size:15px;text-align:center;margin-top:20px;width:340px; height:30px;">
			</td>
		</tr>
		<tr>
		<td style="text-align:center;">
				<label style="display:block;line-height:40px;width:120px; height:40px;margin-top:20px; font-size:15px;">
					<b>설명</b>
				</label>
			</td>
			<td>
				<input name="pro_detail" style="font-size:15px;text-align:center;margin-top:20px;width:340px; height:30px;">
			</td>
		</tr>
		<tr>
		<td style="text-align:center;">
				<label style="display:block;line-height:40px;width:120px; height:40px;margin-top:20px; font-size:15px;">
					<b>카테고리</b>
				</label>
			</td>
		<td style="text-align:center;">
		<br>
		<c:forEach var="c" items="${list }" varStatus="s">
			<input type="radio" value="${s.count }" name="pro_cate">${c }
		</c:forEach><br>
		</td>
		</tr>
		<tr> 
		<td colspan=2>
			<input type="submit" value="프로그램 등록" style="font-size:11pt;font-family:'Nirmala UI';background-color:BLACK;color:white;width:470px;float:left;height:50px;margin-top:20px;">
		</td>
		</tr>
	</table>
	</form>
	<br><br><br><br>
	<%@ include file="../../bottom.jsp" %>
</body>
</html>