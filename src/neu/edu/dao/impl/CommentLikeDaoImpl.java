package neu.edu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import neu.edu.dao.CommentLikeDao;
import neu.edu.dbutil.BaseDao;

/**
 * 与CommentLike表相关的Dao实现类
 * @author mr.H
 *
 */
public class CommentLikeDaoImpl implements CommentLikeDao {

	
	
	/**
	 * 通过user_id用户id，和comment_id评论id,在表commentLike中插入点赞记录
	 * @param user_id
	 * @param comment_id
	 * @return
	 */
	@Override
	public int addCommentLike(int user_id, int comment_id) {
		BaseDao aa = new BaseDao();
		String sql = "insert into commentlike (userId,commentId) values(?,?)";
		int res = aa.executeIUD(sql,new Object[] {user_id,comment_id});
		return res;
	}

	/**
	 * 根据user_id和comment_id从 commentlike表中找出是否有匹配行
	 * 如果有返回1  没有返回0 若爆出sql异常也返回0
	 * @param user_id
	 * @param comment_id
	 */
	@Override
	public int isUpVoted(int user_id, int comment_id) {
		BaseDao aa = new BaseDao();
		String sql = "Select *from commentlike where userId=? and commentId=?";
		ResultSet res = aa.executeSelect(sql, new Object[] {user_id,comment_id});
		try {
			if(res.next()) return 1;
			else return 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			aa.closeAll(aa.con, aa.pst, aa.rs);
		}
		return 0;
	}

}
