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
import neu.edu.service.ForReviewService;
import neu.edu.dao.SensibleDao;
import neu.edu.dao.impl.SensibleDaolmpl;
import neu.edu.entity.Comment;
import neu.edu.entity.Review;
import neu.edu.entity.Sence;

@WebServlet("/addReviewtoReviewServlet")
public class addReviewtoReviewAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//"reviewId":reviewId,"reviewcotent":reviewcotent
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		String context = request.getParameter("reviewcotent");
		User u = (User) request.getSession().getAttribute("user");
		Review re = new ForReviewService().getReviewById(reviewId);
		FilteredResult res = WordFilterUtil.filterText(context,'*');
		String Filtercontext = res.getFilteredContent();
		String strsubcontent = null;
		if(re.getContent().length()>=10) {
			strsubcontent = re.getContent().substring(0, 6);
		}else {
			strsubcontent = re.getContent();
		}
		if(u.getVip()>=40) {
			Review nowre = new Review(0, re.getCommentId(), u.getUserId(), Filtercontext, "@"+re.getNickName()+":"+strsubcontent, u.getNickName());
			int i  = new AddReviewService().addReview(nowre);
			nowre.setReviewId(i);
			if(res.getLevel()!=0) {
				SensibleDao lmp = new SensibleDaolmpl();
				lmp.addSence(new Sence(0,context,res.getBadWords(),u.getUserId(),u.getNickName(),0,i));
				u.setVip(u.getVip()-1);
				lmp.downvip(u.getUserId());
			}else if(u.getVip()<100) {		
				SensibleDao lmp = new SensibleDaolmpl();
				u.setVip(u.getVip()+1);
				lmp.upvip(u.getUserId());
			}
			if(i!=0) {
				String jsonString = JSON.toJSONString(nowre);
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
