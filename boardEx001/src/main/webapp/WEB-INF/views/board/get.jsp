<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="update" method="post">
		no : <input type="text" name="bno" value="${board.bno }" readonly/><br />
		writer : <input type="text" name="writer" value="${board.writer }"/><br />
		title : <input type="text" name="title" value="${board.title }"/><br />	
		content : <input type="text" name="content" value="${board.content }"/><br />
		작성일 : ${board.regdate }<br />
		수정일 : ${board.updatedate }<br />
		<input type="submit" value="수정" />
		<input type="button" value="삭제" onclick="location.href='delete?bno=${board.bno}'" />
		<input type="reset" value="취소" />
	</form>
</body>
</html>