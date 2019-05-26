package DTFservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import alex.zhrenjie04.wordfilter2.WordFilterUtil;
import alex.zhrenjie04.wordfilter2.result.FilteredResult;
import neu.edu.entity.User;
import neu.edu.service.AddReviewService;
import neu.edu.dao.SensibleDao;
import neu.edu.dao.impl.SensibleDaolmpl;
import neu.edu.entity.Review;
import neu.edu.entity.Sence;


@WebServlet("/makereviewServlet")
public class addReviewtoCommentAjaxServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int commentId = Integer.parseInt(request.getParameter("commentId"));
		String reviewcotent = (String)request.getParameter("reviewcotent");
		AddReviewService a = new AddReviewService();
		FilteredResult res = WordFilterUtil.filterText(reviewcotent,'*');
		String Filtercontext = res.getFilteredContent();
		User u = (User) request.getSession().getAttribute("user");
		if(u.getVip()>=40) {
			Review re = new Review(0, commentId, u.getUserId(), Filtercontext, "", u.getNickName());
			int i = a.addReview(re);
			re.setReviewId(i);
			if(res.getLevel()!=0) {
				SensibleDao lmp = new SensibleDaolmpl();
				lmp.addSence(new Sence(0,reviewcotent,res.getBadWords(),u.getUserId(),u.getNickName(),0,i));
				u.setVip(u.getVip()-1);
				lmp.downvip(u.getUserId());
			}else if(u.getVip()<100) {		
				SensibleDao lmp = new SensibleDaolmpl();
				u.setVip(u.getVip()+1);
				lmp.upvip(u.getUserId());
			}
			if(i!=0) {
				String jsonString = JSON.toJSONString(re);
				System.out.println(jsonString);
				response.getWriter().println(jsonString);
			}else {
				response.getWriter().println("Ê§°Ü");
			}
		}
		response.getWriter().print("");
		
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
