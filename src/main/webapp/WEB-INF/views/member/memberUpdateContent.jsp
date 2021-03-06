<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	$(document).ready(function() {
		$("#zipcodeBtn").on('click', function() {
			new daum.Postcode({
				oncomplete : function(data) {
					console.log(data);
					$('#addr1').val(data.roadAddress);
					$('#zipcode').val(data.zonecode);
				}
			}).open();
		});
		$("#upBtn").on('click', function() {
			//client side - validation  웹브라우저에서 보는 방법으로 우회가능
			//server side - validation	때문에 두개 다 하는게 안전하다.
			//validation 로직은 일단생략
			$("#ff").submit();
		});
		// 		initData();
	});//document
	
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
title : updateContent

<form id="ff" class="form-horizontal" role="form" action="${cp }/member/memberUpdate" method="POST" enctype="multipart/form-data">

	<div class="form-group">
		<label for="realFilename" class="col-sm-2 control-label">사용자 사진</label>
		<div class="col-sm-10">
			<img id="profile" alt="" src="${cp }/member/profileImg?userid=${memberVo.userid }"/>
			<input type="file" name="rf">
		</div>
	</div>
	<div class="form-group">
		<label for="userid" class="col-sm-2 control-label">사용자 아이디</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="userid" name="userid"
				placeholder="사용자 아이디" value="${memberVo.userid }" READONLY>
		</div>
	</div>

	<div class="form-group">
		<label for="usernm" class="col-sm-2 control-label">사용자 이름</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="usernm" name="usernm"
				placeholder="사용자 이름" value="${memberVo.usernm }">
		</div>
	</div>
	<div class="form-group">
		<label for="alias" class="col-sm-2 control-label">별명</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="alias" name="alias"
				placeholder="사용자 별명" value="${memberVo.alias }">
		</div>
	</div>
	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">Password</label>
		<div class="col-sm-10">
			<input type="password" class="form-control" id="pass" name="pass"
				placeholder="사용자 비밀번호" value="${memberVo.pass }">
		</div>
	</div>

	<div class="form-group">
		<label for="addr1" class="col-sm-2 control-label">주소</label>
		<div class="col-sm-10 ">
			<input type="text" class="form-control" id="addr1" name="addr1"
				placeholder="사용자 주소" READONLY value="${memberVo.addr1 }">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button id="zipcodeBtn" type="button" class="btn btn-default ">우편번호
				찾기</button>
		</div>
	</div>
	<div class="form-group">
		<label for="addr2" class="col-sm-2 control-label">상세주소</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="addr2" name="addr2"
				placeholder="사용자 상세주소" value="${memberVo.addr2 }">
		</div>
	</div>
	<div class="form-group">
		<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="zipcode" name="zipcode"
				placeholder="사용자 우편번호" READONLY value="${memberVo.zipcode }">
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button id="upBtn" type="button" class="btn btn-default">사용자 수정</button>
		</div>
	</div>
</form>
</html>