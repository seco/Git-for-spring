<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script>
$(document).ready(function() {
	$("#btnOk").on("click", function(){
	if(!$("input:radio[name='comment']").is(":checked") == true){	  //라디오 체크여부
		alert('칭찬 혹은 불만을 선택해주세요');
		return false;	
	}
/* 	
	if(!$("input:text[id='name']").is(":checked") == true){	  //라디오 체크여부
		alert('칭찬 혹은 불만을 선택해주세요');
		return false;	
	} */
	
	if($.trim($('#name').val()) == ''){  //이름체크여부
		   alert("이름을 입력하십시오.");
		   $('#name').focus();
		   return false;
	 }
	
	if($.trim($('#phone').val()) == ''){
		   alert("전화번호를 입력하십시오.");
		   $('#phone').focus();
		   return false;
		  }
	
	if($.trim($('#text').val()) == ''){
		   alert("내용을 입력하십시오.");
		   $('#text').focus();
		   return false;
		  }
	
	
	});
});


</script>
<title>Insert title here</title>
</head>
<body>
<%@ include file="../../skin_gogek_top_ver.jsp" %>
<form action="survey" method="post">
<br><br><br>
<div style="width: 50%; height: 60%; background-color: rgb(240,240,240); margin-left: 30%">
<br><br>
<font style="font-size: 30px; margin-left: 40%">COMMENT</font>
<br><br><br>
<div style="text-align: center;">
<input type="radio" name="comment" value="칭찬">칭찬 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="radio" name="comment" value="불만">불만 
</div>
<hr style="width: 40%">
<br>
<div style="text-align: center;">
이 름  : <input type="text" name="name" id="name"><br>
연락처 : <input type="text" name="phone" id="phone" placeholder="번호를 입력하세요 "><br><br>
</div>

<br>
<div style="text-align: center;">
<textarea rows="15" cols="65" id="text" name="text" placeholder="내용을 입력해 주세요."></textarea><br><br>
</div>
<input type="submit" style="margin-left: 30%; font-size:11pt;font-family:'Nirmala UI';background-color:BLACK;color:white;width:40%;float:left;height:50px;margin-top:20px;" value="등록하기" id="btnOk">
</div>
</form>
<br><br><br><br><br>
<%@ include file="../../bottom.jsp" %>
</body>
</html>