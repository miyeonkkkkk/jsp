<%@page import="java.util.Enumeration"%>
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
	<% request.setCharacterEncoding("utf-8"); %>
	<!-- <h1>GET</h1> -->
	<h1><%=request.getMethod()%></h1>
	<p>user_id 파라미터는 id1, id2 두 개를 보내지만 getParameter를 호출하면 첫번째 파라미터 값을 반환한다.</p>
	<p>request.getParameter("user_id") : <%=request.getParameter("user_id")%></p>
	<hr>
	
	<p>String[]을 반환한다.</p>
	<%
		String[] userIds = request.getParameterValues("user_id");
	
		// for(String userId : userIds) : 향상된 for문 이용
		
		for(int i=0; i<userIds.length; i++){
	%>
		<p>request.getParameterValues("user_id<%=(i+1)%>") : <%=userIds[i]%></p>
	<%		
		}
	%>
	
	<hr>
	<p>parameterMap : Map<String, String[]> </p>
	<p>request.getParameterMap() : <%=request.getParameterMap()%></p>

	<hr>
	<p>요청에 존재하는 파라미터 이름 출력하기</p>
	<% 
		Enumeration<String> param = request.getParameterNames();
		while(param.hasMoreElements()){
	%>
			<p>파라미터 이름 : <%=param.nextElement()%></p>
	<%		
		}
	%>
	
	
</body>
</html>