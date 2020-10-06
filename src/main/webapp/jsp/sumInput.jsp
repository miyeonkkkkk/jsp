<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/sumCalculation" method="post">
		StartNum 과 EndNum은 정수이고, EndNum은 StartNum보다 큰수를 입력해주세요.<br>
		StartNum : <input type="text" name="start" value="정수1"><br>
		EndNum : <input type="text" name="end" value="정수2"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>