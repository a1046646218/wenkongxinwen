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
import neu.edu.service.ForReviewService;
import neu.edu.entity.Comment;
import neu.edu.entity.Review;

@WebServlet("/addReviewtoReviewServlet")
public class addReviewtoReviewAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//"reviewId":reviewId,"reviewcotent":reviewcotent
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		String context = request.getParameter("reviewcotent");
		User u = (User) request.getSession().getAttribute("user");
		Review re = new ForReviewService().getReviewById(reviewId);
		Review nowre = new Review(0, re.getCommentId(), u.getUserId(), context, "@"+re.getNickName()+":"+re.getContent(), u.getNickName());
		int i  = new AddReviewService().addReview(nowre);
		if(i==1) {
			String jsonString = JSON.toJSONString(nowre);
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
