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
		System.out.println("������TestMain2��doGet����");
		HttpSession session = request.getSession();
		//��������Ӧ����������username,�������ruojichong����
		session.setAttribute("userid", "1");
		response.sendRedirect("main.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("������TestMain2��doPost����");
		//int id = Integer.parseInt(request.getParameter("id"));
		//System.out.println(id);
		//if(id==1) {
			HttpSession session = request.getSession();
			//��������Ӧ����������username,�������ruojichong����
			session.setAttribute("userid", "1");
			response.sendRedirect("main.html");
		//}else {
			//response.sendRedirect("main.html");
		//}
	}

}
