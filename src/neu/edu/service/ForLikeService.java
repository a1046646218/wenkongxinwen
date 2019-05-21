package neu.edu.service;

import neu.edu.dao.NewsDao;
import neu.edu.dao.NewsLikeDao;
import neu.edu.dao.impl.NewsDaoImpl;
import neu.edu.dao.impl.NewsLikeDaoImpl;

public class ForLikeService {
	
	private NewsLikeDao newsLikeDao = new NewsLikeDaoImpl();
	private NewsDao newsDao = new NewsDaoImpl();
	/**
	 * 方法名 ：isLikeNews(int new_id,int user_id)
	 *输入   int new_id,int user_id 
	 * 输出   flag int 
	 * 判断是否user_id 的用户点赞了new_id的新闻
	 * 收藏了返回1，没有则返回0
	 * */
	public int isLikeNews(int new_id,int user_id) {
		int a = newsLikeDao.isLikeNews(new_id,user_id);
		return a;
	}
	
	/**
	 * 方法名：add addLikeNews(int new_id,int user_id)
	 * 输入   int new_id,int user_id
	 * 输出   flag int 
	 * 让user_id 的用户点赞了new_id的新闻，插入数据库表中、
	 * 更新两张表 新闻的表和newslike的表
	 * 如果之前收藏了返回0  这次收藏则返回1
	 * */
	public int addLikeNews(int new_id,int user_id) {	

		int a = newsLikeDao.isLikeNews(new_id,user_id);
		if(a==0) {
			newsLikeDao.addNewsLike(new_id, user_id);
			newsDao .addNumOfLiketoNews(new_id);
			return 1;
		}else {
			return 0;		
		}
	}
}
