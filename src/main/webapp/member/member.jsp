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

<title>Jsp</title>

<%@include file="/layout/commonLib.jsp"%>
<script>
$(document).ready(function(){

	$('#updateBtn').on('click', function(){
// 		userid = $('#userid').text();
// 		console.log(userid);
		document.location = "/memberUpdate?userid=${mv.userid }";
	});

	$('#profileDownBtn').on('click', function(){
		document.location = "/profileDownload?userid=${mv.userid }";
	});
	
})
</script>

<style>
#profile{
	width: 300px;
	height: 300px;
}
</style>
</head>

<body>
	<%@ include file="/layout/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/layout/left.jsp"%>
			</div>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form class="form-horizontal" role="form">
<!-- 					<div class="form-group"> -->
<!-- 						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label> -->
<!-- 						<div class="col-sm-10"> -->
<!-- 							<input type="text" class="form-control" id="userId" name="userId" -->
<!-- 								placeholder="사용자 아이디"> -->
<!-- 						</div> -->
<!-- 					</div> -->
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
						<!-- webapp 폴더 밑에 이미지를 두었을 때 사용 -> 배포시 폴더 삭제 과정이 있으므로 사용 불가 -->
<%-- 							<img alt="이미지 없구용" src="${cp }/profile/${mv.filename}"/> --%>
							
							<img id="profile" alt="" src="${cp }/profileImg?userid=${mv.userid }"/><br><br>
							<!-- 여러명의 회원중에서 선택할 경우에 아래의 코드 사용 -->
<%-- 							<button id="profileDownBtn" data-userid="${mv.userid }" type="button" class="btn btn-default">다운로드 : ${mv.realFilename }</button> --%>
							
							<!-- 한명의 상세정보이기 때문에 아래 코드 사용  -->
							<button id="profileDownBtn" type="button" class="btn btn-default">다운로드 : ${mv.realFilename }</button>
							
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<label id="userid" class="control-label">${mv.userid }</label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<label class="control-label">${mv.usernm }</label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<label class="control-label">${mv.alias }</label>
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<label class="control-label">**********</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="addr1" class="col-sm-2 control-label">기본 주소</label>
						<div class="col-sm-10">
							<label class="control-label">${mv.addr1 }</label>
						</div>
					</div>
					<div class="form-group">
						<label for="addr2" class="col-sm-2 control-label">상세 주소</label>
						<div class="col-sm-10">
							<label class="control-label">${mv.addr2 }</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<label class="control-label">${mv.zipcode }</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="reg_dt" class="col-sm-2 control-label">등록일자</label>
						<div class="col-sm-10">
<%-- 							<fmt:formatDate value="${mv.reg_dt }" pattern="yyyy-mm-dd"/> --%>
							<label class="control-label"><fmt:formatDate value="${mv.reg_dt }" pattern="yyyy-MM-dd"/></label>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="updateBtn" type="button" class="btn btn-default">사용자 수정</button>
						</div>
					</div>
				</form>
			</div>
			
		</div>
	</div>
</body>
</html>
