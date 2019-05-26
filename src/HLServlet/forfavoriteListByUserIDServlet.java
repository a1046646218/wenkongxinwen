package HLServlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import neu.edu.entity.Comment;
import neu.edu.entity.News;
import neu.edu.service.ForFavoriteService;

@WebServlet("/forfavoriteListByUserIDServlet")
public class forfavoriteListByUserIDServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8"); 
		  response.setCharacterEncoding("utf-8"); 
		
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		ArrayList<News> alllist =  new ForFavoriteService().getFavoriteByID(user_id);
		
		ArrayList<News> list = new ArrayList<>();
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		System.out.println(alllist.size());
		for(int i=num;i<alllist.size()&&i<num+3;i++) {
			list.add(alllist.get(i));
		}
		
		
		String jsonString = JSON.toJSONString(list);
		System.out.println(jsonString);
		response.getWriter().println(jsonString);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
