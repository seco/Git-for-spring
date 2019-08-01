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
   
   $("#btn1").click(function(){
	   $("#count").attr("id","sang_order_cnt");
	   $("#count").attr("name","sang_order_cnt");
	   //alert($("#sang_order_cnt").val());
	   $("#sangFrm").attr("action","skinsang_delete");
	   $("#sangFrm").submit();
	});
});
</script>
</head>
<body>
<%@ include file="../../skin_jikwon_top_ver.jsp" %>
	<br><br><br>
	<table border="0" style="width: 70%; margin: 0 auto;">
		<tr>
			<td colspan="2" style="text-align: center; FONT-SIZE: 19pt;">
				<br><br><b>${data.sang_Bname} ${data.sang_Pname}</b><br><br>
			</td>
		</tr>
		<tr>
			<td rowspan="7" style="width: 400px;">
			<img src="image/${data.sang_image}"></td>
		</tr>
		<tr>
			<td>
			<br><br>
			판매가 : <span id="proPrice">${data.sang_price}원</span>
			</td>
		</tr>
		<tr>
			<td>
			<hr>
			수량 : ${data.sang_su}
			</td>
		</tr>
		<tr>
			<td>
			<hr>
			상품설명 ${data.sang_detail}
			</td>
		</tr>
		<tr>
			<td>
			<hr>
			<form action="skinsang_update" id="sangFrm">
				<div class="count">
					구매수량 
					<input type="button" class="button" id="minus" value=" - ">
					<input style="text-align: center; width: 70px" id="count" value="1" name="count">
					<input type="button" class="button" id="plus" value="+">
			</td>
			</tr>
			<tr>
			<td>
			<hr>
					상품 금액 합계 &nbsp;&nbsp;&nbsp;
					<span><font id="totalPrice" color="red">${data.sang_price}</span><br>

					<input type="hidden" name="gogek_id" value="<%=session.getAttribute("gogek")%>">
					<input type="hidden" name="flage" value="b">
					<input type="hidden" name="sang_no" value="${data.sang_no}">
					<input type="hidden" name="sang_Pname" value="${data.sang_Pname}">
					<input type="hidden" name="sang_price" value="${data.sang_price}">
					
			</td>
			</tr>
			<tr>
			<td>	
					<input style="font-size:9pt;font-family:'Nirmala UI';background-color:BLACK;color:white;width:100px;float:left;height:30px;" type="submit" value="수정하기">
					<button style="font-size:9pt;font-family:'Nirmala UI';background-color:BLACK;color:white;width:100px;float:left;height:30px;" id="btn1">삭제하기</button>
					<br><br>
			</td>
			</tr>

				</div>
			</form>
			</td>
		</tr>
	</table>
	<br><br>
	<%@ include file="../../bottom.jsp" %>
</body>
</html>
