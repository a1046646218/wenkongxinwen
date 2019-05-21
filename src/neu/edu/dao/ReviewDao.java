package neu.edu.dao;

import java.util.ArrayList;

import neu.edu.entity.Review;

public interface ReviewDao {
	
	/**
	 * 传入一个review对象,增加review表中的记录
	 * 如果成功插入，返回1 否则，返回0
	 * @param review
	 * @return
	 */
	public int addReview(Review review);
	
	public Review getReviewById(int reviewId);
	public ArrayList<Review> getReviewsListByNewId(int commentId);
}	
