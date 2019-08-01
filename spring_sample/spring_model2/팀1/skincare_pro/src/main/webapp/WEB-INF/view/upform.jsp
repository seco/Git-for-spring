<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정 페이지</title>
<style type="text/css">
.duoxi tr td:nth-child(2){
float:right;
}
</style>
</head>
<body>
<%@ include file="../../skin_jikwon_top_ver.jsp" %>
	<br>
	<h1 style="font-family:'Nirmala UI';" align="center">상품 수정</h1>
	<form action="skinsang_update" method="post">
		<table style="margin: 0 auto;width:470px;text-align:center" class="duoxi">
		<tr><hr style="width:470px;"></tr>
		<tr>
		<td style="text-align:center;display">
				<label style="display:block;line-height:40px;width:120px; height:40px;margin-top:20px; font-size:15px;">
					<b>상품 번호</b>
				</label>
			</td>
			<td>
				<input disabled="disabled" name="sang_no" value="${data.sang_no}" style="font-size:15px;text-align:center;margin-top:20px;width:340px; height:30px;">
			</td>
		</tr>
			<input type="hidden" name="sang_no" value="${data.sang_no}">
		<tr>
		<td style="text-align:center;display">
				<label style="display:block;line-height:40px;width:120px; height:40px;margin-top:20px; font-size:15px;">
					<b>브랜드명</b>
				</label>
			</td>
			<td>
				<input name="sang_Bname" value="${data.sang_Bname}" style="font-size:15px;text-align:center;margin-top:20px;width:340px; height:30px;">
			</td>
		</tr>
		<tr>
		<td style="text-align:center;display">
				<label style="display:block;line-height:40px;width:120px; height:40px;margin-top:20px; font-size:15px;">
					<b>상품명</b>
				</label>
			</td>
			<td>
				<input name="sang_Pname" value="${data.sang_Pname}" style="font-size:15px;text-align:center;margin-top:20px;width:340px; height:30px;">
			</td>
		</tr>
		<tr>
		<td style="text-align:center;display">
				<label style="display:block;line-height:40px;width:120px; height:40px;margin-top:20px; font-size:15px;">
					<b>가격</b>
				</label>
			</td>
			<td>
				<input name="sang_price" value="${data.sang_price}" style="font-size:15px;text-align:center;margin-top:20px;width:340px; height:30px;">
			</td>
		</tr>
		<tr>
		<td style="text-align:center;display">
				<label style="display:block;line-height:40px;width:120px; height:40px;margin-top:20px; font-size:15px;">
					<b>수량</b>
				</label>
			</td>
			<td>
				<input name="sang_su" value="${data.sang_su}" style="font-size:15px;text-align:center;margin-top:20px;width:340px; height:30px;">
			</td>
		</tr>
		<tr>
		<td style="text-align:center;display">
				<label style="display:block;line-height:40px;width:120px; height:40px;margin-top:20px; font-size:15px;">
					<b>상세설명</b>
				</label>
			</td>
			<td>
				<input name="sang_detail" value="${data.sang_detail}" style="font-size:15px;text-align:center;margin-top:20px;width:340px; height:30px;">
			</td>
		</tr>
		<tr>
			<td colspan=2>
					<input type="submit" value="수정" id="btnLogin"
						style="font-size:11pt;font-family:'Nirmala UI';background-color:BLACK;color:white;width:470px;float:left;height:50px;margin-top:20px;" >
			</td>
	</tr>
	</table>
	</form>
	<br>	<br>	<br>	<br>	<br>	<br>
	<%@ include file="../../bottom.jsp" %>
</body>
</html>