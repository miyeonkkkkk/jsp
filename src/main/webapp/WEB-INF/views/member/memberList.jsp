<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberList</title>
<%@include file="/WEB-INF/views/layout/commonLib.jsp"%>
<script>
	$(document).ready(function(){
	
		$('#memberList tr').on('click', function(){
			// 자바스크립트에서 this는 4가지를 의미한다. - 실행 위치에 따라서 의미가 달라진다.
			// 여기서 this는 클릭된 tr을 가르킨다.
// 			console.log("memberList tr click");
			
			// data-userid : data("속성명")
			var userid = $(this).data("userid");
			console.log("userid : " + userid);

// 			document.location = "/사용자상세조회서블릿?userid=" + userid;
			document.location = "/member/getMember?userid=" + userid;
			
		});
	});
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/layout/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/WEB-INF/views/layout/left.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>사용자 아이디</th>
									<th>사용자 이름</th>
									<th>사용자 별명</th>
									<th>등록일시</th>
								</tr>
								<tbody id="memberList"> <!-- 헤드 부분과 구별하기 위해서 많이 사용한다. -->
									<c:forEach items="${memberList}" var="member">
										<tr data-userid="${member.userid}">
											<td>${member.userid}</td>
											<td>${member.usernm}</td>
											<td>${member.alias}</td>
											<!-- format : yyyy-MM-dd -->
											<%-- 									<td>${member.reg_dt}</td> --%>
											<td><fmt:formatDate value="${member.reg_dt}"
													pattern="yyyy-MM-dd" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

						<a class="btn btn-default pull-right" href="${cp }/member/memberRegist">사용자 등록</a>

						<%-- pages : ${pages} --%>
						<!-- 현재 있는 페이지 번호 출력 -->
						<%-- page : ${page} --%>
						<div class="text-center">
							<ul class="pagination">
								<c:forEach begin="1" end="${pages }" var="i">
									<!-- 현재 있는 페이지와 구분 -->
									<c:choose>
										<c:when test="${i == page }">
											<!-- 보고 있는 페이지와 현재 선택된 페이지가 같을 때 -->
											<li class="active"><span>${i }</span></li>
										</c:when>
										<c:otherwise>
											<li><a
												href="${cp }/member/memberListPage?page=${i}">${i}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>