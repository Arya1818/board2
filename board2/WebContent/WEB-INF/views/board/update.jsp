<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/header.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/board/update" >
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input type="text" name="bi_title" value="${board.biTitle}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="bi_content">${board.biContent}</textarea></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><%=user.get("uiId")%></td>
			</tr>
				<th colspan="2"><button>수정하기</button></th>
			</tr>
		</table>
		<input type="hidden" name="bi_num" value="${board.biNum }">
	</form>
</body>
</html>