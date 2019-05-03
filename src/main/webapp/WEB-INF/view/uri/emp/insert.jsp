<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			xhr.open('POST','/emp/insert');
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
    <form class="form-signin" action="/emp/insert" method="GET">
      <img class="mb-4" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
      <label for="inputEmail" class="sr-only">Email address</label> 
      <input type="text" id="id" class="form-control" placeholder="아이디" required autofocus
      name="id">
      
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" id="pwd" class="form-control" placeholder="패스워드" required
      name="pwd">
      
      <label for="inputName" class="sr-only">Name</label>
      <input type="text" id="name" class="form-control" placeholder="이름" required
      name="name">
      
      <label for="inputMgr" class="sr-only">MGR</label>
      <input type="text" id="mgr" class="form-control" placeholder="매니저" required
      name="mgr">
      
      <br>
      
      <label for="inputComm" class="sr-only">Comm</label>
      <input type="text" id="mgr" class="form-control" placeholder="커미션" required
      name="comm">
      
      <label for="inputSal" class="sr-only">Sal</label>
      <input type="text" id="sal" class="form-control" placeholder="월급                                 단위 : 만원" required
      name="sal">
      
      <br>
      
        
    <br>
     <label for="inputHireDate" class="sr-only">HireDate</label>
     <input type="date" id="hireDate" class="form-control" placeholder="입사년월" required
      name="hireDate">
  
    <select name = "Job" id="job" class="form-control" placeholder="직급" required
      name="Job">  
    	<option value="사원">사원</option>
    	<option value="대리">대리</option>
    	<option value="과장">과장</option>
    	<option value="부장">부장</option>
    	<option value="차장">차장</option>    	
    </select>
    <select name = "deptNo" id="deptNo" class="form-control" placeholder="부서" required
      name="deptNO">
    	<c:forEach items="${deptList}" var="dept">
    		<option value="${dept.DEPTNO}"> ${dept.DNAME} </option>
    	</c:forEach>
    	
    </select>
   
 
    
      
      
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
