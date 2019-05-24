package GZKservlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neu.edu.entity.User;
import neu.edu.service.AddUserService;
import neu.edu.service.ForUserService;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String Password = request.getParameter("Password");	
		AddUserService au=new AddUserService();
		try {
			Password=au.Md5(Password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ForUserService  fus=new ForUserService ();
		User user=fus.getUserByusername(userName);
		if (user==null) 
		{
			request.setAttribute("errorMsg", "用户名不存在");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} 
		else 
		{
			
			if (Password.equals(user.getPassword()))
			{
				Cookie cookie=new Cookie("userName", userName);
				cookie.setMaxAge(60*60);
				response.addCookie(cookie);
				request.getSession().setAttribute("user", user);
				response.sendRedirect("main.jsp");
			}
			 
		    else 
		    {
				request.setAttribute("errorMsg", "用户名存在,但是密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		
	
		
		
	}

}
