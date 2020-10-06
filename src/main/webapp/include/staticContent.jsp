<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
	<!-- html태그와 같은 것은 중복 사용하면 안된다. -->
	<!-- 정적 include는 하나의 소스 코드인것처럼 취급된다. 그래서 파라미터를 받을 수 있다.
	 -->
		<%@include file="/include/header.jsp"%>
	</h1>
	staticContent.jsp <br>
	param : <%=request.getParameter("param") %>
</body>
</html>