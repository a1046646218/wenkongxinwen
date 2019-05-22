package HLServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neu.edu.entity.User;


/**
 * Servlet implementation class gg
 */
@WebServlet("/gg")
public class gg extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8"); 
		 response.setCharacterEncoding("utf-8"); 
		/*User u = new User(1, "xiaosheng", "hahaha", 10, 10, "fat", 10, 1, "1111");*/
		User u_other = new User(6, "hl", "tmdzibile", 12, 12, "wozibile", 11, 1, "2222"," ");
		/*request.getSession().setAttribute("user", u);*/
		request.setAttribute("userother", u_other);
		/*request.getRequestDispatcher("home.jsp").forward(request, response);*/
		request.getRequestDispatcher("hlenter.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
