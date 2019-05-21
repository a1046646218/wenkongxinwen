package neu.edu.service;

import neu.edu.dao.NewsDao;
import neu.edu.dao.NewsLikeDao;
import neu.edu.dao.impl.NewsDaoImpl;
import neu.edu.dao.impl.NewsLikeDaoImpl;

public class ForLikeService {
	
	private NewsLikeDao newsLikeDao = new NewsLikeDaoImpl();
	private NewsDao newsDao = new NewsDaoImpl();
	/**
	 * ������ ��isLikeNews(int new_id,int user_id)
	 *����   int new_id,int user_id 
	 * ���   flag int 
	 * �ж��Ƿ�user_id ���û�������new_id������
	 * �ղ��˷���1��û���򷵻�0
	 * */
	public int isLikeNews(int new_id,int user_id) {
		int a = newsLikeDao.isLikeNews(new_id,user_id);
		return a;
	}
	
	/**
	 * ��������add addLikeNews(int new_id,int user_id)
	 * ����   int new_id,int user_id
	 * ���   flag int 
	 * ��user_id ���û�������new_id�����ţ��������ݿ���С�
	 * �������ű� ���ŵı��newslike�ı�
	 * ���֮ǰ�ղ��˷���0  ����ղ��򷵻�1
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
