<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>index</title>
<script>
	$(function() { 

		$('#regBtn').on('click', function(){
			window.open('test.jsp','pop', 'width=1100,height=900,resizable=no,scrollbar=yes');
		})
		
	})
        
</script>

</head>
<body>
	<input type="button" value="시험 등록" id="regBtn">
	
</body>
</html>