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
import neu.edu.service.AddCommentService;
import neu.edu.dao.SensibleDao;
import neu.edu.dao.impl.SensibleDaolmpl;
import neu.edu.entity.Comment;
import neu.edu.entity.Sence;

@WebServlet("/addcommentServlet")
public class addCommenttoNewsAjaxServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//"context":strr,"new_id":new_id
		int new_id = Integer.parseInt(request.getParameter("new_id"));
		String context = request.getParameter("context");
		FilteredResult res = WordFilterUtil.filterText(context,'*');
		String Filtercontext = res.getFilteredContent();
		User u = (User) request.getSession().getAttribute("user");
		if(u.getVip()>=50) {			
			Comment co = new Comment(0, u.getUserId(), new_id, Filtercontext,0 , 0, u.getNickName());
			int i  = new AddCommentService().addComment(co);
			System.out.println(co);
			co.setCommentId(i);
			if(res.getLevel()!=0) {
				SensibleDao lmp = new SensibleDaolmpl();
				lmp.addSence(new Sence(0,context,res.getBadWords(),u.getUserId(),u.getNickName(),1,i));
				u.setVip(u.getVip()-1);
				lmp.downvip(u.getUserId());
			}else if(u.getVip()<100) {		
				SensibleDao lmp = new SensibleDaolmpl();
				u.setVip(u.getVip()+1);
				lmp.upvip(u.getUserId());
			}
			if(i!=0) {
				String jsonString = JSON.toJSONString(co);
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
