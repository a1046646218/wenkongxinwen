package neu.edu.service;

import neu.edu.dao.CommentDao;
import neu.edu.dao.CommentLikeDao;
import neu.edu.dao.impl.CommentDaoImpl;
import neu.edu.dao.impl.CommentLikeDaoImpl;

public class FordianzanCommentService {
	
	private CommentLikeDao commentLikeDao = new CommentLikeDaoImpl();
	private CommentDao commentDao = new CommentDaoImpl();
	/**
	 * 方法名  dianzanComment
	 * 输入   user_id   int ,comment_id   int
	 * 返回值 int  flag
	 * 首先去数据库中查找user_id是否给comment_id的评论点赞了(是否有这条数据)   dao
	 * 如果有就插入点赞
	 * 成功点赞返回1 失败0
	 * */
	public int isUpVoted(int user_id, int comment_id) {
		int a = commentLikeDao.isUpVoted(user_id, comment_id);
		return a;
	}
	/**
	 * 方法名  adddianzanComment
	 * 输入   user_id   int ,comment_id   int
	 * 返回值 int  flag
	 * 让user_id给comment_id的评论点赞插入数据库表中
	 * 更新两张表 comment和commentlike的表
	 * 如果之前点赞了返回0  这次点赞则返回1
	 **/
	public int addDianzanComment(int user_id, int comment_id) {
		int a = commentLikeDao.isUpVoted(user_id, comment_id);
		if(a==0) {
			commentLikeDao.addCommentLike(user_id,comment_id);
			commentDao.addNumOfLiketoComment(comment_id);
			return 1;
		}else {
			return 0;		
		}
	}
}
