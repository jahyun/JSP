package board.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dto.Board;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub\
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("textArea");
		
		Board board = new Board();
		
		board.setName(name);
		board.setTitle(subject);
		board.setContent(content);
		
		BoardDAO dao = new BoardDAO();
		int result = dao.insertBoard(board);
		
		if(result != 0){
			String uri = "list.KOO";
			response.sendRedirect(uri);
		}
	}

}
