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
		<%
			// request와 response 를 같이 넘겨주기 때문에 파라미터 값을 가져간다.
			request.getRequestDispatcher("/include/header.jsp").include(request,response);
		%>
	</h1>
	dynamicContent.jsp<br>
	param : <%=request.getParameter("param") %>
</body>
</html>