<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload = function(){
	document.getElementById("btnList").onclick = function(){
		location.href="list";
	};
	
	document.getElementById("btnUpdate").onclick = function(){
		if(confirm("정말 수정할까요?")){
			//입력자료 검사 작업 필요...
			frm.action="update";  //post
			frm.submit();
		}
	};
	
	document.getElementById("btnDelete").onclick = function(){
		if(confirm("정말 삭제할까요?")){
			//frm.method="get";
			//frm.action="delete?num=" + frm.num.value; //get
			frm.action="delete";  //post
			frm.submit();
		}
	};
};
</script>
</head>
<body>
** 글 상세 보기 **<br/>
<form name="frm" method="post">
글번호 : ${board.num}
<br/>
<input type="hidden" name="num" value="${board.num}">
작성자 : <input type="text" name="author" value="${board.author}">
<br/>
글제목 : <input type="text" name="title" value="${board.title}">
<br/>
글내용 : <textarea rows="5" cols="20" name="content">${board.content}</textarea>
<br/>
작성일 : ${board.bwrite}<br/>
조회수 : ${board.readcnt}<br/>
<input type="button" value="목록" id="btnList" />
<input type="button" value="수정" id="btnUpdate" />
<input type="button" value="삭제" id="btnDelete" />
</form>
</body>
</html>