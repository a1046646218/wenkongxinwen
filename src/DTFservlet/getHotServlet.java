package DTFservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import neu.edu.dao.impl.NewsDaoImpl;
import neu.edu.entity.News;
import neu.edu.entity.User;
import neu.edu.service.ForFavoriteService;
import neu.edu.service.ForNewsListService;

/**
 * Servlet implementation class getHotServlet
 */
@WebServlet("/getHotloginNewsServlet")
public class getHotServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("³É¹¦");
		User u = (User)request.getSession().getAttribute("user");
		if(u==null) {
			NewsDaoImpl lm = new NewsDaoImpl();
			ArrayList<News> hotnews = new ArrayList<>();
			hotnews.add(lm.getNewsByID(2));
			hotnews.add(lm.getNewsByID(3));
			hotnews.add(lm.getNewsByID(4));
			String jsonString = JSON.toJSONString(hotnews);
			System.out.println(jsonString);
			response.getWriter().println(jsonString);
		}else {
			//System.out.println(u.getNickName());
			int user_id = u.getUserId();
			ForFavoriteService list = new ForFavoriteService();
			ArrayList<News> arrayList = list.getFavoriteByID(user_id);
			HashMap<String,Integer> map = new HashMap<>();
			System.out.println(arrayList.size());
			if(arrayList.size()==0) {
				NewsDaoImpl lm = new NewsDaoImpl();
				ArrayList<News> hotnews = new ArrayList<>();
				hotnews.add(lm.getNewsByID(2));
				hotnews.add(lm.getNewsByID(3));
				hotnews.add(lm.getNewsByID(4));
				
				String jsonString = JSON.toJSONString(hotnews);
				System.out.println(jsonString);
				response.getWriter().println(jsonString);
			}else {
				for(int i=0;i<arrayList.size();i++) {
					if(map.containsKey(arrayList.get(i).getType())) {
						map.put(arrayList.get(i).getType(),map.get(arrayList.get(i).getType())+1);
					}else {
						map.put(arrayList.get(i).getType(),0);
					}
				}
				String type = "";
				int nums = 0;
				Set<String> keys = map.keySet();
				for(String key :keys){
				    int num = map.get(key);
				    System.out.println(num);
				    if(num>=nums) {
				    	nums = num;
				    	type = key;
				    }
				}
				System.out.println(type);
				NewsDaoImpl lm = new NewsDaoImpl();
				ArrayList<News> hotnewss = lm.HotNews(type);
				ArrayList<News> hotnews = new ArrayList<>();
				for(int i=0;i<hotnewss.size()&&i<3;i++) {
					hotnews.add(hotnewss.get(i));
				}
				String jsonString = JSON.toJSONString(hotnews);
				System.out.println(jsonString);
				response.getWriter().println(jsonString);
				
			}
			
			
			
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
