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
<h2>!!!게시판 첫 화면!!!</h2><br>

<%
if(user==null){
%>

<a href="/views/user/login">로그인</a>
<a href="/views/user/signup">회원가입</a>


<%
}else{
%>
<a href="/board/list">게시판가기</a>

<%
}
%>
</body>
</html>