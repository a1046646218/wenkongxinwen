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
import neu.edu.entity.Comment;
import neu.edu.service.FordianzanCommentService;

@WebServlet("/dianzanpinglunServlet")
public class addLikeCommentAjaxServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int commentId = Integer.parseInt(request.getParameter("commentId"));
		System.out.println("µãÔÞ"+commentId);
		FordianzanCommentService ser = new FordianzanCommentService();
		User u = (User) request.getSession().getAttribute("user");
		int flag = ser.addDianzanComment(u.getUserId(), commentId);
		response.getWriter().println(flag);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
