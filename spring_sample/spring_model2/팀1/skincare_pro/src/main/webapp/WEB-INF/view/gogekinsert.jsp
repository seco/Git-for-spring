<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
$(document).ready(function(){
	$("btnId").unbind("click").click(function(e){
		e.preventDefault();
		gogek_IDCheck();
	});
	
	$("#btnSubmit").click(function(){
		alert("a");
	});
	
});

function gogek_IDCheck(){
	var gogekId = $("#gogek_id").val();
	var gogekData = {"gogek_id": gogekId} // json 데이터타입으로 파라미터를 서버로 전달하기위해 gogekData 라는 변수를 json형식으로만듬
	
	if(gogekId.length < 1){
		alert("아이디를 입력해주세요");
	}else{
		$.ajax({
			type : "POST",
			url : "gogekCheckId",
			data : gogekData,
			dataType : "json",
			error : function(error){
				alert("서버가 응답하지않습니다. \n 다시시도해주세요");
				
			},
			success : function(result){
				if(result == 0){
					$("#gogek_id").attr("disabled", true);
					alert("사용가능한 아이디입니다.");
				}else if(result == 1){
					alert("이미 존재하는 아이디입니다.");
				}
				else{
					alert("에러가 발생하였습니다.");
				}
			}
			
		});
	}
}

</script>
<title>고객회원가입</title>
</head>
<body>
<%@ include file="../../skin_gogek_top.jsp" %>
<h1 style="font-family:'Nirmala UI';" align="center">Sign Up</h1>
		<form name="regForm" method="post" action="join_membership">
			<table style="margin: 0 auto;width:470px;text-align:center" class="duoxi">
			<tr><hr style="width:470px;"></tr>
			<tr>
			<td style="text-align:center;display">
				<label style="display:block;line-height:40px;width:120px; height:40px;margin-top:20px; font-size:15px;">
					<b>아이디</b>
				</label>
			</td>
			<td>
				<input style="margin-top:20px;width:340px; height:30px;" type="text" name="gogek_id" >
			</td>
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
			<td style="text-align:center;">
				<label style="display:block;line-height:40px;width:120px; height:40px; font-size:15px;">
					<b>이름</b>
				</label>
			</td>
			<td>
				<input style="width:340px; height:30px;" type="text" name="gogek_name">
			</td>
	</tr>
	<tr>
			<td style="text-align:center;">
				<label style="display:block;line-height:40px;width:120px; height:40px; font-size:15px;">
					<b>전화번호</b>
				</label>
			</td>
			<td>
				<input style="width:340px; height:30px;" type="text" name="gogek_phone">
			</td>
	</tr>
					
	
	<tr>
			<td colspan=2>
					<input type="submit" value="등록하기" id="btnSubmit"
						style="font-size:11pt;font-family:'Nirmala UI';background-color:BLACK;color:white;width:470px;float:left;height:50px;margin-top:20px;" >
			</td>
	</tr>
			</table>
		</form>
	</td>
</tr>
</table>
<br><br><br><br>
<%@ include file="../../bottom.jsp" %>
</body>
</html>