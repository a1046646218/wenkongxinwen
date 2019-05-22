package HXBservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestMain2
 */
@WebServlet("/TestMain2")
public class TestMain2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestMain2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入了TestMain2的doGet方法");
		HttpSession session = request.getSession();
		//这里存入的应该是真正的username,这里仅用ruojichong代替
		session.setAttribute("userid", "1");
		response.sendRedirect("main.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入了TestMain2的doPost方法");
		//int id = Integer.parseInt(request.getParameter("id"));
		//System.out.println(id);
		//if(id==1) {
			HttpSession session = request.getSession();
			//这里存入的应该是真正的username,这里仅用ruojichong代替
			session.setAttribute("userid", "1");
			response.sendRedirect("main.html");
		//}else {
			//response.sendRedirect("main.html");
		//}
	}

}
