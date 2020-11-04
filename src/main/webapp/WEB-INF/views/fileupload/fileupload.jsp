<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<title>FileUpload</title>

<%@include file="/WEB-INF/views/layout/commonLib.jsp"%>

</head>

<body>
	<%@ include file="/WEB-INF/views/layout/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/WEB-INF/views/layout/left.jsp"%>
			</div>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form id="frm" class="form-horizontal" role="form" action="${cp }/fileupload/upload" method="post" enctype="multipart/form-data">
					<!-- client form method : post
									 encType : multipart/form-data 
						 server - servlet : @MultipartConfig
						 		- spring Framework : multipartResolver 필요 -->
					<div class="form-group">
						<label for="userid" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userid" name="userid" placeholder="사용자 아이디" value="브라운"/>
						</div>
					</div>

					<!-- 파일전송은 post 방식만 가능하다. -->
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">첨부 파일</label>
						<div class="col-sm-10">
							<input type="file" name="file" />
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="regBtn" type="submit" class="btn btn-default">파일 전송</button>
						</div>
					</div>
					
				</form>
			</div>
			
		</div>
	</div>
</body>
</html>
