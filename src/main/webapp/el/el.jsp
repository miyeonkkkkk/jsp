<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/el" method="post">
	
		<%	
			String scope = request.getParameter("scope");
			String requestParam = "";
			String sessionParam = "";
			String applicationParam = "";
			
			if(scope == null || scope.equals("requestValue"))
	            requestParam = "checked";
	        else if(scope.equals("sessionValue"))
	            sessionParam = "checked";
	        else if(scope.equals("applicationValue"))
	            applicationParam = "checked";
			
		%>
		
		request (request)     : <input type="radio" name="scope" value="requestValue" <%=requestParam %>/> <br>
		session (request, session)   : <input type="radio" name="scope" value="sessionValue" <%=sessionParam %>/> <br>
		application (request, session, application) : <input type="radio" name="scope" value="applicationValue" <%=applicationParam %>/> <br>
		<button type="submit">전송</button>
		
	</form>
	<br>
	attr : ${attr} (page -> request -> session -> application) <br>
	requestScope : ${requestScope.attr} <br>
	sessionScope : ${sessionScope.attr} <br>
	applicationScope : ${applicationScope.attr} <br>
	<hr>
	scope parameter : <%=request.getParameter("scope") %> <br>
	scope parameter : ${param.scope} <br>
	<hr>
	cookie : <%=request.getCookies() %> <br>
	cookie : ${cookie.USERID.value} <br>
	<hr>
	map.key <br>
	rangers.brown : ${rangers.brown} <br>
	rangers.sally : ${rangers.sally} <br>
	<hr>
	list[index] 또는 list[index].속성(필드)<br>
	rangersList[0].userid : ${rangersList[0].userid}<br>
	rangersList[1] : ${rangersList[1]}<br>
	
	
</body>
</html>