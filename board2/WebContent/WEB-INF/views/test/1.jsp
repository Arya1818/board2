<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
   <c:set var="test" value="룰루랄라"/> <!--scope="page"가 뒤에 디폴트로되어있음 --> 
   ${test}<br>
<%
/* request.setAttribute("req","난 응답이 끝나면 사라짐");
session.setAttribute("ses","난 세션이 끊어질 때까지 유지됨");
application.setAttribute("app","난 서버 끝날때까지 유지됨");
RequestDispatcher rd = request.getRequestDispatcher("/views/test/2"); //여기로 가라고 forwarding시킴 
rd.forward(request, response); */

pageContext.setAttribute("msg","난 페이지"); //키값이 똑같아도 각각 저장됨 , *보낼수가 없고 여기서만 쓸수있음 
request.setAttribute("msg","난 리퀘스트"); //*forward할 때 같이 감 
session.setAttribute("msg","난 세션");
application.setAttribute("msg","난 어플리케이션");

RequestDispatcher rd = request.getRequestDispatcher("/views/test/2"); //여기로 가라고 forwarding시킴 
rd.forward(request, response); 
%>
 ${msg} <!-- 같은 키값일 때 작은것부터 가져옴, 간단! -->
 
 
 <!-- 리퀘스트는 응답이 끝날때 소멸됨 -->