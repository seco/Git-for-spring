<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 등록 페이지</title>
</head>
<body>
	<%@ include file="../../skin_jikwon_top_ver.jsp" %>
	<br>
	<h1 style="font-family:'Nirmala UI';" align="center">직원 등록</h1>
	<sform:form enctype="multipart/form-data" modelAttribute="uploadFile">
		<table style="margin: 0 auto;width:470px;text-align:center" class="duoxi">
		<tr><hr style="width:470px;"></tr>
		<tr>
		<td style="text-align:center;">
				<label style="display:block;line-height:40px;width:120px; height:40px;margin-top:20px; font-size:15px;">
					<b>이름</b>
				</label>
			</td>
			<td>
				<input name="emp_name" style="font-size:15px;text-align:center;margin-top:20px;width:340px; height:30px;">
			</td>
		</tr>
		<tr>
		<td style="text-align:center;">
				<label style="display:block;line-height:40px;width:120px; height:40px;margin-top:20px; font-size:15px;">
					<b>분야</b>
				</label>
			</td>
			<td>
				<input name="emp_job" style="font-size:15px;text-align:center;margin-top:20px;width:340px; height:30px;">
			</td>
		</tr>
		<tr>
		<td style="text-align:center;">
				<label style="display:block;line-height:40px;width:120px; height:40px;margin-top:20px; font-size:15px;">
					<b>파일 업로드</b>
				</label>
			</td>
			<td>
				<input type="file" name="file" style="margin-top:20px;margin-top: 20px;margin-left: 90px;">
			</td>
		</tr>
		<sform:errors path="file" cssStyle="color:red" />
		<tr>
		<td colspan=2>
			<input type="submit" value="추가" style="font-size:11pt;font-family:'Nirmala UI';background-color:BLACK;color:white;width:470px;float:left;height:50px;margin-top:20px;">
		</td>
	</tr>
	</table>
	</sform:form>
	<br><br><br><br>
	<%@ include file="../../bottom.jsp" %>
</body>
</html>