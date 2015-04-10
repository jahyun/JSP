<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- logout.jsp -->
	<%
		session.removeAttribute("loginId");
	
		// session.invalidate(); 세션에 저장된 값을 모두 삭제
		response.sendRedirect("loginForm.jsp");

	%>
		<!DOCTYPE html>
		<html>
		<head>
			<title>JSP/Servlet Example</title>
		</head>
		
		<body>
		
		</body>
		</html>	