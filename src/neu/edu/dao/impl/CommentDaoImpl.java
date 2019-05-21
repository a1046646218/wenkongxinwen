package neu.edu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import neu.edu.dao.CommentDao;
import neu.edu.dbutil.BaseDao;
import neu.edu.entity.Comment;

/**
 * ʵ����CommentDao
 * @author mr.H
 *2019-5-21 9:56
 */
public class CommentDaoImpl  implements CommentDao{
	
	/**
	 * ����insert into���,��comment�����еĳ�Ա���Բ��뵽comment����
	 * ����ֵ�ǲ����¼������,�������ɹ�,����1�����򷵻�0
	 * @param co ����һ��һ�����۶���
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
	 * ��comment��������commentId��ȵ�������ʹ���е�likesֵ+1
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
	 * ����new_id������id����comment���У��ҵ�������new_idƥ�������
	 * ���������ݶ�ȡ���ڴ��з�װ��comment�����������ArrayList�з���
	 * @param new_id
	 */
	@Override
	public ArrayList<Comment> getCommentListByNewId(int new_id) {

		String sql = "Select *from comment where newsId = ?";
		
		ArrayList<Comment> list = getCommentList(sql,new_id);
		return list;
	}

	/**
	 * ����user_id���û�id����comment���У��ҵ�������user_idƥ�������
	 * ���������ݶ�ȡ���ڴ��з�װ��comment�����������ArrayList�з���
	 * @param user_id
	 */
	@Override
	public ArrayList<Comment> getCommentListByUserId(int user_id) {
		String sql = "Select *from comment where userId = ?";
		
		ArrayList<Comment> list = getCommentList(sql, user_id);
		return list;
	}
	
	/**
	 * ִ��sql��䣬�����ݿ��ж�ȡ���������������У���ÿ�����ݷ�װ��comment��װ��ArrayList����
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
