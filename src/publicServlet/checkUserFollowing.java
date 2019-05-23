package publicServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import neu.edu.dao.impl.FollowingDaoImpl;
import neu.edu.entity.User;
import neu.edu.service.ForFavoriteService;
import neu.edu.service.ForLikeService;

@WebServlet("/checkUserFollowing")
public class checkUserFollowing extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int user_id = Integer.parseInt(request.getParameter("userid"));
		User u = (User) request.getSession().getAttribute("user");
		System.out.println(user_id);
		if(u==null||u.getUserId()==user_id) {
			System.out.println("相等");
			response.getWriter().print("error");
		}else {
			System.out.println("不相等");
			FollowingDaoImpl Followdao = new FollowingDaoImpl();
			int flag = Followdao.isFollowing(user_id, u.getUserId());
			response.getWriter().print(flag);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
