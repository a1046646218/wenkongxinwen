package DTFservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import neu.edu.entity.User;
import neu.edu.service.AddCommentService;
import neu.edu.entity.Comment;

@WebServlet("/addcommentServlet")
public class addCommenttoNewsAjaxServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//"context":strr,"new_id":new_id
		int new_id = Integer.parseInt(request.getParameter("new_id"));
		String context = request.getParameter("context");
		User u = (User) request.getSession().getAttribute("user");
		Comment co = new Comment(0, u.getUserId(), new_id, context,0 , 0, u.getNickName());
		int i  = new AddCommentService().addComment(co);
		if(i==1) {
			String jsonString = JSON.toJSONString(co);
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
