package neu.edu.dao;

import java.util.ArrayList;

import neu.edu.entity.News;



public interface NewsDao {
	
	/**
	 * �������ŵ�����newsType,�͵�ǰҳ���������newsIndex,�����ݿ�news����ѡ������
	 * ��װ��news���󣬷���arrayList��
	 * @param newsType
	 * @param newsIndex
	 * @return 
	 */
	public ArrayList<News> searchNewsList(String newsType,int newsIndex);
	
	/**
	 * ����һ����������newsId��ArrayList,�����ݿ�news�����ҵ���newsId��Ӧ������
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
