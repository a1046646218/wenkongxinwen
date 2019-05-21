package neu.edu.dao;

import java.util.ArrayList;

import neu.edu.entity.Review;

public interface ReviewDao {
	
	/**
	 * ����һ��review����,����review���еļ�¼
	 * ����ɹ����룬����1 ���򣬷���0
	 * @param review
	 * @return
	 */
	public int addReview(Review review);
	
	public Review getReviewById(int reviewId);
	public ArrayList<Review> getReviewsListByNewId(int commentId);
}	
