package neu.edu.service;

import neu.edu.entity.Comment;
import neu.edu.dao.CommentDao;
import neu.edu.dao.NewsDao;
import neu.edu.dao.impl.CommentDaoImpl;
import neu.edu.dao.impl.NewsDaoImpl;

public class AddCommentService {
	
	private CommentDao CommentDao = new CommentDaoImpl();
	private NewsDao newsDao = new NewsDaoImpl();
	
	/**
	 * ��comment������Ϊ����,����CommentDao�������ݿ⣬�������ݿ��е�һ�����ۼ�¼
	 * ����ֵ�ǲ����¼������,�������ɹ�,����1�����򷵻�0
	 * @param co
	 * @return
	 */
	public int addComment(Comment co) {
			int b = 0;
			int a =	CommentDao.addComment(co);
			if(a!=0) {
				b =  newsDao.addNumOfCommentstoNews(co.getNewsId());
			}
			if(b!=0) return a; 
			else return 0;
	}
}
