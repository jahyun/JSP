package board.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dto.Board;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BoardDAO dao = new BoardDAO();
		List<Board> list = dao.selectAllBoards();
		
		request.setAttribute("list", list);
		
		String uri = "./board/list.jsp"; //jsp파일을 보여주면 됨 
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(uri);
		
		dispatcher.forward(request, response);

	}

}
