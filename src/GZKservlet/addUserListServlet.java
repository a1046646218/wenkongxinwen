package GZKservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import neu.edu.entity.User;
import neu.edu.service.ForFollowingService;

/**
 * Servlet implementation class GuanzhuServlet
 */
@WebServlet("/adduserlist")
public class addUserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addUserListServlet() {
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
		int num=Integer.parseInt(request.getParameter("num"));
		User user=(User)request.getSession().getAttribute("user");
		int id=user.getUserId();
		ForFollowingService ff=new ForFollowingService();
		if(type.equals("guanzhu"))
		{
			ArrayList<User> liebiao = ff.getUserGuanByID(id);
			ArrayList<User> guanzhuliebiao=new ArrayList<User>();
			for(int i=num;i<=liebiao.size()-1&&i<=num+1;i++)
			{
			guanzhuliebiao.add(liebiao.get(i));
			}
			HashMap<String, Object> map = new HashMap<String,Object>();
			map.put("guanzhuliebiao", guanzhuliebiao);
			
			String jsonStr = JSON.toJSONString(map);
			response.getWriter().print(jsonStr);
		}
		else 
		{
			ArrayList<User> liebiao = ff.getUserFenByID(id);
			ArrayList<User> fansliebiao=new ArrayList<User>();
			for(int i=num;i<=liebiao.size()-1&&i<=num+1;i++)
			{
			fansliebiao.add(liebiao.get(i));
			}
			HashMap<String, Object> map = new HashMap<String,Object>();
			map.put("fansliebiao", fansliebiao);
			
			String jsonStr = JSON.toJSONString(map);
			response.getWriter().print(jsonStr);	
		}
	}
}

