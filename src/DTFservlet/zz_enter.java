package DTFservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neu.edu.entity.User;
import neu.edu.service.ForNewsListService;
import neu.edu.service.ForUserService;


/**
 * Servlet implementation class gg
 */
@WebServlet("/zz_enter")
public class zz_enter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ForUserService u = new ForUserService();
		request.getSession().setAttribute("user", u.getUserByuserId(9));
		ForNewsListService n = new 	ForNewsListService();
		request.setAttribute("news", n.getNewsByID(12));
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
