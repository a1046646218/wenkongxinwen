package DTFservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neu.edu.entity.User;
import neu.edu.service.ForLikeService;

@WebServlet("/addLikeNewsAjaxServlet")
public class addLikeNewsAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int new_id = Integer.parseInt(request.getParameter("new_id"));
		User u = (User) request.getSession().getAttribute("user");
		int flag = new ForLikeService().addLikeNews(new_id, u.getUserId());
		response.getWriter().print(flag);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
