package exam.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/view")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("<h1>회원 상세페이지</h1>");
		
		String id = request.getParameter("id");
		//out.print(id);
	
		//2. 데이터베이스 연결
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","jspuserc","jsp1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//서버연결주소,아이디,비밀번호 설정해줘야함
	    //getconnection 메소드는 connection타입 return , 기본제공 객체라 new안해도됨
		
		//3. sql문 실행
		PreparedStatement pstmt = null;
		String sql = "select * from member where id=?";
		
		try{
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				out.print("<table border=1>");
				
				out.print("<tr>");
				out.print("<td>아이디</td>");
				out.print("<td>"+rs.getString("id")+"</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>이름</td>");
				out.print("<td>"+rs.getString("name")+"</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>나이</td>");
				out.print("<td>"+rs.getString("age")+"</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>성별</td>");
				out.print("<td>"+rs.getString("gender")+"</td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>주소</td>");
				out.print("<td>"+rs.getString("addr")+"</td>");
				out.print("</tr>");
				
				out.print("</table>");
				
				out.print("<a href='delete.jsp?id="+rs.getString("id")+"'>삭제</a>");
			}
			
		}catch(SQLException e){
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
