<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% Date now = new Date();
		request.setAttribute("now", now);
	%>
	<!-- us : mm-dd-yyyy
		 ko : yyy.mm.dd  ==> 2020-10-19, 2020/10/19 -->
<%-- 	<fmt:setLocale value="en_us"/> --%>
	now : ${now } <br>
	now - formatDate : <fmt:formatDate value="${now }"/> <br>
	<!-- 오라클에서는 영문 대소문자를 구분하지 않지만 자바에서는 대소문자를 구분하여 사용한다. -->
	now - formatDate - pattern : <fmt:formatDate value="${now }" pattern="YYYY-MM-dd"/> <br>
	
	<!-- 문자 ==> 날짜로 변환 
		"2020-10-19 10:15" 문자열을 날짜 타입으로 변경
	-->
	<% request.setAttribute("nowStr", "2020-10-19 10:15"); %>
	<fmt:parseDate value="${nowStr }" pattern="yyyy-MM-dd HH:mm" /><br>
	
	
	
	
	
	
	
	
</body>
</html>