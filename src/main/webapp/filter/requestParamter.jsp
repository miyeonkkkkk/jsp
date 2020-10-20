<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// ParamterMap객체에 추가하거나 변경이 불가능하다.
		Map<String, String[]> map = request.getParameterMap();
		map.put("newParameter", new String[]{"sally"});
		
		out.print(request.getParameter("newParamter"));
	%>
</body>
</html>