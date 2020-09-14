<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>bno</th>
			<th>title</th>
			<th>writer</th>
			<th>content</th>
			<th>regdate</th>
			<th>updatedate</th>
		</tr>
		<c:forEach items="${list }" var="board">
			<tr>
				<td>${board.bno }</td>
				<td><a href="/board/get?bno=${board.bno }">${board.title }</a></td>
				<td>${board.writer }</td>
				<td>${board.content }</td>
				<td><fmt:formatDate value="${board.regdate }"/></td>
				<td><fmt:formatDate value="${board.updatedate }"/></td>	
				<td><a href="/board/update?bno=${board.bno }"><input type="button" value="수정"/></a></td>	
				<td><a href="/board/delete?bno=${board.bno }"><input type="button" value="삭제"/></a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="/board/writeForm"><button type="button">글쓰기</button></a>
	<a href="/board/writeForm"><input type="button" value="글쓰기"/></a>
	<!-- <button type="button">글쓰기</button> -->
</body>

<script>
	
</script>

</html>