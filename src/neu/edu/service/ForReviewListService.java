package neu.edu.service;

import java.util.ArrayList;


import neu.edu.dao.ReviewDao;
import neu.edu.dao.impl.ReviewDaoImpl;
import neu.edu.entity.Review;

public class ForReviewListService {

	private ReviewDao reviewDao = new ReviewDaoImpl();
	/**
	 * 方法名  getreviewsListByNewId
	 * 输入  int commentId
	 * 返回值 ArrayList<review>
	 * 去数据库中根据评论id找到所有二级评论
	 * 注意，如果没有，返回的是一个空的ArrayList,而不是null
	 * */
	public ArrayList<Review> getreviewsListByNewId(int commentId){
		ArrayList<Review> list = new ArrayList<>();
		list = reviewDao.getReviewsListByNewId(commentId);
		return list;
		
	}
}
