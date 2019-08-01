
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
</style>
</head>
<body>
<%@ include file="../../skin_gogek_top_ver.jsp" %>
	<br>
	<c:forEach var="m" items="${data}" varStatus="status">
		<c:if test="${status.last }">
			<div style="text-align: center; font-size: 15px;margin-top: 40px"><font face="돋움">
			<b>현재 SKIN CARE JO에 등록된 상품은
			<span style="color: red">총 ${status.count }개</span> 입니다. </b></font>
			</div>
		</c:if>
	</c:forEach>
	<br>
	<table style="margin-left: 150px; text-align: center;" border="0">
	<tr> 
	<c:forEach var="m" items="${data}" varStatus="status">
    <c:choose>
         <c:when test="${status.count % 5 eq 0}">
         <tr>
            <td>
            <table>
            <tr><td>
		<a href="skinsang_detail_gogek?sang_no=${m.sang_no}">
			<img src="image/${m.sang_image}" width="300" height="300">
		</a>
	    </td></tr>
            <tr><td><font style="font-size: 20px">${m.sang_Bname}</font></td></tr>
            <tr><td><font style="font-size: 15px">${m.sang_Pname}</font></td></tr>
             <tr><td><font style="font-size: 18px" color="red"><b>${m.sang_price}</b></font></td></tr>
	    </table>
            </td>
         </c:when>
	 <c:otherwise>
            <td>
            <table style="text-align: center;" border="0">
            <tr><td>
		<a href="skinsang_detail_gogek?sang_no=${m.sang_no}">
			<img src="image/${m.sang_image}" width="300" height="300">
		</a>
	    </td></tr>
            <tr><td><font style="font-size: 20px">${m.sang_Bname}</font></td></tr>
            <tr><td><font style="font-size: 15px">${m.sang_Pname}</font></td></tr>
            <tr><td><font style="font-size: 18px" color="red"><b>${m.sang_price}</b></font></td></tr>
            </table>
            </td>   
        </c:otherwise>
   </c:choose>
</c:forEach>
</table>
<br>
<br>
<br>
	<%@ include file="../../bottom.jsp" %>
</body>
</html>