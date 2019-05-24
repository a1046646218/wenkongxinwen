package neu.edu.dao;

import java.util.ArrayList;

import neu.edu.entity.Comment;


/**
 * 与Comment表相关的Dao接口
 * @author mr.H
 *
 */
public interface CommentDao {
	
	public int addComment(Comment co);
	
	public int addNumOfLiketoComment(int commentId);
	
	public ArrayList<Comment> getCommentListByNewId(int new_id);
	
	public ArrayList<Comment> getCommentListByUserId(int user_id);
	
	public int addNumOfReviewsToComment(int comment_id);
	
	public ArrayList<Comment> getCommentListByNewId(int newsId, int user_id);
}