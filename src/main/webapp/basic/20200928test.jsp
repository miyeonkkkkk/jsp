<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- jsp 스크립트 : 서버에서 실행됨 -> 결과만 클라이언트에게 전달이 된다.
	<% %>, <%= %>
--%>

	<%String str = ""; %>
	<%String str2 = "message"; %>
	<%String str3 = "hello"; %>
<script>
	// 서버에 있는 스크립트를 클라이언트에 적용 시킬수 없다.
	//<%=str%> = 'test';
	// <%=str%> = 'test'; 실행안됨 -> 서버와 관련없기 때문에 보임 -> 클라이언트에게 전달이 됨
	<%-- <%=str%> = 'test'; --%> // 서버에서 실행되기 때문에 보이지 않음 -> 클라이언트에게 전달 안됨
	 //		= 'test'; // 이런식으로 표현됨 -> 에러발생
	 		
	 // 서버에서 이미 실행이 된후 클라이언트에 넘어 오기 때문에 아래와 같이 적용된다.
	 // str변수는 없고 message 변수만 존재한다.
	<%=str2%> = 'test';
	// message = 'test';

	 // => 서버 사이드 변수에 클라이언트 사이드 값을 대입하는 경우 (X)
	 // => 서버 사이드 스크립트가 먼저 실행되므로 논리적으로 말이 안된다.
	 
	 // 클라이언트 사이드 변수에 서버 사이드 변수 값을 대입
	 // => 서버 사이드 스크립트가 먼저 실행되므로 논리적으로 말이 된다.
	 var msg = "<%=str3%>"; // "" 또는 ''로 감싸지 않으면 변수로 인식한다.
</script>	
</body>
</html>