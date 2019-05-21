package DTFservlet; 

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import neu.edu.entity.User;
import neu.edu.service.FordianzanCommentService;
import neu.edu.dao.impl.CommentDaoImpl;
import neu.edu.entity.Comment;
import neu.edu.entity.CommentDecode;


/**
 * Servlet implementation class getCommentsListServlet
 */
@WebServlet("/getCommentsListServlet")
public class getCommentsListAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int new_id = Integer.parseInt(request.getParameter("new_id"));
		User u = (User) request.getSession().getAttribute("user");
		ArrayList<Comment> list = new CommentDaoImpl().getCommentListByNewId(new_id);
		ArrayList<CommentDecode> lide = new ArrayList<>();
		FordianzanCommentService se = new FordianzanCommentService();
		CommentDecode a = null;
		for(int i=0;i<list.size();i++) {
			a = new CommentDecode(list.get(i), se.addDianzanComment(u.getUserId(), list.get(i).getCommentId()));
			lide.add(a);
		}
		String jsonString = JSON.toJSONString(lide);
		System.out.println(jsonString);
		response.getWriter().println(jsonString);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
