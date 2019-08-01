<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/reserve.js"></script>
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
<body>
<%@ include file="../../skin_gogek_top_ver.jsp" %>
<a href="list">[예약]</a>
	<c:choose>
		<c:when test="${reserveList.size()==0}">
		<p style="text-align: center">예약된 프로그램이 존재하지 않습니다.</p>
    </c:when>
		<c:otherwise>
		
			<table style="margin: auto;">
				<tr> 
					<th>프로그램명</th>
					<th>예약날짜</th>
					<th>관리사</th>
					<th>신청횟수</th>
					<th>예약횟수</th>
					<th>변경/삭제</th>
				</tr>
				<tr><td colspan=7><hr></td></tr>
				<c:forEach var="rsv" items="${reserveList}" varStatus="status">
					<tr>
					
						<td><input class="pon_${status.index}" type="hidden" value="${rsv.prog_order_no}">${rsv.pro_name}</td>
						<td><input class="tu_${status.index}" type="hidden" value="${rsv.time_unit}"><input class="tno_${status.index}" type="hidden" value="${rsv.time_reserve_no}"><input id="rsv_date" class="rsvdate_${status.index}" type="text" value="${rsv.reserve_date} ${rsv.time_avail}"></td>
						<td><input class="cn_${status.index}" type="hidden" value="${rsv.emp_no}"><input class="en_${status.index}" type="text" value="${rsv.emp_name}"></td>
						<td><input class="rd_${status.index}" type="hidden" value="${rsv.reserve_date}"> ${rsv.pro_order_cnt}</td>
						<td>${rsv.pro_order_reserve_cnt}</td>
						<td><button class="rsvchange_${status.index}" type="button">변경</button><button type="button" class="rsvcancel_${status.index}">취소</button></td>
					</tr>

				</c:forEach>
			</table>
	
		<div id="disp" style='padding: 30px;'></div>
		<div id="etc" style="display: none; text-align:center">
			<button id="btnPyear" style="float: none">이전 년</button>
			<button id="btnPmonth" style="float: none">이전 월</button>
			<button id="btnNmonth" style="float: none">다음 월</button>
			<button id="btnNyear" style="float: none">다음 년</button>
		</div>
		
		<div id="timeList"></div>
		<div id="mgrList"></div>
		<div id="btndiv" style="display:none;"><button type="button"></button></div>
		</c:otherwise>
	</c:choose>
	<form id="updateFrm" action="updateRsv">
		<input name="prog_order_no" type="hidden">
		<input name="reserve_date" type="hidden">
		<input name="time_unit" type="hidden">
		<input name="careManager_no" type="hidden">
		<input name="time_reserve_no" type="hidden">
	</form>
</body>
</html>