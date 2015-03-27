<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
	<title>JSP/Servlet Example</title>
	<style>
	/*body {
		background-image:url("cat.jpg");
		background-repeat:no-repeat;
		background-attachment:fixed;
		}*/
		input {
			border : green 1pt solid;
			color : red;
			font-size : 14px; 
			background-color : aqua;
			}
	</style>
	
	<script>
		function func(){
			alert("Hello JavaScript!");
		}
	</script>
	
</head>

<body>
<h1>request test</h1>
<hr>

<form action="TestServlet" onsubmit="return func()">
	<label for="name">이름 : </label><input type="text" id="name" name="name"><br>
	<input type="password" ><br>
	<input type="radio" name="gender" value="남자"> 남자
	<input type="radio" name="gender" value="여자"> 여자<br>
	
	<input type="checkbox" name="hobby" value="축구">축구
	<input type="checkbox" name="hobby" value="야구">야구
	<input type="checkbox" name="hobby" value="농구">농구<br>
	
	<input type="color" name="mycolor"><br>
	<input type="email" name="email"><br>
	
	<select name="subject">
		<option value="java">Java</option>
		<option value="jsp">JSP</option>
		<option value="hyml">HTML</option>
	</select><br>
	<textarea rows="20" cols="50" name="txt"></textarea>
	
	<input type="submit" value="서버로 제출">
</form>
</body>
</html>