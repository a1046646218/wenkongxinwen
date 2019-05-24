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
	 * 实现了neu.edu.dao包下的NewsDao接口
	 * 根据新闻的类型newsType,和当前页面的新闻数newsIndex,从数据库news表中选出数据
	 * 封装成news对象，放入arrayList里
	 * @param newsType
	 * @param newsIndex
	 * @return 
	 */
	@Override
	public ArrayList<News> searchNewsList(String newsType, int newsIndex) {
		//编写sql语句以及要传递的参数
		String sql = "select * from news where type=? limit ?,?";
		Object[] params = new Object[] {newsType,newsIndex,newsIndex+10};
		

		ArrayList<News> newsList = getNewsList(sql,params);
		return newsList;
	}
	
	/**
	 * 实现了neu.edu.dao包下的NewsDao接口
	 * 传入一个存有数个newsId的ArrayList,从数据库news表中找到与newsId对应的数据
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
	 * 根据传入的new_id（新闻ID）,找到news表中对应的行数，在该行将favorite值+1
	 * 若成功返回1 失败返回0
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
	 * 根据传入的new_id（新闻ID）,找到news表中对应的行数，在该行将likes值+1
	 * 若成功返回1 失败返回0
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
	 * 根据下列参数,在news表中插入一条新闻记录
	 * 成功返回1 失败返回0
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
	 * 传入一个news对象,根据对象的成员属性，在news表中增加一条新闻记录
	 * 成功返回1 失败返回0
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
	 * 根据传入的user_id，找到所有该用户发布的新闻
	 * 传入user_id，从news表中所有匹配的行，将匹配的行读入内存用news对象封装好，再装入ArrayList中返回
	 * 成功返回有news对象的ArrayList 失败返回没有news对象的ArrayList
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
	 * 根据new_id 从表news中找到唯一的匹配行，将其封装成news对象返回
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
	 * 可重用的代码，用于将查找并将匹配的所有结果行封装成一个个的news对象并装入ArrayList返回
	 * @param sql
	 * @param params
	 * @return
	 */
	private ArrayList<News> getNewsList(String sql,Object[] params) {
		BaseDao aa = new BaseDao();
		ArrayList<News> newsList = new ArrayList<>();
			//发送sql语句,得到查询的结果集
			ResultSet rs = aa.executeSelect(sql, params);
			try {
				//循环结果集，如果下一个不为空,生成一个news对象并add进入ArrayList中
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
				//关闭jdbc连接
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
		String strsql= "SELECT * FROM 表名 WHERE name LIKE '%?%'";
		Object[] params = new Object[] {newsType};
		ArrayList<News> newsList = getNewsList(strsql,params);
		return newsList;
	}
}
