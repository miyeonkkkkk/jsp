<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("name", "brown");
	%>
	<%-- <c:if test="${name } == 'sally' "> "" 안에 공백이 없고 EL안에 조건을 기재해야 한다. --%> 
	<c:if test="${name == 'sally'}">
		sally
	</c:if>
	
	<c:if test="${name == 'brown' }">
		brown
	</c:if>
	<br>
	jstl_core_if.jsp
	
	
</body>
</html>