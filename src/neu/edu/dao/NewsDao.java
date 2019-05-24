package neu.edu.dao;

import java.util.ArrayList;

import neu.edu.entity.News;



public interface NewsDao {
	
	/**
	 * 根据新闻的类型newsType,和当前页面的新闻数newsIndex,从数据库news表中选出数据
	 * 封装成news对象，放入arrayList里
	 * @param newsType
	 * @param newsIndex
	 * @return 
	 */
	public ArrayList<News> searchNewsList(String newsType,int newsIndex);
	
	/**
	 * 传入一个存有数个newsId的ArrayList,从数据库news表中找到与newsId对应的数据
	 * @param newsIdList
	 * @return
	 */
	public ArrayList<News> searchNewsListByTitle(String newsType,int newsIndex);
	public ArrayList<News> getNewsList(ArrayList<Integer> newsIdList);
	
	public int addNumOfFavoritetoNews(int new_id);
	
	public int addNumOfLiketoNews(int new_id);
	
	public int addNews(String title, int user_id, String content, String type, String nickname, String url);
	
	public int addNews(News news);
	
	public ArrayList<News>  getNewsListByID(int user_id);
	
	public News getNewsByID(int new_id);
	
	public int addNumOfCommentstoNews(int new_id);
}
