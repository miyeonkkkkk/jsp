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
	<%
		// <c:set var="price" value="100000"/> 아래와 동일
		request.setAttribute("price", 100000);
	%>
	<!-- 국가 코드를 함께 넣어줘야 통화표시가 깨지지 않는다. -->
	<%-- <fmt:setLocale value="en_us"/> --%>
	<fmt:setLocale value="de_DE"/>
	
	<!-- 숫자 ==> 문자로 변환 -->
	price : ${price }<br>
	<!-- type : number(세자리씩 끊어서 문자열로 변환) , currency(통화), percent(1이 100%) -->
	price - type-number : <fmt:formatNumber value="${price }" type="number"/> <br>
	price - type-percent : <fmt:formatNumber value="1" type="percent"/> <br>
	price - type-currency : <fmt:formatNumber value="${price }" type="currency"/> <br>
	price - pattern : <fmt:formatNumber value="${price }" pattern="00,0000.00"/>
	
	<hr>
	<!-- 문자 ==> 숫자로 변환 (파라미터 처리) -->
	parseNumber : <fmt:parseNumber value="100.000,52"/> <br>
	parseNumber : <fmt:parseNumber value="100.000,52" var="num"/> num = ${num } <br>
	
	
	
	
</body>
</html>