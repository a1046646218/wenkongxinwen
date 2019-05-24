package DTFservlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import neu.edu.entity.Comment;
import neu.edu.entity.User;
import neu.edu.service.ShowNewsCommentService;

/**
 * Servlet implementation class forCommentListByUserIdServlet
 */
@WebServlet("/forCommentListByUserIdServlet")
public class forCommentListByUserIdServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShowNewsCommentService show = new ShowNewsCommentService();
		User user  = (User)request.getSession().getAttribute("user");
		ArrayList<Comment> list = show.showNewsComments(user.getUserId());
		String jsonString = JSON.toJSONString(list);
		System.out.println(jsonString);
		response.getWriter().println(jsonString);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
