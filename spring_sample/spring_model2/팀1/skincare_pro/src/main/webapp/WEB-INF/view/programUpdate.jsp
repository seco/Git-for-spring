<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로그램 수정</title>
<style type="text/css">
.duoxi tr td:nth-child(2){
float:right;
}
</style>
</head>
<body>
<%@ include file="../../skin_gogek_top_ver.jsp" %>
	<br>
	<h1 style="font-family:'Nirmala UI';" align="center">프로그램 수정</h1>
	<form action="programUpdate" method="post">
		<table style="margin: 0 auto;width:470px;text-align:center" class="duoxi">
		<tr><hr style="width:470px;"></tr>
		<tr>
		<td style="text-align:center;display">
				<label style="display:block;line-height:40px;width:120px; height:40px;margin-top:20px; font-size:15px;">
					<b>프로그램 번호</b>
				</label>
			</td>
			<td>
				<input disabled="disabled" name="pro_no" value="${data.pro_no}" style="font-size:15px;text-align:center;margin-top:20px;width:340px; height:30px;">
			</td>
		</tr>
  		    <input type="hidden" name="pro_no" value="${data.pro_no}">
		
		<tr>
		<td style="text-align:center;display">
				<label style="display:block;line-height:40px;width:120px; height:40px;margin-top:20px; font-size:15px;">
					<b>프로그램명</b>
				</label>
			</td>
			<td>
				<input name="pro_name" value="${data.pro_name}" style="font-size:15px;text-align:center;margin-top:20px;width:340px; height:30px;">
			</td>
		</tr>
		<tr>
		<td style="text-align:center;display">
				<label style="display:block;line-height:40px;width:120px; height:40px;margin-top:20px; font-size:15px;">
					<b>가격</b>
				</label>
			</td>
			<td>
				<input name="pro_price" value="${data.pro_price}" style="font-size:15px;text-align:center;margin-top:20px;width:340px; height:30px;">
			</td>
		</tr>
		<tr>
		<td style="text-align:center;display">
				<label style="display:block;line-height:40px;width:120px; height:40px;margin-top:20px; font-size:15px;">
					<b>상세설명</b>
				</label>
			</td>
			<td>
				<input name="pro_detail" value="${data.pro_detail}" style="font-size:15px;text-align:center;margin-top:20px;width:340px; height:30px;">
			</td>
		</tr>
			<tr>
			<td style="text-align:center;">
				<label style="display:block;line-height:40px;width:120px; height:40px;margin-top:20px; font-size:15px;">
					<b>카테고리</b>
				</label>
			</td>
			<td style="text-align:center;margin-top: 15px;margin-right: 30px;">
			<br>
			<c:forEach var="c" items="${list }" varStatus="s">
				<c:choose>
         		<c:when test="${s.count eq data.pro_cate }">
         			<input type="radio" value="${s.count }" name="pro_cate" checked>${c }
         		</c:when>
         		<c:otherwise>
         			<input type="radio" value="${s.count }" name="pro_cate">${c }
         		</c:otherwise>
         		</c:choose>
			</c:forEach>
		</td>
		</tr>
		<tr> 
		<td colspan=2>
			<input type="submit" value="프로그램 수정" style="font-size:11pt;font-family:'Nirmala UI';background-color:BLACK;color:white;width:470px;float:left;height:50px;margin-top:20px;">
		</td>
		</tr>
	</table>
	</form>
	<br><br><br><br><br>
	<%@ include file="../../bottom.jsp" %>
</body>
</html>