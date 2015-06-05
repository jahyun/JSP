package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.Action;
import board.action.BoadrWriteFormAction;
import board.action.BoardListAction;
import board.action.BoardViewAction;
import board.action.BoardWriteAction;

/**
 * Servlet implementation class boardController
 */
@WebServlet("*.KOO")
public class boardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// System.out.println("gg");	
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String command = uri.substring(contextPath.length());
		
		/*System.out.println(contextPath);
		System.out.println(uri);
		System.out.println("command :" + command);*/
		//글쓰기폼
		if(command.equals("/writeForm.KOO")){
			Action action = new BoadrWriteFormAction();
			action.execute(request, response);
		}
		//글쓰기
		else if(command.equals("/write.KOO")){
			System.out.println("/write.board");
			Action action = new BoardWriteAction();
			action.execute(request, response);
		}
		//리스트
		else if(command.equals("/list.KOO")){
			System.out.println("/list.board");
			Action action = new BoardListAction();
			action.execute(request, response);
		}
		else if(command.equals("/view.KOO")){
			System.out.println("/view.board");
			Action action = new BoardViewAction();
			action.execute(request, response);
		}
	}
}
