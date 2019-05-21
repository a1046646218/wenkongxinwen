package DTFservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import neu.edu.entity.User;
import neu.edu.service.AddReviewService;
import neu.edu.entity.Review;


@WebServlet("/makereviewServlet")
public class addReviewtoCommentAjaxServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int commentId = Integer.parseInt(request.getParameter("commentId"));
		String reviewcotent = (String)request.getParameter("reviewcotent");
		AddReviewService a = new AddReviewService();
		User u = (User) request.getSession().getAttribute("user");
		Review re = new Review(0, commentId, u.getUserId(), reviewcotent, "", u.getNickName());
		int i = a.addReview(re);
		if(i==1) {
			String jsonString = JSON.toJSONString(re);
			System.out.println(jsonString);
			response.getWriter().println(jsonString);
		}else {
			response.getWriter().println("");
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
