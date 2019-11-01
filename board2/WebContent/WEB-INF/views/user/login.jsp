<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@include file="/WEB-INF/views/common/header.jspf" %> <!-- 여기안에서 쓴 변수 재사용 가능 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/users/login">
<table border="1">
	<tr>
		<th>아이디</th>
		<td><input type="text" name="uiId" id="uiId"></td> <!-- name은 중복됨 id 는 중복x -->
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="password" name="uiPwd" id="uiPwd"></td>
	</tr>
	<tr>
		<th colspan="2"><button>로그인</button></th><!-- submit/ name이 있는 케이스만 싹 다 모아서 action링크로 고~ -->
	</tr>
</table>
</form>
</body>
</html>