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

<c:set var="str" value="abc"/>
<c:if test="${str eq 'abc'}"> 
	str은 abc네
	</c:if>
<c:if test="${str ne 'abc'}">
	str은 abc가 아니네
	</c:if>
	
</body>
</html>