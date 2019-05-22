package HLServlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import neu.edu.entity.User;
import neu.edu.service.ForUserService;



/**
 * Servlet implementation class foruserByUserid
 */
@WebServlet("/foruserByUserid")
public class foruserByUserid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public foruserByUserid() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		  response.setCharacterEncoding("utf-8"); 
		  int userotherid = Integer.parseInt(request.getParameter("id"));
		  User userother=new ForUserService().getUserByuserId(userotherid);
		  request.setAttribute("userother", userother);
		  request.getRequestDispatcher("otherhome.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
