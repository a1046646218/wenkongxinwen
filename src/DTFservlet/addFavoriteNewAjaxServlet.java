package DTFservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neu.edu.entity.User;
import neu.edu.service.ForFavoriteService;
import neu.edu.service.ForLikeService;

@WebServlet("/addFavoriteNewAjaxServlet")
public class addFavoriteNewAjaxServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("sss");
		int new_id = Integer.parseInt(request.getParameter("new_id"));
		User u = (User) request.getSession().getAttribute("user");
		int flag = new ForFavoriteService().addFavoriteNews(new_id, u.getUserId());
		System.out.println("hhaha");
		response.getWriter().print(flag);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
