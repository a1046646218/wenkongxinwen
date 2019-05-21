package neu.edu.service;

import neu.edu.dao.NewsDao;
import neu.edu.dao.impl.NewsDaoImpl;
import neu.edu.entity.News;

public class AddNewsService {
	
	private NewsDao da = new NewsDaoImpl();
	/**
	 * ������  addNews
	 * ����    title  String,User_id int,Content string,type string,nickname string,url string
	 * ����ֵ int flag
	 * ����������Ϣ ֮�������ݿ�����ӣ��ɹ�����1 ʧ�ܷ���0
	 * Ĭ�� favoritesΪ0
	 *  LikeΪ0
	 * CommentsΪ0
	 * News_id���Զ�����������
	 * */
	
	public int addNews(String title,int User_id,String Content,String type,String nickname,String url) {
		
		int a = da.addNews(title,User_id,Content,type,nickname,url);	
		return a;
	}
	
	/**
	 * ������  addNews
	 * ����  news����
	 * ����ֵ int flag
	 * ����������Ϣ ֮�������ݿ�����ӣ��ɹ�����1 ʧ�ܷ���0
	 * News_id���Զ�����������
	 * */
	public int addNews(News news) {
		return da.addNews(news);
	}
}
