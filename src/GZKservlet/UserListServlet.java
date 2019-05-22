package GZKservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import neu.edu.entity.User;
import neu.edu.service.ForFollowingService;

/**
 * Servlet implementation class UserListServlet
 */
@WebServlet("/userlist")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListServlet() {
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
		String type=request.getParameter("type");
		User user=(User)request.getSession().getAttribute("user");
		int id=user.getUserId();
		ForFollowingService ff=new ForFollowingService();
		if(type.equals("guanzhu"))
		{
			ArrayList<User> guanzhuliebiao = ff.getUserGuanByID(id);
			HashMap<String, Object> map = new HashMap<String,Object>();
			map.put("guanzhuliebiao", guanzhuliebiao);
			
			String jsonStr = JSON.toJSONString(map);
			response.getWriter().print(jsonStr);
		}
		else 
		{
			ArrayList<User> fansliebiao = ff.getUserFenByID(id);
			HashMap<String, Object> map = new HashMap<String,Object>();
			map.put("fansliebiao", fansliebiao);
			
			String jsonStr = JSON.toJSONString(map);
			response.getWriter().print(jsonStr);	
		}
	}

}
