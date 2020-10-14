<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/layout/commonLib.jsp" %>
</head>
<body>
<%@ include file="/layout/header.jsp" %>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-3 col-md-2 sidebar">
			<%@ include file="/layout/left.jsp" %>
		</div>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="row">
				<div class="col-sm-8 blog-main">
					<h2 class="sub-header">JOBS</h2>
					<div class="table-responsive">
						<table class="table table-striped">
							<tr>
								<th>직업 아이디</th>
								<th>직업 이름</th>
							</tr>
							<c:forEach items="${jobsList}" var="job">
								<tr>
									<td>${job.job_id}</td>
									<td>${job.job_title}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
	
					<a class="btn btn-default pull-right">직업 등록</a>
			
					<div class="text-center">
						<ul class="pagination">
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>