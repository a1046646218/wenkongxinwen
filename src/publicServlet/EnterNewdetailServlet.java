package publicServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neu.edu.service.ForNewsListService;
import neu.edu.service.ForUserService;

@WebServlet("/EnterNewdetailServlet")
public class EnterNewdetailServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int searchnew_id = Integer.parseInt(request.getParameter("searchnew_id"));
		ForNewsListService n = new 	ForNewsListService();
		request.setAttribute("news", n.getNewsByID(searchnew_id));
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
