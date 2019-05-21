package neu.edu.service;

import java.util.ArrayList;

import neu.edu.dao.FavoriteDao;
import neu.edu.dao.NewsDao;
import neu.edu.dao.impl.FavoriteDaoImpl;
import neu.edu.dao.impl.NewsDaoImpl;
import neu.edu.entity.News;

public class ForFavoriteService {
	private FavoriteDao favoriteDao = new FavoriteDaoImpl();
	private NewsDao newsDao = new NewsDaoImpl();
	
	/**
	 * 方法名 ：isFavoriteNews(int new_id,int user_id)
	 *输入   int new_id,int user_id 
	 * 输出   flag int 
	 * 判断是否user_id 的用户收藏了new_id的新闻
	 * 收藏了返回1，没有则返回0
	 * */
	public int isFavoriteNews(int new_id,int user_id) {
		
		int a = favoriteDao.isFavoriteNews(new_id,user_id);
		return a;
	}
	/**
	 * 方法名：add FavoriteNews(int new_id,int user_id)
	 * 输入   int new_id,int user_id
	 * 输出   flag int 
	 * 让user_id 的用户收藏了new_id的新闻，插入数据库表中、
	 * 更新两张表 新闻的表和favorite的表
	 * 如果之前收藏了返回0  这次收藏则返回1
	 * */
	public int addFavoriteNews(int new_id,int user_id) {	
		
		int a = favoriteDao.isFavoriteNews(new_id,user_id);
		if(a==0) {
			favoriteDao.addFavorite(new_id, user_id);
			newsDao.addNumOfFavoritetoNews(new_id);
			return 1;
		}else {
			return 0;		
		}
	}
	
	/**
	 * 方法名  getUserGuanByID
	 * 输入值  int user_id
	 * 返回值  ArrayList<User> list
	 * 去数据库中根据用户id找到所有这个用户关注的人
	 * 注意，如果没有返回的是一个空的ArrayList,而不是null
	 * */
	public ArrayList<News> getFavoriteByID(int user_id){
		ArrayList<News> list = new ArrayList<>();

		ArrayList<Integer> li  =  favoriteDao.getNewsIdListByUserId(user_id);
		for(int i=0;i<li.size();i++) {
			News n= newsDao.getNewsByID(li.get(i));
			list.add(n);
		}
		return list;
	}
	
	
}
