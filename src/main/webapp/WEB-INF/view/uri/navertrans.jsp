<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<select id="source">
	<option value="ko">한국어</option>
	<option value="en">영어</option>
</select>
<textarea input="text" id="text">

</textarea>

<select id="target">
	<option value="ko">한국어</option>
	<option value="en">영어</option>
</select>
<textarea input="text" id="translated">

</textarea>
<button onclick="trans()">번역</button>

<script>
	
	
	function trans(){
		var url = 'http://localhost:88/translation';
		var text = document.querySelector('#text').value;
		var source = document.querySelector('#source').value;
		var target = document.querySelector('#target').value;
		url += '/'+target+'/'+source+'/'+text;
		console.log(url);
		
	
	var xhr = new XMLHttpRequest();
	xhr.open('GET',url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				var res = JSON.parse(xhr.response);
				var trans = document.querySelector('#translated');
				trans.value = res.TH_RES;
			}
		}
	}
	xhr.send();
	}
</script>
</body>
</html> 