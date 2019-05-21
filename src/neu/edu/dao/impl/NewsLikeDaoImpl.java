package neu.edu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import neu.edu.dao.NewsLikeDao;
import neu.edu.dbutil.BaseDao;

public class NewsLikeDaoImpl implements NewsLikeDao {


	
	/**
	 * 根据传入的new_id(新闻id)和user_id（用户id）在表中插入一条用户对于新闻的点赞记录
	 * 若成功返回1 失败返回0
	 * @param new_id
	 * @param user_id
	 * @return
	 */
	@Override
	public int addNewsLike(int new_id, int user_id) {
		BaseDao aa = new BaseDao();
		String sql = "insert into newslike(userId,newsId)values(?,?)";
		int res = aa.executeIUD(sql,new Object[] {user_id,new_id});
		return res;
	}
	
	/**
	 * 该函数用于判断用户是否对某条新闻点了赞
	 * 根据new_id 和 user_id 从newslike表中找是否有匹配行
	 * 有的话 返回1 ；没有的话返回0 ；sql异常也返回0
	 * @param new_id
	 * @param user_id
	 */
	@Override
	public int isLikeNews(int new_id, int user_id) {
		BaseDao aa = new BaseDao();
		String sql = "Select *from newslike where userId=? and newsId=?";
		ResultSet res = aa.executeSelect(sql, new Object[] {user_id,new_id});
		try {
			if(res.next()) return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			aa.closeAll(aa.con, aa.pst, aa.rs);
		}
		return 0;
	}

}
