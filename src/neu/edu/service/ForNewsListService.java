package neu.edu.service;

import java.util.ArrayList;

import neu.edu.dao.FavoriteDao;
import neu.edu.dao.NewsDao;
import neu.edu.dao.impl.FavoriteDaoImpl;
import neu.edu.dao.impl.NewsDaoImpl;
import neu.edu.entity.News;

public class ForNewsListService {
	
	private NewsDao newsDao = new NewsDaoImpl();
	private FavoriteDao favoriteDao = new FavoriteDaoImpl();
	
	/**
	 * 注意,此处直接返回ArrayList,即使里面一个news对象也没有
	 * ArrayList存有news对象
	 * @param newsType
	 * @param newsIndex
	 * @return ArrayList<News>
	 */
	public ArrayList<News> getNewsList(String newsType,int newsIndex){
		return newsDao.searchNewsList(newsType, newsIndex);
	}
	
	/**
	 * 根据用户名，找出用户收藏的所有news
	 * @param user_id
	 * @return
	 */
	public ArrayList<News> getNewsList(int user_id){
		ArrayList<Integer> newsIdList = favoriteDao.getNewsIdListByUserId(user_id);
		return newsDao.getNewsList(newsIdList);
	}
	
	/**
	 * 方法名  getNewListByID
	 * 输入  int  user_id
	 * 返回值  ArrayList<News> list
	 * 去数据库中根据用户id找到所有这个用户发布的新闻
	 * 注意，如果没有，返回的是一个空的ArrayList,而不是null
	 * */
	public ArrayList<News>  getNewsListByID(int user_id){
		ArrayList<News> list = newsDao.getNewsListByID(user_id);
		return list;
	}
	
	/**
	 * 输入  int new_id
	 * 返回  News  news
	 * 如果没有找到这条新闻，返回null
	 * 根据新闻id 返回这个id的新闻
	 * */
	public News getNewsByID(int new_id) {		
		News ne = newsDao.getNewsByID(new_id);
		return  ne;	
	}
	
	public ArrayList<News> getNewsListByTitle(String newsType,int newsIndex){
		ArrayList<News> li = newsDao.searchNewsListByTitle(newsType, newsIndex);
		return li;
	}
}
