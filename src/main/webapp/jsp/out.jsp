<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<td>이름</td>
	</tr>
	<% List<String> rangers = (List<String>)request.getAttribute("rangers"); 
	   if(rangers == null || rangers.size() == 0){
		   out.write("<tr><td>이름이 없습니다.</td></tr>");
	   }else{
		   for(String name : rangers){
			   out.write("<tr>");
			   out.write("	<td>");
			   out.write(name);
			   out.write("	</td>");
			   out.write("</tr>");
		   }
	   }
	%>
</table>
</body>
</html>