<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 수정</title>
</head>
<body>
<%@ include file="../../skin_gogek_top_ver.jsp" %>
<br><br><br>
	<h3 style="text-align:center;">고객 정보</h3>
	<br>
<table class="table" style="width: 30%; margin-left: 35%">
<tr>
	<td align="center" valign="middle" style="background-color: #FFFFCC">
		<form name="regForm" method="post" action="join_membershipUpdate">
			<table border="1">
				<tr align="center" style="background-color: #8899aa">
					<td colspan="2"><b style="color: #FFFFFF">회원 수정</b></td>
				</tr>
				<tr>
					<td width="16%">아이디</td>
					<td width="57%">
					${gogek.gogek_id}
					<input type="hidden" value="${gogek.gogek_id}" name="gogek_id">
				</tr>
				<tr>
					<td>패스워드</td>
					<td><input type="password" name="gogek_password" size="15" value="${gogek.gogek_password}"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="gogek_name" size="15" value="${gogek.gogek_name}"></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="gogek_phone" size="20" value="${gogek.gogek_phone}"></td>
				</tr>		
				<tr>
					<td colspan="2" align="center">
						<input type="submit"
						value="수정완료" id="btnUpdate">
						&nbsp;&nbsp;&nbsp;&nbsp; 
					<!-- 	<input type="button"
						value="수정취소" id="btnUpdateCancel"> -->
					<!-- 	<input type="button"
						value="회원탈퇴" id="btnDelete">
 -->
					</td>
				</tr>
			</table>
		</form>
	</td>
</tr>
</table>
<br><br><br><br><br><br>
<%@ include file="../../bottom.jsp" %>
</body>
</html>