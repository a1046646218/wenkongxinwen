package neu.edu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import neu.edu.dao.CommentDao;
import neu.edu.dbutil.BaseDao;
import neu.edu.entity.Comment;

/**
 * 实现了CommentDao
 * @author mr.H
 *2019-5-21 9:56
 */
public class CommentDaoImpl  implements CommentDao{
	
	/**
	 * 调用insert into语句,将comment对象中的成员属性插入到comment表中
	 * 返回值是插入记录的行数,如果插入成功,返回1，否则返回0
	 * @param co 这是一个一级评论对象
	 */
	@Override
	public int addComment(Comment co) {
		BaseDao aa = new BaseDao();
		String sql = "insert into comment(userId,newsId,content,likes,reviews,nickName) values(?,?,?,?,?,?)";
		Object[] obj = new Object[] {co.getUserId(),co.getNewsId()
			,co.getContent(),co.getLikes(),co.getReviews(),co.getNickName()};
		int res = aa.executeIUD(sql, obj);
		return res;

	}
	
	/**
	 * 对comment表中满足commentId相等的行数，使该行的likes值+1
	 * @param commentId
	 */
	@Override
	public int addNumOfLiketoComment(int commentId) {
		BaseDao aa = new BaseDao();
		String sql = "update comment set likes=likes+1 where commentId=?";
		int res = aa.executeIUD(sql, new Object[] {commentId});
		return res;
	}
	
	/**
	 * 传入new_id（新闻id）从comment表中，找到所有与new_id匹配的行数
	 * 将该行数据读取到内存中封装到comment对象里，最后放入ArrayList中返回
	 * @param new_id
	 */
	@Override
	public ArrayList<Comment> getCommentListByNewId(int new_id) {

		String sql = "Select *from comment where newsId = ?";
		
		ArrayList<Comment> list = getCommentList(sql,new_id);
		return list;
	}

	/**
	 * 传入user_id（用户id）从comment表中，找到所有与user_id匹配的行数
	 * 将该行数据读取到内存中封装到comment对象里，最后放入ArrayList中返回
	 * @param user_id
	 */
	@Override
	public ArrayList<Comment> getCommentListByUserId(int user_id) {
		String sql = "Select *from comment where userId = ?";
		
		ArrayList<Comment> list = getCommentList(sql, user_id);
		return list;
	}
	
	/**
	 * 执行sql语句，从数据库中读取所有满足条件的行，将每行数据封装到comment后装入ArrayList返回
	 * @param res
	 * @return
	 */
	private ArrayList<Comment> getCommentList(String sql,Object... params) {
		BaseDao aa = new BaseDao();
		ResultSet res = aa.executeSelect(sql, params);
		ArrayList<Comment> list = new ArrayList<>();
		Comment t = null;
		try {
			while(res.next()) {
				int commentId = res.getInt(1);
				int userId = res.getInt(2);
				int newsId = res.getInt(3);
				String content = res.getString(4);
				int likes = res.getInt(5);
				int reviews = res.getInt(6);
				String nickName = res.getString(7);
				
				t = new Comment(commentId,userId,newsId,content,likes,reviews,nickName);
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			aa.closeAll(aa.con, aa.pst, aa.rs);
		}
		return list;
	}
	

	@Override
	public int addNumOfReviewsToComment(int comment_id) {
		BaseDao aa = new BaseDao();
		String sql = "update comments set reviews=reviews+1 where commentId=?";
		int res = aa.executeIUD(sql, new Object[] {comment_id});
		return res;
	}
}
