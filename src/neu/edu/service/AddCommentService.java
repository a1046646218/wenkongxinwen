package neu.edu.service;

import neu.edu.entity.Comment;
import neu.edu.dao.CommentDao;
import neu.edu.dao.impl.CommentDaoImpl;

public class AddCommentService {
	
	private CommentDao CommentDao = new CommentDaoImpl();
	
	/**
	 * 将comment对象作为参数,调用CommentDao访问数据库，增加数据库中的一级评论记录
	 * 返回值是插入记录的行数,如果插入成功,返回1，否则返回0
	 * @param co
	 * @return
	 */
	public int addComment(Comment co) {
		return CommentDao.addComment(co);
	}
}
