package board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoadrWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = "./board/write.jsp"; //jsp파일을 보여주면 됨 
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(uri);
		
		dispatcher.forward(request, response);
	}
}
