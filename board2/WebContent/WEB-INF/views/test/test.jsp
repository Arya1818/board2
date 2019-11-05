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
	list : ${list}<br>
	<table border="1">
		<tr>
			<th>이름</th>
			<th>나이</th>
		</tr>
		<c:forEach var="tt" items="${list}">
			<tr>
				<td>${tt.name}</td>
				<td>${tt.age}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>