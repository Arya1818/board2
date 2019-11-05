<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/header.jspf" %> 
<%
List<Map<String,String>> list = (List<Map<String,String>>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>작성일자</th>
	<th>작성시간</th>
</tr>
<%
for(Map<String,String> board:list) { 
%>
<tr>
	<td><%=board.get("biNum") %></td> 
	<td><%=board.get("biTitle") %></td>
	<td><%=board.get("uiNum") %></td>
	<td><%=board.get("credat") %></td>
	<td><%=board.get("cretim") %></td>
</tr>
<%
}
%>
</table>
	<a href="/views/board/insert">글쓰기</a>
</body>
</html>