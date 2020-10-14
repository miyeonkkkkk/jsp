<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- mulCalculation -->
	<form action="${pageContext.request.contextPath}/mulCalculation" method="post">
		param1 과 param2은 정수이고, param2은 param1보다 큰수를 입력해주세요.<br>
		param1 : <input type="text" name="param1" value="1"><br>
		param2 : <input type="text" name="param2" value="5"><br>
		<input type="submit" value="전송">
	</form>

</body>
</html>