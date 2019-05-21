package neu.edu.service;

import neu.edu.dao.NewsDao;
import neu.edu.dao.impl.NewsDaoImpl;
import neu.edu.entity.News;

public class AddNewsService {
	
	private NewsDao da = new NewsDaoImpl();
	/**
	 * 方法名  addNews
	 * 输入    title  String,User_id int,Content string,type string,nickname string,url string
	 * 返回值 int flag
	 * 输入新闻信息 之后在数据库中添加，成功返回1 失败返回0
	 * 默认 favorites为0
	 *  Like为0
	 * Comments为0
	 * News_id是自动增长不设置
	 * */
	
	public int addNews(String title,int User_id,String Content,String type,String nickname,String url) {
		
		int a = da.addNews(title,User_id,Content,type,nickname,url);	
		return a;
	}
	
	/**
	 * 方法名  addNews
	 * 输入  news对象
	 * 返回值 int flag
	 * 输入新闻信息 之后在数据库中添加，成功返回1 失败返回0
	 * News_id是自动增长不设置
	 * */
	public int addNews(News news) {
		return da.addNews(news);
	}
}
