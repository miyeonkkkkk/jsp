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

<%@include file="/WEB-INF/views/layout/commonLib.jsp"%>

<!-- 주소 검색 api -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
$(document).ready(function(){
	$('#zipcodeBtn').on('click', function(){
		new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
				console.log(data);
				$('#addr1').val(data.roadAddress); // 주소
				$('#zipcode').val(data.zonecode); // 우편번호
	        }
	    }).open();
	});

	$('#regBtn').on('click', function(){
		// $('#frm').serialize() 로 보내질 데이터 확인
		$('#frm').submit();
	});

// 	initData();

	// 사진 파일을 변경 했을 경우에 보여주는 이미지도 바뀐다.
// 	$('#imgInput').on('change', function(){
// 		filename = $(this).val();
		

// 	});
	
});



function initData(){
	$('#userid').val('kmy');
	$('#usernm').val('김미연');
	$('#alias').val('김미');
	$('#pass').val('pass1234');
	$('#addr1').val('대전 중구 중앙로 76');
	$('#addr2').val('영민빌딩 404호');
	$('#zipcode').val('34940');
}

</script>

<style>
#profile{
	width: 300px;
	height: 300px;
}
</style>

</head>

<body>
	<%@ include file="/WEB-INF/views/layout/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/WEB-INF/views/layout/left.jsp"%>
			</div>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form id="frm" class="form-horizontal" role="form" action="${cp}/member/memberUpdate" method="post" enctype="multipart/form-data">
					<!-- 파일전송은 post 방식만 가능하다. -->
					<div class="form-group">
						<!-- label에 for은 스크린리더가 읽어주는 부분이다.(시각장애인들을 위한 기능) -->
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
							<img id="profile" alt="" src="${cp }/member/profileImg?userid=${memberVo.userid }"/>
							<input type="file" name="rf"/>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userid" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userid" name="userid" placeholder="사용자 아이디" value="${memberVo.userid }" readonly/>
						</div>
					</div>

					<div class="form-group">
						<label for="usernm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="usernm" name="usernm" placeholder="사용자 이름" value="${memberVo.usernm }"/>
						</div>
					</div>
					<div class="form-group">
						<label for="alias" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="alias" name="alias" placeholder="사용자 별명" value="${memberVo.alias }"/>
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="pass" name="pass" placeholder="사용자 비밀번호" value="${memberVo.pass }" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="addr1" class="col-sm-2 control-label">기본 주소</label>
						<div class="col-sm-10">
							<!-- 사용자 입력을 막는다 => readonly 속성 추가 -->
							<input type="text" class="form-control" id="addr1" name="addr1" placeholder="사용자 기본 주소" value="${memberVo.addr1 }" readonly/>
							<button id="zipcodeBtn" type="button" class="btn btn-default">우편번호 찾기</button>
						</div>
					</div>
					<div class="form-group">
						<label for="addr2" class="col-sm-2 control-label">상세 주소</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="addr2" name="addr2" placeholder="사용자 상세 주소" value="${memberVo.addr2 }"/>
						</div>
					</div>
					<div class="form-group">
						<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="zipcode" name="zipcode" placeholder="사용자 우편번호" value="${memberVo.zipcode }" readonly/>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="regBtn" type="button" class="btn btn-default">사용자 수정</button>
						</div>
					</div>
					
				</form>
			</div>
			
		</div>
	</div>
</body>
</html>
