<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Insert title here</title>

<script>
	$(function() {
		$('.r1').on('change', function() {
			vmethod = $('input[type=radio]:checked').val()
			console.log(vmethod)
			$('#ff').attr('method', vmethod)
			console.log($('#ff').attr('method'))

		})
	})
</script>
</head>
<body>
	<%-- 파라미터 : client 서버로 요청을 보낼 떄 추가적으로 보낸 값
				ex) 로그인 요청시 : 사용자id, 비밀번호
				
		파라미터는 내부적으로 Map<String, String[]> 객체로 관리를 한다.
						  파라미터 이름, 파라미터 값들
						  => 동일한 이름의 파라미터를 여러개 보낼수 있다.
		
		request 객체에 있는 파라미터 관련 메서드 4가지
		- String getParameter(String param) : param에 해당하는 파라미터 값을 조회한다.
											  파라미터맵에서 첫번째 값을 반환
		- String[] getParameterValues(String param) : param에 해당하는 모든 파라미터 값을 반환한다.
		- Map<String, String[]> getParameterMap() : request 객체에 생성된 파라미터 맵을 반환한다.
		- Enumeration<String> getParameterNames() : request 객체에 담긴 모든 파라미터 이름을 반환한다.
	--%>
	<%-- 한글 파라미터 설정
		 get : server.xml <Connector URIEncoding="utf-8">
		 post : request.setCharacterEncoding("utf-8")
		 		request.getParameter()메서드를 호출하기 전에 설정을 해줘야 한다.
	--%>
	<%-- action : 요청을 보낼 경로 
		 method : 요청 방식 (form에서는 GET, POST 두가지만 가능하면 DEFAULT는 GET)
	--%>
<!--	<form action="/request/getRequestResponse.jsp" method="get" id="ff"> -->
	<form action="/request/getRequestResponse.jsp" method="get" id="ff">
		<fieldset>
		<label>user id : </label>
		<input type="text" name="user_id" id="user_id" value="id1">
		<br>
		<label>user id2 : </label>
		<input type="text" name="user_id" id="user_id2" value="id2">
		<br>
		<label>password : </label>
		<input type="password" name="user_pass" id="user_pass" value="pass1234">
		<br><br>
		<input type="submit" value="전송">
		</fieldset>
	</form>
	<br>
	GET / POST 두가지를 선택할 수 있는 라디오 버튼을 만들어서<br>
	FORM 전송시 사용자가 GET, POST 방식을 지정할 수 있도록 한다.<br>
	<input type="radio" name="method" value="GET" class="r1">GET <br>
	<input type="radio" name="method" value="POST" class="r1">POST <br>
	
	
</body>
</html>