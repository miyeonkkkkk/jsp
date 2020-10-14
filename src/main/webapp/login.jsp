<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/js.cookie-2.2.1.min.js"></script>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">
    
    
    <script>
    // 쿠키 조회 메소드
	function getCookieValue(cookieName){
		var cookies = document.cookie.split("; ") // 쿠키를 나누고
		
		for(i=0; i<cookies.length; i++) {
			var cookie = cookies[i].split("="); // 쿠키 하나를 쪼개고
			if(cookie[0] == cookieName) {
				var cookieValue = cookie[1];
				//console.log(cookieValue);
				return cookieValue;
			}
		}
		return "";
	}

	// 쿠키 생성 메소드(쿠키이름, 쿠키값, 유효기간)
	function setCookie(cookieName, cookieValue, expires){

		var today = new Date();
		// 현재 날짜에서 미래로 + expires 만큼 한 날짜 구하기
		today.setDate(today.getDate() + expires);
		
		document.cookie = cookieName + "=" + cookieValue + "; path=/; expires=" + today.toGMTString();
		console.log(document.cookie);

	}

	// 해당 쿠키의 expires속성을 과거 날짜로 변경
	function deleteCookie(cookieName){
		setCookie(cookieName, "", -1);
	}

	$(function() { 
		// 1. REMEMBERME의 쿠키값을 가져와서 Y인지 체크
		var rememberme = Cookies.get('REMEMBERME');
		console.log(rememberme);

		// 2. Y로 설정이 되어 있다면 체크박스를 체크 상태로 변경
		if(rememberme == "Y"){
			$('#chk').prop('checked', true);
			//$('#chk').attr('checked','checked');
			//$('#chk').attr('checked', true);
			
			// 3. USERID의 쿠키값을 email에 뿌리기
			var userid = Cookies.get('USERID');
			$('#inputEmail').val(userid);
		}

		// sign in 버튼이 클릭 되었을 때
		$('#sign').on('click', function(){
			// 1. Remember me 체키박스가 체크 되어 있으면
			if($('#chk').prop('checked')){
				// 2. REMEMBERME 쿠키를 Y로 설정
				Cookies.set('REMEMBERME', 'Y');
				
				// 3. USERID 쿠키를 input태그에 입력된 값으로 설정
				Cookies.set('USERID', $('#inputEmail').val());
				
				// 4. form 태그에 대한 submit 처리

			}else{ // 4. Remember me 체크 박스가 체크 안되어 있으면
				// 5. REMEMBERME, USERID 쿠키를 삭제
				Cookies.remove('REMEMBERME');
				Cookies.remove('USERID');
			}
			
			$('#ff').submit();
		})
		
	})
        
    </script>

  </head>

  <body>

    <div class="container">

      <form class="form-signin" action="${pageContext.request.contextPath}/login" method="post" id="ff">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" name="userId" class="form-control" placeholder="Email address" required autofocus value="brown">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required value="brownPass">
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me" id="chk"> Remember me
          </label>
        </div>
        <!-- <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button> -->
        <button class="btn btn-lg btn-primary btn-block" type="button" id="sign">Sign in</button>
      </form>

    </div> <!-- /container -->

  </body>
</html>
