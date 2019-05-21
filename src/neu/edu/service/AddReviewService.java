package neu.edu.service;

import neu.edu.dao.ReviewDao;
import neu.edu.dao.impl.ReviewDaoImpl;
import neu.edu.entity.Review;

public class AddReviewService {
	
	private ReviewDao reviewDao = new ReviewDaoImpl();
	
	/**
	 * ����һ��review����,����reviewDao�������ݿ⣬����review���еļ�¼
	 * ����ɹ����룬����1 ���򣬷���0
	 * @param review
	 * @return
	 */
	public int addReview(Review review) {
		return reviewDao.addReview(review);
	}
}
