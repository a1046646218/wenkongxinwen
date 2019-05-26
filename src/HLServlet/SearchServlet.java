package HLServlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import neu.edu.entity.News;
import neu.edu.service.ForNewsListService;



@WebServlet("/searchservlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
  
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�����������Ӧ�������ʽΪutf-8 
		  request.setCharacterEncoding("utf-8"); 
		  response.setCharacterEncoding("utf-8"); 
			String newsinfo = request.getParameter("newsinfo");
			System.out.println("newsinfo:"+newsinfo);
			int newsIndex  = Integer.parseInt(request.getParameter("newsIndex"));
			System.out.println(newsIndex);
			ForNewsListService sservice=new ForNewsListService();
			
			ArrayList<News> newsList = sservice.getNewsListByTitle(newsinfo, newsIndex);
			ArrayList<News> newsList2 = new ArrayList<News>();
			for(int i=newsIndex;i<newsList.size()&&i<newsIndex+2;i++) {
				newsList2.add(newsList.get(i));
			}
			String jsonNewsList = JSON.toJSONString(newsList2);
			System.out.println(jsonNewsList);
			response.getWriter().print(jsonNewsList);
			
	}

}
