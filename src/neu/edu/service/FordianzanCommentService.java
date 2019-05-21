package neu.edu.service;

import neu.edu.dao.CommentDao;
import neu.edu.dao.CommentLikeDao;
import neu.edu.dao.impl.CommentDaoImpl;
import neu.edu.dao.impl.CommentLikeDaoImpl;

public class FordianzanCommentService {
	
	private CommentLikeDao commentLikeDao = new CommentLikeDaoImpl();
	private CommentDao commentDao = new CommentDaoImpl();
	/**
	 * ������  dianzanComment
	 * ����   user_id   int ,comment_id   int
	 * ����ֵ int  flag
	 * ����ȥ���ݿ��в���user_id�Ƿ��comment_id�����۵�����(�Ƿ�����������)   dao
	 * ����оͲ������
	 * �ɹ����޷���1 ʧ��0
	 * */
	public int isUpVoted(int user_id, int comment_id) {
		int a = commentLikeDao.isUpVoted(user_id, comment_id);
		return a;
	}
	/**
	 * ������  adddianzanComment
	 * ����   user_id   int ,comment_id   int
	 * ����ֵ int  flag
	 * ��user_id��comment_id�����۵��޲������ݿ����
	 * �������ű� comment��commentlike�ı�
	 * ���֮ǰ�����˷���0  ��ε����򷵻�1
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
