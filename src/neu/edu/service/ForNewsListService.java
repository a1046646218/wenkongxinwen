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
	 * ע��,�˴�ֱ�ӷ���ArrayList,��ʹ����һ��news����Ҳû��
	 * ArrayList����news����
	 * @param newsType
	 * @param newsIndex
	 * @return ArrayList<News>
	 */
	public ArrayList<News> getNewsList(String newsType,int newsIndex){
		return newsDao.searchNewsList(newsType, newsIndex);
	}
	
	/**
	 * �����û������ҳ��û��ղص�����news
	 * @param user_id
	 * @return
	 */
	public ArrayList<News> getNewsList(int user_id){
		ArrayList<Integer> newsIdList = favoriteDao.getNewsIdListByUserId(user_id);
		return newsDao.getNewsList(newsIdList);
	}
	
	/**
	 * ������  getNewListByID
	 * ����  int  user_id
	 * ����ֵ  ArrayList<News> list
	 * ȥ���ݿ��и����û�id�ҵ���������û�����������
	 * ע�⣬���û�У����ص���һ���յ�ArrayList,������null
	 * */
	public ArrayList<News>  getNewsListByID(int user_id){
		ArrayList<News> list = newsDao.getNewsListByID(user_id);
		return list;
	}
	
	/**
	 * ����  int new_id
	 * ����  News  news
	 * ���û���ҵ��������ţ�����null
	 * ��������id �������id������
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
