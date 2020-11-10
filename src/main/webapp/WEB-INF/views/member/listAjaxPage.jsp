<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<script>
	// 해당 html이 로딩이 완료 되었을 때 실행되는 이벤트 핸들러 함수
	$(document).ready(function() {

		// ajax call을 통해 1페이지에 해당하는 사용자 정보를 json으로 받는다.
		// ajax함수를 호출한다.
		// 3가지 속성과 함수가 존재한다.
		// 기존의 form 요청을 했을때 사용자 리스트와 페이지 정보가 필요하다.
		// 비동기 실행 이기 때문에 call을 해놓고 아래의 코드를 실행 -> 응답을 기다리지 않는다.
		// 그래서 실행하는 시점도 중요하다.
// 		memberListAjax(1);
		memberListAjaxHTML(1);

		// delegate() 이용 -> ajax가 비동기이기 때문에
		// #memberList에 이벤트를 적용 시켜서 tr이 있는지 검사후에 실행한다.
		$('#memberList').on('click', 'tr', function() {
			// data-userid <tr>태그에 적어놓음
			var userid = $(this).data("userid");
			console.log("userid:" + userid);
// 			document.location = "/member/getMember?userid=" + userid;
			document.location = "/member/getMemberAjax?userid=" + userid;
		});

	});

	function memberListAjax(p) {
		$.ajax({
			url : "/member/listAjax",
			data : {
				page : p,
				pageSize : 5
			}, // form 전송 형태로 간다. 파라미터 형태로 전송
			// data : "page=1&pageSize=5" 쿼리 스트링 형태로 전송
			// data : JSON.stringify({page : 1, pageSized : 5}) 문자열 형태로 전송 -> 받을때 Controller에서 @RequestBody를 사용해야 한다.
			//		JSON <---> JAVA OBJECT 마샬링, 언마샬링 알아보기 -> 이 작업에서 사용한 것이 @ResponseBody, @RequestBody
			method : "get",
			success : function(data) { // memberList, pages 이름으로 data가 넘어와있다. 
				// 커맨드 객체는 속성에 추가 하지 않아도 스프링에서 자동으로 추가 되기 때문에 PageVo도 data에 들어가 있다.
				// 디버깅 하기 애매하다. -> 의미없는 코드 사용 또는 console.log
				var i = 0;
// 				console.log('ddd');

				// memberList tbody 영역에 들어갈 html 문자열 생성
				var html = "";
				for (var i = 0; i < data.memberList.length; i++) {
					var member = data.memberList[i];
					// 						var length = ${memberList.size()}; // 이 경우는 가능하다.
					html += "<tr data-userid='" + member.userid + "' >";
					html += "	<td>" + member.userid + "</td>";
					html += "	<td>" + member.usernm + "</td>";
					html += "	<td>" + member.alias + "</td>";
					html += "	<td>" + member.reg_dt + "</td>";
					//-> 스크립틀릿을 자바태그로 간단하게 표현 -> 서버에서 실행 -> 사용자에게 문자열만 리턴한다. -> 동적 데이터를 처리하기 위해 사용
					// ajax 안은 클라이언트 영역이기 때문에 서버에서 인식하는 jstl 은 사용하지 못한다.
					// 클라이언트 쪽에 서버의 변수를 넣을 수는 있지만 반대는 안된다.
					// 서버가 처리된후 그 결과가 클라이언트에 오기 때문에 반대의 경우는 되지 않는다.
					// 그래서 jstl 사용 불가
					html += "</tr>"
				}
				$("#memberList").html(html); // html코드를 해당 영역에 자식으로 삽입

				// 페이지 네비게이션 html 문자열 동적으로 생성하기
				var html2 = "";
// 				console.log(data.pageVo);
				for (var i = 1; i <= data.pages; i++) {
					if (data.pageVo.page == i) {
						html2 += "<li class='active'><span>" + i
								+ "</span></li>";
					} else {
						html2 += "<li><a href='javascript:memberListAjax(" + i + ");'>" + i + "</a></li>";
					}
				}
				$('.pagination').html(html2);
			}
		});
	}
	
	function memberListAjaxHTML(p) {
		$.ajax({
			url : "/member/listAjaxHTML",
			data : {
				page : p,
				pageSize : 5
			}, // form 전송 형태로 간다. 파라미터 형태로 전송
			// data : "page=1&pageSize=5" 쿼리 스트링 형태로 전송
			// data : JSON.stringify({page : 1, pageSized : 5}) 문자열 형태로 전송 -> 받을때 Controller에서 @RequestBody를 사용해야 한다.
			//		JSON <---> JAVA OBJECT 마샬링, 언마샬링 알아보기 -> 이 작업에서 사용한 것이 @ResponseBody, @RequestBody
			method : "get",
			success : function(data) { // memberList, pages 이름으로 data가 넘어와있다. 
				// 커맨드 객체는 속성에 추가 하지 않아도 스프링에서 자동으로 추가 되기 때문에 PageVo도 data에 들어가 있다.
				// 디버깅 하기 애매하다. -> 의미없는 코드 사용 또는 console.log
				var i = 0;
// 				console.log('ddd');

				// memberList tbody 영역에 들어갈 html 문자열 생성
				var html = "";
// 				for (var i = 0; i < data.memberList.length; i++) {
// 					var member = data.memberList[i];
					// 						var length = ${memberList.size()}; // 이 경우는 가능하다.
// 					html += "<tr data-userid='" + member.userid + "' >";
// 					html += "	<td>" + member.userid + "</td>";
// 					html += "	<td>" + member.usernm + "</td>";
// 					html += "	<td>" + member.alias + "</td>";
// 					html += "	<td>" + member.reg_dt + "</td>";
// 					//-> 스크립틀릿을 자바태그로 간단하게 표현 -> 서버에서 실행 -> 사용자에게 문자열만 리턴한다. -> 동적 데이터를 처리하기 위해 사용
// 					// ajax 안은 클라이언트 영역이기 때문에 서버에서 인식하는 jstl 은 사용하지 못한다.
// 					// 클라이언트 쪽에 서버의 변수를 넣을 수는 있지만 반대는 안된다.
// 					// 서버가 처리된후 그 결과가 클라이언트에 오기 때문에 반대의 경우는 되지 않는다.
// 					// 그래서 jstl 사용 불가
// 					html += "</tr>"
// 				}
// 				$("#memberList").html(html); // html코드를 해당 영역에 자식으로 삽입

				// 응답을 html로 받았을 때
				$("#memberList").html(data.split("$SEPERATOR$")[0]); // html코드를 해당 영역에 자식으로 삽입
				$("ul.pagination").html(data.split("$SEPERATOR$")[1]); // html코드를 해당 영역에 자식으로 삽입

				// 페이지 네비게이션 html 문자열 동적으로 생성하기
// 				var html2 = "";
// // 				console.log(data.pageVo);
// 				for (var i = 1; i <= data.pages; i++) {
// 					if (data.pageVo.page == i) {
// 						html2 += "<li class='active'><span>" + i
// 								+ "</span></li>";
// 					} else {
// 						html2 += "<li><a href='javascript:memberListAjax(" + i + ");'>" + i + "</a></li>";
// 					}
// 				}
// 				$('.pagination').html(html2);
			}
		});
	}
</script>


<div class="row">
	tiles : memberListContent.jsp
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
				<!--테이블내에서 가지고오려는 데이터를 나눌때 tbody많이 사용 -->
				<tbody id="memberList">

				</tbody>
			</table>
		</div>

		<a class="btn btn-default pull-right"
			href="${cp }/member/memberRegistView">사용자 등록</a> page:${page }
		<div class="text-center">
			<ul class="pagination">
			</ul>
		</div>
	</div>
</div>
</html>