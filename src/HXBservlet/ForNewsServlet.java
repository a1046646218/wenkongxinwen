package HXBservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import neu.edu.entity.News;
import neu.edu.service.ForNewsListService;

/**
 * Servlet implementation class ForNewServlet
 */
@WebServlet("/ForNewsServlet")
public class ForNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入了ForNewServlet的doGet方法");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//System.out.println("进入了ForNewServlet的doPost方法");
		String newsType  = request.getParameter("newsType");
		System.out.println("newsType:"+newsType);
		int newsIndex  = Integer.parseInt(request.getParameter("newsIndex"));
		System.out.println("newsIndex:"+newsIndex);
		
		ForNewsListService forNewService = new ForNewsListService();
		List<News> newsList = forNewService.getNewsList(newsType, newsIndex);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", newsList);
		String jsonNewsList = JSON.toJSONString(map);
		//System.out.println(jsonNewsList);
		response.getWriter().print(jsonNewsList);
	}

}
