package DTFservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neu.edu.dao.impl.UserDaoImpl;
import neu.edu.entity.User;

/**
 * Servlet implementation class changeintroduce
 */
@WebServlet("/changeintroduce")
public class changeintroduce extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("str");
		System.out.println(str);
		User u = (User) request.getSession().getAttribute("user");
		u.setIntroduction(str);
		UserDaoImpl lm = new UserDaoImpl();
		int i = lm.updateuserintroduce(u.getUserId(), str);
		if(i==1) {
			request.getSession().setAttribute("user", u);
			response.getWriter().print(i);
		}else {
			request.getSession().setAttribute("user", u);
			response.getWriter().print(i);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
