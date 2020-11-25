<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- 시험 문제 리스트 -->
<c:forEach items="${examList }" var="exam" varStatus="status">
	<tr data-exam_id='${exam.exam_id }'>
		<!-- 시험 문제를 볼때 -->
		<td>${status.count }</td>
		<td>${exam.nm }</td>
		<td><fmt:formatDate value="${exam.date }" pattern="yyyy-MM-dd" /></td>
		<td>${exam.state }</td>
	</tr>
</c:forEach>

fin
<!-- 페이징 처리 -->
<!-- 첫페이지가 아닐때 -->
<c:if test="${page ne startpage }">
	<li>
		<a href="javascript:selectAllExam(${exam_state },${cur_id },${startpage});">
			<img class="page" alt="" src="${cp }/img/startpage.png">
		</a>
	</li>
	<li>
		<a href="javascript:selectAllExam(${exam_state },${cur_id },${page-1});">
			<img class="pages" alt="" src="${cp }/img/leftpage.png">
		</a>
	</li>
</c:if>

<c:forEach begin="1" end="${pages }" var="i">
	<!-- 현재 있는 페이지와 구분 -->
	<c:choose>
		<c:when test="${i == page }">
			<!-- 보고 있는 페이지와 현재 선택된 페이지가 같을 때 -->
			<li class="active"><span>${i }</span></li>
		</c:when>
		<c:otherwise>
			<li>
				<a href="javascript:selectAllExam(${exam_state },${cur_id },${i});">${i}</a>
			</li>
		</c:otherwise>
	</c:choose>
</c:forEach>

<!-- 마지막페이지가 아닐때 -->
<c:if test="${page ne endpage }">
	<li>
		<a href="javascript:selectAllExam(${exam_state },${cur_id },${page+1});">
			<img class="pages" alt="" src="${cp }/img/rightpage.png">
		</a>
	</li>
	<li>
		<a href="javascript:selectAllExam(${exam_state },${cur_id },${endpage});">
			<img class="page" alt="" src="${cp }/img/endpage.png">
		</a>
	</li>
</c:if>
