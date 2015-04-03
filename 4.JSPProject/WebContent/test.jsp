<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	int num1=10, num2=20;

	int num3 = num1 + num2;
	
	out.print(num3);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Servlet Example</title>
</head>
<body>
<!-- HTML주석 -->
<% out.print("hello");%>  <!-- 둘이 같음 -->.
<%= "hello" %>

</body>
</html>