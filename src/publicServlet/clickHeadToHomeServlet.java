package publicServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neu.edu.entity.User;
import neu.edu.service.ForUserService;

/**
 * Servlet implementation class clickHeadToHomeServlet
 */
@WebServlet("/clickHeadToHomeServlet")
public class clickHeadToHomeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userotherid= Integer.parseInt(request.getParameter("otheruserId"));
		User userother=new ForUserService().getUserByuserId(userotherid);
		User me = (User)request.getSession().getAttribute("user");
		if(me.getUserId()!=userother.getUserId()) {
			request.setAttribute("userother", userother);
			request.getRequestDispatcher("otherhome.jsp").forward(request,response);		
		}else {
			response.sendRedirect("home.jsp");
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
