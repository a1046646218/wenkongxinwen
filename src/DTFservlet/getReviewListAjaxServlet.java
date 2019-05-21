package DTFservlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import neu.edu.entity.Review;
import neu.edu.service.ForReviewListService;

/**
 * Servlet implementation class getReviewServlet
 */
@WebServlet("/getReviewListServlet")
public class getReviewListAjaxServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int commentId = Integer.parseInt(request.getParameter("commentId"));
		ArrayList<Review> list = new ForReviewListService().getreviewsListByNewId(commentId);
		String jsonString = JSON.toJSONString(list);
		System.out.println(jsonString);
		response.getWriter().println(jsonString);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
