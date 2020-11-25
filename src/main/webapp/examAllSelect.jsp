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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- js 추가 -->
<script src="/js/exam.js"></script>

<script>
$(function() {
	// 시험 등록 상태, 커리큘럼 아이디, 현재 보여주는 페이지 번호 인자로...
	//selectAllExam(99,${cur_id},1);

	// 조회 조건에 따라서
	$('#search').on('change', function(){
		var es = $(this).val();
		
		// 해당 강의를 선택했을 때 가져온다.
// 		var ci = ${cur_id};

		// 해당 강의의 검색 조건에 따른 1페이지 가져오기
		selectAllExam(es, ${cur_id}, 1);
		
	});

	// 시험 등록 폼 제공
	$('#regBtn').on('click', function(){
		var windowObj = window.open('examInsert.jsp','examInsert', 'width=1100,height=900,resizable=no,scrollbars=yes');

		// 부모 -> 자식창으로 데이터 전달
		windowObj.document.getElementById("cur_id").value = '${cur_id}';
	});

	// 시험 상세페이지
	$('#examList tr').on('click', function(){
		var exam_id = $(this).data("exam_id");

		console.log(exam_id);

		document.location = "/exam/selectExam?exam_id=" + exam_id;
		
	});
	
});
</script>
<title>examAllSelect</title>

<style>
#wul {
	width: 1000px;
}

#hd {
	margin-left: 15px;
}
#search {
	width: 115px;
	display: inline-block;
	margin-right: 10px;
	margin-bottom: 10px;	
}
#right{
	text-align: right;
}
#regBtn{
	margin-right: 10px;
	margin-bottom: 10px;
	margin-top: 8px;
}
</style>
</head>
<body>
<h2 id="hd">EXAM LIST</h2>
<div id="right">
	<select class="form-control" id="search">
		<option value="99">등록 상태</option>
		<option value="0">수정중</option>
		<option value="1">등록완료</option>
	</select>
	<input type="button" class="btn btn-default" value="시험 등록" id="regBtn">
</div>
<table class="w3-hoverable w3-table w3-striped w3-bordered" id="wul">
    <thead>
      <tr class="w3-light-grey">
        <th>순</th>
        <th>시험명</th>
        <th>작성일</th>
        <th>등록 상태</th>
        <th>-</th>
      </tr>
    </thead>
    <tbody id="examList">
	    <tr>
	      <td>Jill</td>
	      <td>Smith</td>
	      <td>50</td>
	    </tr>
    </tbody>
</table>

<c:if test="${examList.size() ne 0 }">
	<%-- pages : ${pages} --%>
	<!-- 현재 있는 페이지 번호 출력 -->
	<%-- page : ${page} --%>
	<div class="text-center">
		<ul class="pagination">
			
		</ul>
	</div>
</c:if>
</body>
</html>