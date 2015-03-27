package exam.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		String n = request.getParameter("name");
		String g = request.getParameter("gender");
		String c = request.getParameter("mycolor");
		String e = request.getParameter("email");
		String t = request.getParameter("txt");
		String s = request.getParameter("select");
		
		String[] h = request.getParameterValues("hobby");
		
		PrintWriter out = response.getWriter();
		
		out.print(n + "<br>");
		out.print(g + "<br>");
		out.print("<font color='" + c + "'>" + c + "</font><br>");
		out.print(e + "<br>");
		out.print(t + "<br>");
		out.print(s + "<br>");
		
		if(h == null)
			out.print("선택하세요.");
		else{
			out.print(h.length + "개 선택!" + "<br>");
		
			for(int i=0; i<h.length; i++)
				out.print(h[i] + "<br>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
