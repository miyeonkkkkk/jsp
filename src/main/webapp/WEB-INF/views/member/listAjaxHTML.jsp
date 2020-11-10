<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:forEach items="${memberList }" var="member">
	<tr data-userid="${member.userid }">
		<td>${member.userid }</td>
		<td>${member.usernm }</td>
		<td>${member.alias }</td>
		<!-- format : yyyy-MM-dd -->
		<%-- 		<td><fmt:formatDate value="${member.reg_dt }" pattern="yyyy-MM-dd" /></td> --%>
		<td>${member.reg_dt }</td>
	</tr>
</c:forEach>

$SEPERATOR$
<c:forEach begin="1" end="${pages }" var="i">
	<c:choose>
		<c:when test="${i== pageVo.page}">
			<li class="active"><span>${i }</span></li>
		</c:when>
		<c:otherwise>
			<li><a
				href="javascript:memberListAjaxHTML(${i});">${i }</a></li>
		</c:otherwise>
	</c:choose>
</c:forEach>





</html>