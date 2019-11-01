<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="/WEB-INF/views/common/header.jspf" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
삭제하고 다시 만드는 게시판<br>

<%
if(user==null){
%>

<a href="/views/user/login">로그인</a>
<a href="/views/user/signup">회원가입</a>

<%
}else{
%>
<a href="/views/board/list">게시판가기</a>

<%
}
%>
</body>
</html>