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
				<td>${board.title }</td>
				<td>${board.writer }</td>
				<td>${board.content }</td>
				<td><fmt:formatDate value="${board.regdate }"/></td>
				<td><fmt:formatDate value="${board.updatedate }"/></td>	
				<td><input type="button" id="btnUpdate" value="${board.bno }"/>수정</td>	
				<td><input type="button" id="btnDelete" />삭제</td>	
			</tr>
		</c:forEach>
	</table>
	<a href="/board/writeForm"><button type="button">글쓰기</button></a>
	<a href="/board/writeForm"><input type="button" value="글쓰기"/></a>
	<!-- <button type="button">글쓰기</button> -->
</body>

<script>
	function btnClick_delete {
		$.ajax({
			type:"post",
			url:"overappedNname.do",
			data:{"nickname":$("#nickname").val()},
			dataType:"text",
			success:function(data,textStatus){
				if(data == '0'){
					$("#msg2").html("사용 가능");
					checkNname = 1;
				}
				else if(data == '1'){
					$("#msg2").html("사용 불가능");
					checkNname = 0;
				}
			}, error:function(data,textStatus){
				alert("서버 에러");
			}
		});
	}
</script>

</html>