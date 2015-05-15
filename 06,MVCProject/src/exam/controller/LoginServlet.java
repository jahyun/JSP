package exam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exam.dao.MemberDAO;
import exam.dto.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberDAO dao = new MemberDAO();
		//DTO 미사용
		int r = dao.loginMember(id, pwd);
		
		if(r == 0){
			response.sendRedirect("login.jsp");
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("login",id);
			
			response.sendRedirect("list.jsp");
		}
		
		
	/*	//DTO 사용
		Member member = new Member();
		
		member.setId(id);
		member.setId(pwd);
		dao.loginMember(member);
		*/
		
	}

}
