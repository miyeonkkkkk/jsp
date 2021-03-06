<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- bootstrap 사용 설정 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- js 추가 -->
<script src="/js/exam.js"></script>

<script>
	$(function() {

		// 수정, 등록, 나가기
		$(document).on('click', '.btns input[type=button]',function() {
			//console.log('aa');
			var bid = $(this).attr('id');
			console.log(bid);

			// examf
			// 수정 버튼일 경우
			if(bid == 'updateBtn'){
				document.location = "/exam/updateExam?examVo=${examVo}&questionList=${questionList}&answerList=${answersheetLists}";
				
			}else if(bid == 'regBtn'){ // 등록 버튼일 경우
				str = '<input type="text" name="exam_state" value="1">';

				$('#examf').append(str);

				$('#examf').submit();
				
			}else{ // 취소 버튼일 경우 , cancle -> 해당 강의 페이지로 이동한다.
				//document.location = "/post/selectPost?postid=" + postid;
			}
		});
		
		

	})
</script>
<title>examSelect</title>
<style>
body {
	background-color: rgb(240, 235, 248);
}

#d2 {
	text-align: center;
}

#d1 {
	background: rgb(103, 58, 183);
	display: inline-block;
	border-top-left-radius: 8px;
	border-top-right-radius: 8px;
	height: 10px;
	width: calc(80% + 2px);
	margin-top: 30px;
}

#d3 {
	padding-left: 20px;
	display: inline-block;
	margin-top: -4px;
	background-color: white;
	width: calc(80% + 2px);
	border-bottom-left-radius: 8px;
	border-bottom-right-radius: 8px;
	height: 150px;
	text-align: left;
}

.d4 {
	background-color: #4285f4;
	display: inline-block;
	height: 520px;
	width: calc(1% + 2px);
	border-top-left-radius: 8px;
	border-bottom-left-radius: 8px;
	float: left;
}

.d5 {
	display: inline-block;
	margin-left: -6px;
	background-color: white;
	width: calc(80% + 2px);
	border-top-right-radius: 8px;
	border-bottom-right-radius: 8px;
	height: 520px;
	text-align: left;
	
	margin-top: 10px;
}

.d6 {
	padding-left: 20px;
	padding-top: 5px;
}

#sel1 {
	width: 500px;
}

.form-control {
	width: 800px;
}

.radi {
	display: inline-block;
	margin-right: 5px;
}

.anw {
	margin-top: 10px;
}
.btnd {
	text-align: right;
	margin-top: 10px;
	padding-right: 20px;
}
.btns{
	text-align: right;
	margin-top: 10px;
	padding-right: 20px;
	
    margin-right: 90px;
}

.comment {
	resize: none;
}
.overlay{
	z-index: 1;
	position: absolute;
	display: none;
	background-color:rgba(230,244,234,0.5);
	width: 840px;
	height: 35px;
	
}
.chk{
	z-index: 2;
	    margin-left: 4px;
    margin-top: 10px;
	position: relative;
}
</style>
</head>
<body>
	<form action="/exam/insertExam" id="examf" method="post">
		<div id="d2">
			<div id="d1"></div>
			<div id="d3">
				<h2>시험</h2>
				<br> <label for="sel1">${examVo.exam_nm }</label> <br> 
			</div>
			<br><br><br>

			<c:forEach items="${questionList }" var="question" varStatus="status">
				<div class="d5">
					<div class="d4"></div>
					<div class="d6">
						<label for="sel1">${status.count }.${question.que_cont }</label> 
						<br><br>
						<c:forEach begin="${status.index*4 }" end="${status.count*4-1 }" items="${answersheetLists }" varStatus="vs">
							<div class="anw">
								<div class="overlay"></div>
								<input type="text" name="ans_cont" class="form-control radi" value="${answersheetLists[${status.index*4+vs.index }] }" readonly="readonly">
								<input type="checkbox" name="que_answer" value="${vs.count }" class="chk" readonly="readonly"/>
							</div>
						</c:forEach>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="btns">
			<input type="button" class="btn btn-default" id="updateBtn" value="수정하기">
			<input type="button" class="btn btn-default" id="regBtn" value="등록하기">
			<input type="button" class="btn btn-default" id="cancle" value="나가기">
		</div>
	</form>
</body>
</html>