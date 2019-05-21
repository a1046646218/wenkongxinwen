package neu.edu.dao;

public interface CommentLikeDao {
	

	public int addCommentLike(int user_id, int comment_id);
	
	public int isUpVoted(int user_id, int comment_id) ;
}
