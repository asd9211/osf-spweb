<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>로그인 화면</title>
    
    <!-- Bootstrap core CSS -->
    <link href="/resources/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/resources/signin.css" rel="stylesheet">
  </head>
	<script>
		window.addEventListener('load', function(){
			document.querySelector('#signinBtn').onclick = function(){
				var idObj = document.querySelector('#id');
				var pwdObj = document.querySelector('#pwd');
				if(idObj.value.trim().length<4){
					alert('ID는 4글자 이상입니다.');
					return;
				}
				if(pwdObj.value.trim().length<6){
					alert('비밀번호는 6글자 이상입니다.');
					return;
				}
			var xhr = new XMLHttpRequest();
			xhr.open('POST','/emp/login');
			xhr.setRequestHeader('content-type','application/x-www-form-urlencoded');
			xhr.onreadystatechange = function(){
				if(xhr.readyState==4){
					var obj = JSON.parse(xhr.response);
					if(obj.result==='false'){
						alert('아이디나 비밀번호가 잘못되었습니다.');
						idObj.value='';
						pwdObj.value='';
						idObj.focus();
					}else{
						location.href="/uri/index";
					}
				console.log(xhr.response);
			}
		}
			var param='id=' +idObj.value + '&pwd=' + pwdObj.value;
			xhr.send(param);
		}
	});
		
	</script>
  <body class="text-center">
    <form class="form-signin" action="/emp/login" method="post">
      <img class="mb-4" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
      <label for="inputEmail" class="sr-only">Email address</label> 
      <input type="text" id="id" class="form-control" placeholder="ID" required autofocus
      name="id">
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" id="pwd" class="form-control" placeholder="Password" required
      name="pwd">
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="button" id="signinBtn">Sign in</button>
      <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
    </form>
  </body>
</html>
