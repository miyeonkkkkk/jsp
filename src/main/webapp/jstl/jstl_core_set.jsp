<%@page import="kr.or.ddit.member.model.MemberVO"%>
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
	<h3>속성 설정 전</h3>
	userId : ${userId}
	
	<h3>set 태그를 통해 속성을 저장</h3> <!-- 가끔 사용한다. -->
	<c:set var="userId" value="brown"></c:set>
	<%-- 태그안에 들어가는 내용이 없기 때문에 이런식으로 닫아주어도 된다.
	     <c:set var="userId" value="brown"/> --%>
	     
	<h3>속성 설정 후</h3>
	userId : ${userId}<br>
	
	<hr>
	<h3>객체의 필드 설정도 가능</h3>
	<%
		// memberVo가 서블릿을 통해 request객체 설정되었다고 가정
		// 생성하고 나서 값을 설정하는 부분은 없음
		MemberVO memberVo = new MemberVO();
		request.setAttribute("memberVo", memberVo);
		//request.removeAttribute("memberVo");
	%>
	memberVo : ${memberVo }<br>
	
	<h3>set태그를 통해 scope객체에 저장된 vo 객체의 필드를 수정(setter)</h3>
	<c:set target="${memberVo}" property="userid" value="sally"/>
	
	memberVo : ${memberVo }
	
	<hr>
	<h3>remove태그를 통해 scope 객체에서 속성 제거</h3>
	<c:remove var="memberVo"/>
	memberVo : ${memberVo }
	
</body>
</html>