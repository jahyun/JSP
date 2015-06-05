package board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dto.Board;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num = request.getParameter("num");
		
		BoardDAO dao = new BoardDAO();
		Board board = dao.seletOnBoardByNum(Integer.parseInt(num));
		dao.updateHits(Integer.parseInt(num));
		
		request.setAttribute("board", board);
		
		String uri = "./board/view.jsp"; //jsp파일을 보여주면 됨 
		RequestDispatcher dispatcher = request.getRequestDispatcher(uri);
		dispatcher.forward(request, response);

	}

}
