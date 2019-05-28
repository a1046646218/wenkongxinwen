package DTFservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neu.edu.dao.impl.UserDaoImpl;
import neu.edu.entity.User;

@WebServlet("/changenickname")
public class changenickname extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("str");
		System.out.println(str);
		User u = (User) request.getSession().getAttribute("user");
		u.setNickName(str);
		UserDaoImpl lm = new UserDaoImpl();
		int i = lm.updateuserNickename(u.getUserId(), str);
		if(i==1) {
			request.getSession().setAttribute("user", u);
			response.getWriter().print(i);
		}else {
			request.getSession().setAttribute("user", u);
			response.getWriter().print(i);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
