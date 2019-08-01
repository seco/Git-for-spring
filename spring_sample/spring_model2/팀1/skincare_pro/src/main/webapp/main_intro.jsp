
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Welcome</title>
<link rel="stylesheet" href="resources/css/intro_test.css">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=cE7lhZj2k4iN7JUliTjQ&submodules=geocoder"></script>

</head>
<body>
	<%@ include file="../../skin_gogek_top.jsp" %>
	<!-- wrapper -->
	<div class="wrapper">
		<!-- <span><i class="shopping-cart"></i></span> -->
		<img src="image/intro_1.jpg" style="width: 100%; height:100%;margin-top: 30px;">
		<div class = "imgcover">
			<img src="image/intro_2.jpg" style="float:left; width:100%;margin-top: 50px;">
		</div>
		<br>
			<img src="image/intro_22.jpg" style="width: 90%; height:100%;margin-left: 80px;margin-top: 30px;">
		<br>
		<div class = "imgcover">
			<img src="image/intro_3.jpg" style="margin-top: 30px;">
			<img src="image/intro_4.jpg">
			<img src="image/intro_5.jpg">
		</div>
		<div class="clear"></div>
		<!-- items -->
		<div class="items">
			<!-- single item -->
			<c:forEach var="e" items="${empScList}">
				<div class="item">
					<img
					src="resources/images/${e.emp_img}"
					alt="item" />
					<h2> ${e.emp_name}</h2>
					<p>
						<em> ${e.emp_job} </em>
					</p>
				</div>
			</c:forEach>
		</div>
		<!--/ items -->
		<br>
	
	</div>
<div id="map" style="width: 70%; height: 400px; margin: auto"></div>
	<script>
		var map = new naver.maps.Map('map');
		var myaddress = '서울특별시 강남구 테헤란로1길 10, 세경빌딩';// 도로명 주소나 지번 주소만 가능 (건물명 불가!!!!)
		naver.maps.Service
				.geocode(
						{
							address : myaddress
						},
						function(status, response) {
							if (status !== naver.maps.Service.Status.OK) {
								return alert(myaddress
										+ '의 검색 결과가 없거나 기타 네트워크 에러');
							}
							var result = response.result;
							// 검색 결과 갯수: result.total
							// 첫번째 결과 결과 주소: result.items[0].address
							// 첫번째 검색 결과 좌표: result.items[0].point.y, result.items[0].point.x
							var myaddr = new naver.maps.Point(
									result.items[0].point.x,
									result.items[0].point.y);
							map.setCenter(myaddr); // 검색된 좌표로 지도 이동
							// 마커 표시
							var marker = new naver.maps.Marker({
								position : myaddr,
								map : map
							});
							// 마커 클릭 이벤트 처리
							naver.maps.Event.addListener(marker, "click",
									function(e) {
										if (infowindow.getMap()) {
											infowindow.close();
										} else {
											infowindow.open(map, marker);
										}
									});
							// 마크 클릭시 인포윈도우 오픈
							var infowindow = new naver.maps.InfoWindow(
									{
										content : '<h4>[KIC skin]</h4><a href="http://localhost/x_skin/index.jsp" target="_blank"><img src="https://developers.naver.com/inc/devcenter/images/nd_img.png"></a>'
									});
						});
	</script>
	<br>
	<br>
	<br>
	<br>
	<%@ include file="../../bottom.jsp" %>

</body>
</html>