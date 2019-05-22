package neu.edu.service;

import neu.edu.dao.CommentDao;
import neu.edu.dao.ReviewDao;
import neu.edu.dao.impl.CommentDaoImpl;
import neu.edu.dao.impl.ReviewDaoImpl;
import neu.edu.entity.Review;

public class AddReviewService {
	
	private ReviewDao reviewDao = new ReviewDaoImpl();
	private CommentDao commentDao = new CommentDaoImpl();
	/**
	 * 传入一个review对象,调用reviewDao访问数据库，增加review表中的记录
	 * 如果成功插入，返回1 否则，返回0
	 * @param review
	 * @return
	 */
	public int addReview(Review review) {
		int a = reviewDao.addReview(review);
		if(a!=0) {
			commentDao.addNumOfReviewsToComment(review.getCommentId());
			return a;
		}else
			return 0;
	}
}
