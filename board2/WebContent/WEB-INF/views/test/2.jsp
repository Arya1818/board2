<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- req : <%=request.getAttribute("req") %> <br>
ses : <%=session.getAttribute("ses") %> <br> <!-- 브라우저를 끊으면 말소, 로그인  -->
app : <%=application.getAttribute("app") %> <!-- 서버가 꺼지면 어플리케이션도 말소 --> --%>

 ${msg} <!-- 세션이 나오는 이유는 1을 갔다왔기 때문에 타임아웃이 남아있어서 session이나옴!-->
</body>
</html>