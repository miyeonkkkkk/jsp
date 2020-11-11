<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
img{
	width: 300px;
	height: 300px;
}
</style>
<script type="text/javascript">

	$(document).ready(function() {

// 		$('#profileDownBtn').on("click", function() {
// 			console.log("dd");
// 			document.location = "/member/profileDownload?userid=${param.userid}";
// 		});

		// client side에서는 서버사이드 변수나 값을 사용가능
		// client  /  server
		memberAjax("${param.userid}");
	});

	$(document).on("click","#profileDownBtn",function(){
		console.log("dd");
		document.location = "/member/profileDownload?userid=${param.userid}";
	});
	
	function memberAjax(m) {
		$.ajax({
			url : "/member/memberAjax",
			data : {
				userid : m // 필드명 : 값
			},
			method : "get",
			success : function(data) {
				console.log('ddd');
				var html = "";

				$('#ff').html(data);

			}

		});
	}
</script>
<form id="ff" class="form-horizontal" role="form">
	
</form>
</html>