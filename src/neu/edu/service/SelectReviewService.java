package neu.edu.service;

import java.util.ArrayList;

import neu.edu.dao.CommentDao;
import neu.edu.dao.ReviewDao;
import neu.edu.dao.impl.CommentDaoImpl;
import neu.edu.dao.impl.ReviewDaoImpl;
import neu.edu.entity.Comment;
import neu.edu.entity.Review;

public class SelectReviewService {
	private CommentDao commentDao = new CommentDaoImpl();
	private ReviewDao reviewDao = new ReviewDaoImpl();
	
	public ArrayList<Review> selectReview(int user_id) {
		ArrayList<Review> list = new ArrayList<>();
		ArrayList<Comment> commentList = commentDao.getCommentListByUserId(user_id);
		for(Comment comment : commentList) {
			int commentId = comment.getCommentId();
			ArrayList<Review> reviewList = reviewDao.getReviewsListByCommentId(commentId,user_id);
			for(Review review : reviewList) {
				list.add(review);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		SelectReviewService selectReviewService = new SelectReviewService();
		ArrayList<Review> list = selectReviewService.selectReview(8);
		for(Review review : list)
			System.out.println(review);
		
	}
}
