<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
   src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
   $(document).ready(function() {
      var counter = 1;
      var proPrice = parseInt($("#proPrice option:selected").attr("id"));

      $("#totalPrice").text(0);

      $("#plus").click(function() {
         proPrice = $("#proPrice option:selected").attr("id");
         //alert($("#proPrice").val())
         counter++;
         $("#count").val(counter);
         //$("#totalPrice").text(counter * $("#proPrice option:selected").val());
         $("#totalPrice").text(counter * proPrice);
      });

      $("#count").keydown(function(key) {
         if (key.keyCode == 13) {
            counter = $("#count").value;
            $("#count").val(counter);
            $("#totalPrice").text(counter * proPrice);
         }
      });

      $("#proPrice").change(function() { //상품목록을 바꿀때마다 총 가격 나오기
         var proPrice = $("#proPrice option:selected").attr("id");
         //alert($("#proPrice").val())

         $("#count").val(counter);
         //$("#totalPrice").text(counter * $("#proPrice option:selected").val());
         $("#totalPrice").text(counter * proPrice);
      });

      $("#minus").click(function() {
         if (counter <= 1) {
            counter = 1;
            $("#count").val(counter);
            $("#totalPrice").text(counter * proPrice);
         } else {
            counter--;
            $("#count").val(counter);
            $("#totalPrice").text(counter * proPrice);
         }
      });
   });
</script>


</head>
<body>
<%@ include file="../../skin_gogek_top_ver.jsp" %>
<br>
<br>
   <h1 style="font-family:'Nirmala UI';" align="center">${dto.gogek_name}님의예약 등록</h1>
   <form action="registok" method="post">
      <table border="0" style="width: 80%; margin-left: 10%; text-align: center;">
         <tr>
            <th style="background-color: rgb(200,200,160)">상품 종류 및 가격</th>
            <th style="background-color: rgb(200,200,160)">구매수량</th>
            <th style="background-color: rgb(200,200,160)">상품 금액 합계</th>
         </tr>
         <tr>
            <td>
             <select id="proPrice" name="pro_no">
                  <option value="선택" style="">선택</option>
                  <c:forEach var="p" items="${program}">
                     <option value="${p.pro_no}" id="${p.pro_price}">
                        ${p.pro_name}-${p.pro_detail}(${p.pro_price}원)</option>

                  </c:forEach>

            </select> <input type="hidden" name="gogek_id" value="${dto.gogek_id}">
            </td>
      
         
            <td>
               <div class="count">
                  &nbsp;&nbsp; <input type="button" class="button" id="minus"
                     value=" - "> <input id="count" name="pro_order_cnt" value="1"
                     style="text-align: center; width: 70px;"> <input
                     type="button" class="button" id="plus" value="+">
               </div>
            </td>
      
         
            <td><br>  &nbsp;&nbsp;&nbsp;
               <p id="totalPrice"></p></td>
         
         </tr>
         <tr>
         <td><br><br></td>
      </tr>
      <tr>
         <td colspan="3" style="background-color: rgb(240,240,240)"><br></td>
      </tr>
         
      </table>
      <input type="submit" value="등록" style="font-size:11pt;font-family:'Nirmala UI';background-color:BLACK;color:white;width:50px;float:right;height:30px;margin-top:20px;margin-right:200px;">
   </form>
   <br>
   <br>
   <br>
   <%@ include file="../../bottom.jsp" %>
</body>
</html>