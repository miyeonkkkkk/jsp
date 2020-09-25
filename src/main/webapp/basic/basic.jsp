<!-- page directive(지시자) : jsp는 자바이외에 언어로 작성할 수 없다. -->
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%	// 스크립틀릿 : 자바 로직을 작성하는 공간
		// 특정 메서드 안에서 구현하는 자바로직
		Date date = new Date(); // 지역변수
	%>
	
	<!-- expression : 화면에 출력을 해준다. -->
	<!--  => write.print() 같은 기능 -->
	현재 시간 : <%=date%>
</body>
</html>