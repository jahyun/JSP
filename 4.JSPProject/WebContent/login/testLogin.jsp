<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<!-- testLogin.jsp -->
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");

	if(id.equals("test") && pwd.equals("1234")){
		
		session.setAttribute("loginId", id);
		response.sendRedirect("main.jsp");
	}
	else {
		response.sendRedirect("loginForm.jsp");

	}
%>
		<!DOCTYPE html>
		<html>
		<head>
			<title>JSP/Servlet Example</title>
		</head>
		
		<body>
		
		</body>
		</html>	