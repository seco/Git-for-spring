<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../../skin_jikwon_top_ver.jsp" %>
<br><Br>
<h1 style="font-family:'Nirmala UI';" align="center">예약자 리스트</h1>
<table border="0" style="width: 80%; margin-left: 10%; text-align: center;">
   <tr><th style="background-color: rgb(200,200,160)">이름</th>
   <th style="background-color: rgb(200,200,160)">시술명</th>
   <th style="background-color: rgb(200,200,160)">횟수</th>
   <th style="background-color: rgb(200,200,160)">승인상태</th>
   </tr>
         <c:forEach var="blist" items="${bdata}">
         <tr>
         <td style="LINE-HEIGHT: 250%">${blist.gogek_name}</td>
         <td>${blist.pro_name}</td>
         <td>${blist.pro_order_cnt}</td>   
         <td align="center">
         <form action = "change?prog_order_no=${blist.prog_order_no}" method="post">
         ${blist.state} <input type="submit" value="승인">
         </form>                     
         </td>               
      </tr>      
</c:forEach>   
         
         <tr>
         <td colspan="4" style="background-color: rgb(240,240,240)"><br></td>
         </tr>
            
         
</table>
</form>
<%@ include file="../../bottom.jsp" %>
</body>
</html>