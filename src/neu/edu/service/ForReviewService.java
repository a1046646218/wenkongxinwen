package neu.edu.service;

import neu.edu.dao.ReviewDao;
import neu.edu.dao.impl.ReviewDaoImpl;
import neu.edu.entity.Review;

public class ForReviewService {
	private ReviewDao da = new  ReviewDaoImpl();
	/**
	 * 
	 * 根据输入的reviewid找到这个review
	 * 
	 * */
	public Review getReviewById(int review_id) {
		return da.getReviewById(review_id);
	}
}
