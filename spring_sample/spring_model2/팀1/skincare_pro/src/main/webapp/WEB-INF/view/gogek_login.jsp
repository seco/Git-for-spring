<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style type="text/css">
/* .duoxi tr td:nth-child(1){
float:center;
} */
.duoxi tr td:nth-child(2){
float:right;
}
</style>
<script type="text/javascript">
window.onload = function(){
	document.getElementById("btnLogin").addEventListener("click", funcLogin, false);
	document.getElementById("btnNewMember").addEventListener("click", funcNew, false);
}

function funcLogin() {
	//alert(gogek_login.gogek_id.value);
	if(gogek_login.gogek_id.value === "" || gogek_login.gogek_password.value === ""){
		alert("아이디 또는 비밀번호를 입력하세요");
	}else{
		gogek_login.submit();
	}
}
function funcNew() {
	// alert("b");
	location.href = "join_membership";
}
</script>
</head>
<body>
<%@ include file="../../skin_gogek_top.jsp" %>
	<h1 style="font-family:'Nirmala UI';" align="center">Login</h1>
	<form action="gogek_login" method="post" id="gogek_login">
	<table style="margin: 0 auto;width:470px;text-align:center" class="duoxi">
	<tr><hr style="width:470px;"></tr>
	<tr>
			<td style="text-align:center;display">
				<label style="display:block;line-height:40px;width:120px; height:40px;margin-top:20px; font-size:15px;">
					<b>아이디</b>
				</label>
			</td>
			<td>
				<input style="margin-top:20px;width:340px; height:30px;" type="text" name="gogek_id" id="gogek_id">
			</td>
	</tr>
	<tr>
			<td style="text-align:center;">
				<label style="display:block;line-height:40px;width:120px; height:40px; font-size:15px;">
					<b>비밀번호</b>
				</label>
			</td>
			<td>
				<input style="width:340px; height:30px;" type="password" name="gogek_password">
			</td>
	</tr>
	<tr>
			<td colspan=2>
					<input type="button" value="로그인" id="btnLogin"
						style="font-size:11pt;font-family:'Nirmala UI';background-color:BLACK;color:white;width:230px;float:left;height:50px;margin-top:20px;" >
					<input type="button" value="회원가입" id="btnNewMember"
						style="font-size:11pt;font-family:'Nirmala UI';background-color:BLACK;color:white;width:230px;float:right;height:50px;margin-top:20px;" >
			</td>
		</tr>
	</table>
	</form>
	<br><br><br><br><br><br><br><br>
	<%@ include file="../../bottom.jsp" %>
</body>
</html>