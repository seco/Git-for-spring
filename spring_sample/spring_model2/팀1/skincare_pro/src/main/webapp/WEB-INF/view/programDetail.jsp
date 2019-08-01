<%@page import="pack.model.ProgramDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var counter = 1;
	var proPrice = parseInt($("#proPrice").text());
	
	$("#plus").click(function(){
	  counter++;
	  $("#count").val(counter);
	  $("#totalPrice").text(counter * proPrice);
	});
	
	$("#count").keydown(function(key) {
		if (key.keyCode == 13) {
			counter = $("#count").val();
			$("#count").val(counter);
			$("#totalPrice").text(counter * proPrice);
	}
	});

	$("#minus").click(function(){
		if (counter <= 1) {
			counter = 1;
			$("#count").val(counter);
			$("#totalPrice").text(counter * proPrice);
        }
        else {
          counter--;
      	  $("#count").val(counter);
      	  $("#totalPrice").text(counter * proPrice);
        }
	});
	
	$("#registok").click(function(){
		$("#regform").attr("action", "registok");
		$("#count").attr("id", "pro_order_cnt");
		$("#count").attr("name", "pro_order_cnt");
		$("#regform").submit();
	});
	
});
</script>
</head>
<body>
<% if(session.getAttribute("name") == null) {
	%>
	<%@ include file="../../skin_gogek_top_ver.jsp" %>
	<%
}else {
	%>
	<%@ include file="../../skin_jikwon_top_ver.jsp" %>
	<%
}
%>

	<div style="text-align: center; margin-top: 50px;">
		<c:forEach var="c" items="${programCate}">
			<a href="program_list?pro_cate=${c.cate_no}" class="btn btn-1" style="margin: 25px 1em 0;font-weight: 700; font-size: 22px;"> ${c.cate_name}</a>
		</c:forEach>
	</div>
	<br>
	<div style="text-align: center; margin-top: 50px;">
		
		<%-- <img src="resources/images/${programDetail.pro_image}"><br><br> --%> 
		<font style="font-size: 30px">${programDetail.pro_name}</font> 
		<br><br> 
		${programDetail.pro_detail}
		<br><br> 
		<font style="color: rgb(113,129,77); font-size: 22px">1회 <span id="proPrice">${programDetail.pro_price}</span>원</font>
		<br>
		<br>
		
		<form action="proCart" id="regform">
		<div class="count">
			<input type="button" class="button" id="minus" value=" - "> 
			<input id="count" name="count" value="1" style="text-align: center;width: 70px;">
			<input type="button" class="button" id="plus" value="+">
		</div>
		<br><br>
		<br> 상품 금액 합계 &nbsp;&nbsp;&nbsp; 
		<p id="totalPrice" style="color: red; font-size: 18px">${programDetail.pro_price}</p><br>
  
 			<input type="hidden" name="gogek_id" value="<%= session.getAttribute("gogek") %>">
			<input type="hidden" name="flage" value="b">
			<input type="hidden" name="pro_no" value="${programDetail.pro_no}">
			<input type="hidden" name="pro_name" value="${programDetail.pro_name}">
			<input type="hidden" name="pro_price" value="${programDetail.pro_price}">
			<%
				if(session.getAttribute("name") != null) {
				%>
				<div style="margin-left: 35%">
					<form action="programUpdate?pro_no=${programDetail.pro_no }">	
						<input type="submit" value="수정하기" style="font-size:11pt;font-family:'Nirmala UI';background-color:BLACK;color:white;width:230px;float:left;height:50px;margin-top:20px;">	
					</form>
					<form action="programDelete?pro_no=${programDetail.pro_no }">
						<input type="submit" value="삭제하기" style="font-size:11pt;font-family:'Nirmala UI';background-color:BLACK;color:white;width:230px;float:left;height:50px;margin-top:20px;">
					</form>
				</div>
				<%
				}else {
				%>
				<div style="margin-left: 35%">
				<input type="submit" style="font-size:11pt;font-family:'Nirmala UI';background-color:BLACK;color:white;width:230px;float:left;height:50px;margin-top:20px;" value="장바구니">
				<button id="registok" style="font-size:11pt;font-family:'Nirmala UI';background-color:BLACK;color:white;width:230px;float:left;height:50px;margin-top:20px;">구매하기</button>
				</div>
				<%
				}
			%>
		</form>
		</div><br><br><br><br><br><br>
	<%@ include file="../../bottom.jsp" %>
</body>
</html>