package neu.edu.service;

import java.util.ArrayList;


import neu.edu.dao.ReviewDao;
import neu.edu.dao.impl.ReviewDaoImpl;
import neu.edu.entity.Review;

public class ForReviewListService {

	private ReviewDao reviewDao = new ReviewDaoImpl();
	/**
	 * ������  getreviewsListByNewId
	 * ����  int commentId
	 * ����ֵ ArrayList<review>
	 * ȥ���ݿ��и�������id�ҵ����ж�������
	 * ע�⣬���û�У����ص���һ���յ�ArrayList,������null
	 * */
	public ArrayList<Review> getreviewsListByNewId(int commentId){
		ArrayList<Review> list = new ArrayList<>();
		list = reviewDao.getReviewsListByNewId(commentId);
		return list;
		
	}
}
