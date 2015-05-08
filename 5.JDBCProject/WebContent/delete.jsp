<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.*" %>
<%
	String id = request.getParameter("id");
	//1.JDBC 드라이버 로드
	Class.forName("oracle.jdbc.driver.OracleDriver"); //ojdbc6.jar 클래스 추가

	//2.데이터 베이스와 연결
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","jspuserc","jsp1234");//서버연결주소,아이디,비밀번호 설정해줘야함
	//getconnection 메소드는 connection타입 return , 기본제공 객체라 new안해도됨
	
	//3. sql문 실행
	String sql = "delete member where id=?";
	PreparedStatement pstmt = con.prepareStatement(sql);
    
    //바인딩(맵핑)
    pstmt.setString(1, id);
    
    int result = pstmt.executeUpdate();
    
    if(result==1)
    	response.sendRedirect("list");
    
    //out.print(result);
    
    //4.DB연결 끊기
    pstmt.close();
    con.close();
	
%>

		<!DOCTYPE html>
		<html>
		<head>
			<title>JSP/Servlet Example</title>
		</head>
		
		<body>
		
		</body>
		</html>	