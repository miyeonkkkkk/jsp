<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- session에 저장된 sumResult 값 출력 -->
	sumResult :	<%=session.getAttribute("sumResult") %>
	
</body>
</html>