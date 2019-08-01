<%@page import="pack.model.CartSangBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pack.model.CartBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% ArrayList<CartSangBean> sanglist = (ArrayList<CartSangBean>) session.getAttribute("cartSangList"); %>
<% ArrayList<CartBean> prolist = (ArrayList<CartBean>) session.getAttribute("cartList"); %>
<%
	System.out.println(sanglist);
	System.out.println(prolist);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#sangbtnCha").click(function(){
		// alert($("#count").val())
		alert("상품 수량이 변경되었습니다.");
		$("#sangPrice").text($("#sangPrice").text() * $("#sCount").val());
		<%
		session.setAttribute("cartSangList", sanglist);

		%>
	});
});

$(document).ready(function(){
	$("#probtnCha").click(function(){
		// alert($("#count").val())
		alert("프로그램 수량이 변경되었습니다.");
		$("#proPrice").text($("#proPrice").text() * $("#pCount").val());
		<%
		session.setAttribute("cartList", prolist);
		%>
	});
});
</script>
</head>
<body>
<%@ include file="../../skin_gogek_top_ver.jsp" %>
	
	<br><br><br>
	<h3 style="text-align:center;">관리 제품</h3>
	<br>
<%
	if(sanglist.size() <= 0 || sanglist == null){
%>
		<div style="text-align:center;">
		.<br>
		.<br>
		.<br><br>
		There is no product
		<div>
<%
	}else{
%>
			<table style="width: 80%; margin-left: 10%;text-align:center;" border="0">
			<tr>
				<th style="background-color: rgb(200,200,160)">제품코드</th>
				<th style="background-color: rgb(200,200,160)">상품명</th>
				<th style="background-color: rgb(200,200,160)">수량</th>
				<th style="background-color: rgb(200,200,160)">주문 금액</th>
			</tr>
<%
		for(CartSangBean bean:sanglist){
			
%>
			<tr>
			<td><span id="sang_no"><%=bean.getSang_no() %></span></td>
			<td><%=bean.getSang_Pname() %></td>
			<td><input id="sCount" type="text" value="<%=bean.getCount() %>"><input id="sangbtnCha" type="button" value="변경">
				<a href="sangDelete?sang_no=<%=bean.getSang_no() %>">삭제</a>
			</td>
			<td><span id="sangPrice"><%=bean.getSang_price()* Integer.parseInt(bean.getCount())  %></span></td>
			</tr>
  <%}%>		
  			<tr>
  				<th><br><br></th>
  			</tr>
  			<tr>
  				<th colspan="4" style="background-color: rgb(240,240,240)"><a href="sang_order_jang?gogek_id=<%= session.getAttribute("gogek")%>">상품 구매하기</a></th>
  			</tr>
			</table>
<%}%>
	<br><br>
	<br><br>
	<h3 style="text-align:center;">관리 프로그램</h3>
	<br>
<%
	if(prolist.size() <= 0 || prolist == null){
%>
		<div style="text-align:center;">
		.<br>
		.<br>
		.<br><br>
		There is no program
		<div>
<%
	}else{
%>
			<table style="width: 80%; margin-left: 10%;text-align:center;" border="0">
			<tr>
				<th style="background-color: rgb(200,200,160)">상품코드</th>
				<th style="background-color: rgb(200,200,160)">프로그램명</th>
				<th style="background-color: rgb(200,200,160)">수량</th>
				<th style="background-color: rgb(200,200,160)">주문 금액</th>
			</tr>
<%
		for(CartBean bean:prolist){
%>
			<tr>
			<td><%=bean.getPro_no() %></td>
			<td><%=bean.getPro_name() %></td>
			<td><input id="pCount" type="text" value="<%=bean.getCount() %>"><input id="probtnCha" type="button" value="변경"></td>
			<td><span id="proPrice"><%=bean.getPro_price()*bean.getCount()  %></span></td>
			</tr>
<%
		}
%>			
			<tr>
  				<th><br><br></th>
  			</tr>
  			<tr>
  				<th colspan="4" style="background-color: rgb(240,240,240)"><br></th>
  			</tr>
			</table>
			
<%	
	}
%>
<br><br><br><br><br><br>
<%@ include file="../../bottom.jsp" %>
</body>
</html>