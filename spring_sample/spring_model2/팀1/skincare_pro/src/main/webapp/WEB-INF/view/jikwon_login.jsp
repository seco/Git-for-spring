<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.duoxi tr td:nth-child(2){
float:right;
}
</style>
<script type="text/javascript">
window.onload = function(){
	document.getElementById("btnLogin").addEventListener("click", funcLogin, false);
	document.getElementById("btnBack").addEventListener("click", funcBack, false);
}

function funcLogin() {
	// alert("a");
	if(jikwon_login.jikwon_id.value === "" || jikwon_login.jikwon_password.value === ""){
		alert("아이디 또는 비밀번호를 입력하세요");
	}else{
		jikwon_login.submit();
	}
}
function funcBack() {
	// alert("b");
	location.href = "history.back()";
}
</script>
</head>
<body>
<%@ include file="../../skin_gogek_top.jsp" %>
	<h1 style="font-family:'Nirmala UI';" align="center">Admin Login</h1>
	<form action="jikwon_login" id="jikwon_login" method="post">
	<table style="margin: 0 auto;width:470px;text-align:center" class="duoxi">
	<tr><hr style="width:470px;"></tr>
	<tr>
			<td style="text-align:center;display">
				<label style="display:block;line-height:40px;width:120px; height:40px;margin-top:20px; font-size:15px;">
					<b>아이디</b>
				</label>
			</td>
			<td>
				<input style="margin-top:20px;width:340px; height:30px;" type="text" name="jikwon_id" >
			</td>
	</tr>
	<tr>
			<td style="text-align:center;">
				<label style="display:block;line-height:40px;width:120px; height:40px; font-size:15px;">
					<b>비밀번호</b>
				</label>
			</td>
			<td>
				<input style="width:340px; height:30px;" type="password" name="jikwon_password">
			</td>
	</tr>
	<tr>
			<td colspan=2>
					<input type="button" value="로그인" id="btnLogin"
						style="font-size:11pt;font-family:'Nirmala UI';background-color:BLACK;color:white;width:230px;float:left;height:50px;margin-top:20px;" >
					<input type="button" value="이전으로" id="btnBack"
						style="font-size:11pt;font-family:'Nirmala UI';background-color:BLACK;color:white;width:230px;float:right;height:50px;margin-top:20px;" >
			</td>
	</tr>
	</table>
	</form>
	<br><br><br><br>
	<%@ include file="../../bottom.jsp" %>
</body>
</html>