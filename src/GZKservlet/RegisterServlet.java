package GZKservlet;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import neu.edu.service.AddUserService;
import neu.edu.service.ForUserService;



/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public String Md5(String Password) throws NoSuchAlgorithmException
	{MessageDigest md5 = MessageDigest.getInstance("MD5");
	byte[] bytes = Password.getBytes();
	byte[] digest =md5.digest(bytes);
	char[] c ={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	StringBuffer sb = new StringBuffer();
	for(byte bb:digest){
        //15的8进制是0000,1111
          sb.append(c[(bb>>4)&15]);
          sb.append(c[bb&15]);
          System.out.println(sb.toString());
        }
	return sb.toString();
		
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		AddUserService  au=new AddUserService();
		String userName = request.getParameter("userName");
		String Password = request.getParameter("Password");
		String nickName = request.getParameter("nickName");
		
		if(au.addUser(userName,nickName,"",Password)>0)
		{
			response.sendRedirect("login.jsp");
		}   
	}
}
