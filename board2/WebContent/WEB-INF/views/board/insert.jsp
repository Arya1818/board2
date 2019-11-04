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
	<form method="post" action="/board/insert" onsubmit="return checkForm()">
		<table border="1" >
			<tr>
				<td>작성자</td>
				<td><%=user.get("uiId") %></td>
			<tr>
				<td>제목</td>
				<td><input type="text" name="biTitle" id="biTitle"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="biContent"></textarea></td>
			</tr>
			<tr>
				<th colspan="2"><button>글저장</button></th>
			</tr>
		</table>
	</form>
<script>
function checkForm(){
	var viTitle = document.getElementById('biTitle').value;
	var biContent = document.getElementById('biContent').value;
	if(biTitle==''||biContent==''){
		alert('제목과 내용을 입력해주세요');
		return false;
	}else{
		alert('등록완료');
	}
	return true;
}
</script>	
</body>
</html>