package GZKservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neu.edu.entity.User;
import neu.edu.service.ForFollowingService;

/**
 * Servlet implementation class QuguanServlet
 */
@WebServlet("/quguan")
public class QuguanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuguanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int guanId=Integer.parseInt(request.getParameter("guanId"));
		User user=(User)request.getSession().getAttribute("user");
		int id=user.getUserId();
		ForFollowingService ff=new ForFollowingService();
		user.setFollowings(user.getFollowings()-1);
		boolean flag=ff.RemoveGuan(id, guanId);
		System.out.println(guanId);
	}

}
