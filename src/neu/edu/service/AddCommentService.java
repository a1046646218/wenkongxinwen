package neu.edu.service;

import neu.edu.entity.Comment;
import neu.edu.dao.CommentDao;
import neu.edu.dao.impl.CommentDaoImpl;

public class AddCommentService {
	
	private CommentDao CommentDao = new CommentDaoImpl();
	
	/**
	 * ��comment������Ϊ����,����CommentDao�������ݿ⣬�������ݿ��е�һ�����ۼ�¼
	 * ����ֵ�ǲ����¼������,�������ɹ�,����1�����򷵻�0
	 * @param co
	 * @return
	 */
	public int addComment(Comment co) {
		return CommentDao.addComment(co);
	}
}
