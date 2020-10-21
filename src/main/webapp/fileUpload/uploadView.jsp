<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${cp}/fileUpload" method="post" enctype="multipart/form-data">
		userId : <input type="text" name="userid" value="brown"/> <br><br>
		
		<!-- 보안 문제로 인하여 값을 미리 설정하는게 불가능 하다. -->
		<!-- 파일 전송시 form 태그에 enctype="multipart/form-data" / 기본 설정은 enctype="application/x-www-form-urlencoded"  -->
		file : <input type="file" name="img"/><br><br>
		
		<button type="submit">전송</button>
	</form>
</body>
</html>