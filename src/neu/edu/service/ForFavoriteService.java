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
	 * ������ ��isFavoriteNews(int new_id,int user_id)
	 *����   int new_id,int user_id 
	 * ���   flag int 
	 * �ж��Ƿ�user_id ���û��ղ���new_id������
	 * �ղ��˷���1��û���򷵻�0
	 * */
	public int isFavoriteNews(int new_id,int user_id) {
		
		int a = favoriteDao.isFavoriteNews(new_id,user_id);
		return a;
	}
	/**
	 * ��������add FavoriteNews(int new_id,int user_id)
	 * ����   int new_id,int user_id
	 * ���   flag int 
	 * ��user_id ���û��ղ���new_id�����ţ��������ݿ���С�
	 * �������ű� ���ŵı��favorite�ı�
	 * ���֮ǰ�ղ��˷���0  ����ղ��򷵻�1
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
	 * ������  getUserGuanByID
	 * ����ֵ  int user_id
	 * ����ֵ  ArrayList<User> list
	 * ȥ���ݿ��и����û�id�ҵ���������û���ע����
	 * ע�⣬���û�з��ص���һ���յ�ArrayList,������null
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
