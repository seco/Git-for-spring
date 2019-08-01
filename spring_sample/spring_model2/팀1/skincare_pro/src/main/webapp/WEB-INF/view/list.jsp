<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="resources/css/intro_test.css"> -->
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/calender.js"></script>
<script type="text/javascript">
	window.onload = function() {
		//document.getElementById("btnOk").addEventListener("click", funcNow, false);
		document.getElementById("btnPyear").addEventListener("click", Pyear,
				false);
		document.getElementById("btnPmonth").addEventListener("click", Pmonth,
				false);
		document.getElementById("btnNmonth").addEventListener("click", Nmonth,
				false);
		document.getElementById("btnNyear").addEventListener("click", Nyear,
				false);
	}
</script>
</head>
<body>
	<%@ include file="../../skin_gogek_top_ver.jsp" %>
	<div class="wrapper">
		<a href="rsvlist">[예약 수정/취소]</a>
		<!-- <a href="insert">추가</a><br> -->
		<!-- insert를 get으로 요청. 그러면 InsertController의 @RequestMapping의 GET을 만남 -->

		<br> <br>
		<form action="dayReserve" method="post" id="reserve_frm">
			<table style="margin: auto; padding:5px; text-align:center">
				<tr><th colspan=5 style="font-weight: bold; text-align: center;">고객이 신청한 프로그램</th></tr>
				<tr>
					<td>프로그램</td>
					<td>신청횟수</td>
					<td>관리횟수</td>
					<td>신청날짜</td>
					<td>상태</td>
				</tr>
				<tr><th colspan=5><hr></th></tr>
				<c:forEach var="pr" items="${progRsvList}">
				<c:choose>
				    <c:when test="${pr.state eq '승인'}">
				   		<tr id="prog_row"><td>${pr.pro_name}<input type="hidden" value="${pr.prog_order_no}"></td><td>${pr.pro_order_cnt}</td><td>${pr.pro_order_reserve_cnt}</td><td>${pr.register_date}</td><td>${pr.state}</td></tr>    
				    </c:when>
				    <c:otherwise>
				        <tr  style="background-color: red"><td>${pr.pro_name}<input type="hidden" value="${pr.prog_order_no}"></td><td>${pr.pro_order_cnt}</td><td>${pr.pro_order_reserve_cnt}</td><td>${pr.register_date}</td><td>${pr.state}</td></tr>
				    </c:otherwise>
				</c:choose>
				
				</c:forEach>
			</table>
			<input type="hidden" name="prog_order_no">
			 <input type="hidden" name="reserve_date"> 
			 <input type="hidden" name="time_unit">
			 <input type="hidden" name="careManager_no">
		</form>
		<br>
		<div id="disp"></div>

		<div id="etc" style="display: none; text-align: center;">
			<button id="btnPyear" style="float: none">이전 년</button>
			<button id="btnPmonth" style="float: none">이전 월</button>
			<button id="btnNmonth" style="float: none">다음 월</button>
			<button id="btnNyear" style="float: none">다음 년</button>
		</div>
		<br>


		<div id="timeList"></div>
		<div id="mgrList"></div>	
	</div>
</body>
</html>