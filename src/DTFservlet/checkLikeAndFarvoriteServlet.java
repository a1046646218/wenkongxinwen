package DTFservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import neu.edu.entity.User;
import neu.edu.service.ForFavoriteService;
import neu.edu.service.ForLikeService;
@WebServlet("/checkLikeAndFarvoriteServlet")
public class checkLikeAndFarvoriteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int new_id = Integer.parseInt(request.getParameter("new_id"));
		User u = (User) request.getSession().getAttribute("user");
		int isfavorite = new ForFavoriteService().isFavoriteNews(new_id, u.getUserId());
		int islike = new ForLikeService().isLikeNews(new_id, u.getUserId());
		int[] res = new int[] {islike,isfavorite};
		String jsonString = JSON.toJSONString(res);
		System.out.println(jsonString);
		response.getWriter().println(jsonString);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
