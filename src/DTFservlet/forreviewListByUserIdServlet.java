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
import neu.edu.entity.Review;
import neu.edu.entity.User;
import neu.edu.service.SelectReviewService;

@WebServlet("/forreviewListByUserIdServlet")
public class forreviewListByUserIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SelectReviewService sel = new SelectReviewService();
		User user  = (User)request.getSession().getAttribute("user");
		ArrayList<Review> list = sel.selectReview(user.getUserId());
		String jsonString = JSON.toJSONString(list);
		System.out.println(jsonString);
		response.getWriter().println(jsonString);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
