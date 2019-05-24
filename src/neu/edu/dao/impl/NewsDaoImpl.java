package neu.edu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import neu.edu.dao.NewsDao;
import neu.edu.dbutil.BaseDao;
import neu.edu.entity.News;


/**
 * 
 * @author mr.H
 *
 */
public class NewsDaoImpl implements NewsDao{
	

	/**
	 * ʵ����neu.edu.dao���µ�NewsDao�ӿ�
	 * �������ŵ�����newsType,�͵�ǰҳ���������newsIndex,�����ݿ�news����ѡ������
	 * ��װ��news���󣬷���arrayList��
	 * @param newsType
	 * @param newsIndex
	 * @return 
	 */
	@Override
	public ArrayList<News> searchNewsList(String newsType, int newsIndex) {
		//��дsql����Լ�Ҫ���ݵĲ���
		String sql = "select * from news where type=? limit ?,?";
		Object[] params = new Object[] {newsType,newsIndex,newsIndex+10};
		

		ArrayList<News> newsList = getNewsList(sql,params);
		return newsList;
	}
	
	/**
	 * ʵ����neu.edu.dao���µ�NewsDao�ӿ�
	 * ����һ����������newsId��ArrayList,�����ݿ�news�����ҵ���newsId��Ӧ������
	 * @param newsIdList
	 * @return
	 */
	@Override
	public ArrayList<News> getNewsList(ArrayList<Integer> newsIdList) {
		 int count = newsIdList.size();
		 ArrayList<News> newsList = new ArrayList<News>();
		 String sql = "select * from news where newsId = ?";
		 for(int i =0;i<count;i++) {
			 Object[] params = new Object[] {newsIdList.get(i)};
			 ArrayList<News> b = getNewsList(sql,params);
			 for(News news : b)
				 newsList.add(news);
		 }
		 return newsList;
	}	
	
	
	/**
	 * ���ݴ����new_id������ID��,�ҵ�news���ж�Ӧ���������ڸ��н�favoriteֵ+1
	 * ���ɹ�����1 ʧ�ܷ���0
	 * @param new_id
	 */
	@Override
	public int addNumOfFavoritetoNews(int new_id) {
		BaseDao aa = new BaseDao();
		String sql = "update news set favorites=favorites+1 where newsId=?";
		int res = aa.executeIUD(sql, new Object[] {new_id});
		return res;
	}
	
	
	
	/**
	 * ���ݴ����new_id������ID��,�ҵ�news���ж�Ӧ���������ڸ��н�likesֵ+1
	 * ���ɹ�����1 ʧ�ܷ���0
	 * @param new_id
	 */
	@Override
	public int addNumOfLiketoNews(int new_id) {
		BaseDao aa = new BaseDao();
		String sql = "update news set likes=likes+1 where newsId=?";
		int res = aa.executeIUD(sql, new Object[] {new_id});
		return res;
	}
	
	/**
	 * �������в���,��news���в���һ�����ż�¼
	 * �ɹ�����1 ʧ�ܷ���0
	 * @param title
	 * @param user_id
	 * @param content
	 * @param type 
	 * @param nickName
	 * @param url
	 * @return
	 */
	@Override
	public int addNews(String title, int user_id, String content, String type, String nickname, String url) {
		BaseDao aa = new BaseDao();
		String sql = "insert into news (title,favorites,userId,likes,content,type,comments,nickName,url)"
				+ " values(?,?,?,?,?,?,?,?,?)";
		int res =  aa.executeIUD(sql,new Object[] {title,0,user_id,0,content,type,0,nickname,url});	
		return res;
	}
	
	/**
	 * ����һ��news����,���ݶ���ĳ�Ա���ԣ���news��������һ�����ż�¼
	 * �ɹ�����1 ʧ�ܷ���0
	 * @param news
	 */
	@Override
	public int addNews(News news) {
		BaseDao aa = new BaseDao();
		String sql = "insert into news (title,favorites,userId,likes,content,type,comments,nickName,url)"
				+ " values(?,?,?,?,?,?,?,?,?)";
		Object[] params = new Object[] {news.getTitile(),news.getFavorites(),news.getUserId(),news.getLike()
				,news.getContent(),news.getType(),news.getComments(),news.getNickname(),news.getUrl()};
		int res =  aa.executeIUD(sql,params);	
		return res;
	}
	
	/**
	 * ���ݴ����user_id���ҵ����и��û�����������
	 * ����user_id����news��������ƥ����У���ƥ����ж����ڴ���news�����װ�ã���װ��ArrayList�з���
	 * �ɹ�������news�����ArrayList ʧ�ܷ���û��news�����ArrayList
	 * @param user_id
	 */
	@Override
	public ArrayList<News> getNewsListByID(int user_id) {

		String sql = "Select *from news where userId=? ";
		Object[] params = new Object[] {user_id};
		
		ArrayList<News> list = getNewsList(sql,params);
		return list;
	}
	
	/**
	 * ����new_id �ӱ�news���ҵ�Ψһ��ƥ���У������װ��news���󷵻�
	 * @param new_id
	 */
	@Override
	public News getNewsByID(int new_id) {

		String sql = "Select *from news where newsId=? ";
		Object[] params = new Object[] {new_id};
		ArrayList<News> newsList = getNewsList(sql,params);
		News p = null;
		if(newsList.size()!=0)
			p = newsList.get(0);
		return p;
	}
	
	/**
	 * �����õĴ��룬���ڽ����Ҳ���ƥ������н���з�װ��һ������news����װ��ArrayList����
	 * @param sql
	 * @param params
	 * @return
	 */
	private ArrayList<News> getNewsList(String sql,Object[] params) {
		BaseDao aa = new BaseDao();
		ArrayList<News> newsList = new ArrayList<>();
			//����sql���,�õ���ѯ�Ľ����
			ResultSet rs = aa.executeSelect(sql, params);
			try {
				//ѭ��������������һ����Ϊ��,����һ��news����add����ArrayList��
				while(rs.next()) {
					News news = new News();
					news.setNewsId(rs.getInt(1));
					news.setTitile(rs.getString(2));
					news.setFavorites(rs.getInt(3));
					news.setUserId(rs.getInt(4));
					news.setLike(rs.getInt(5));
					news.setContent(rs.getString(6));
					news.setType(rs.getString(7));
					news.setComments(rs.getInt(8));
					news.setNickname(rs.getString(9));
					news.setUrl(rs.getString(10));
					newsList.add(news);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				//�ر�jdbc����
				aa.closeAll(aa.con, aa.pst, aa.rs);
			}
		return newsList;
	}

	@Override
	public int addNumOfCommentstoNews(int new_id) {
		BaseDao aa = new BaseDao();
		String sql = "update news set comments=comments+1 where newsId=?";
		int res = aa.executeIUD(sql, new Object[] {new_id});
		return res;
	}

	@Override
	public ArrayList<News> searchNewsListByTitle(String newsType, int newsIndex) {
		BaseDao aa = new BaseDao();
		String strsql= "SELECT * FROM ���� WHERE name LIKE '%?%'";
		Object[] params = new Object[] {newsType};
		ArrayList<News> newsList = getNewsList(strsql,params);
		return newsList;
	}
}
