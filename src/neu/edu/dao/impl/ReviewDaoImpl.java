package neu.edu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import neu.edu.dao.ReviewDao;
import neu.edu.dbutil.BaseDao;
import neu.edu.entity.Review;

public class ReviewDaoImpl  implements ReviewDao {
	

	
	/**
	 * ��Review�����еĳ�Ա���Բ������ݿ��review����
	 * @param review ����һ���������۶���
	 * @return
	 */
	@Override
	public int addReview(Review review) {
		BaseDao aa = new BaseDao();
		String sql = "insert into review values(?,?,?,?,?,?)";
		Object[] params = new Object[] {review.getCommentId(),review.getCommentId(),review.getUserId()
				,review.getContent(),review.getRemarkstr(),review.getNickName()};
		return aa.executeIUD(sql, params);
	}
	
	/**
	 * ����commentId ��review�����ҳ�����ƥ�����
	 * ��ÿ��ƥ���з�װ��review���󣬲�������review����װ��ArrayList����
	 * @param commentId
	 */
	@Override
	public ArrayList<Review> getReviewsListByNewId(int commentId) {
		BaseDao aa = new BaseDao();
		String sql = "Select *from review where commentId = ?";
		ResultSet res = aa.executeSelect(sql, new Object[] {commentId});
		ArrayList<Review> list = new ArrayList<>();
		Review t = null;
		try {
			while(res.next()) {
				int reviewId = res.getInt(1);
				int commentId1 = res.getInt(2);
				int userId = res.getInt(3);
				String content = res.getString(4);
				String remarkstr = res.getString(5);
				String NickName = res.getString(6);

				t = new Review(reviewId,commentId1,userId, content, remarkstr,NickName);
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	/**
	 * 
	 * ����reviewid��ȡ��review
	 * 
	 * 
	 * **/
	@Override
	public Review getReviewById(int review_Id) {
		BaseDao aa = new BaseDao();
		String sql = "Select *from review where reviewId = ?";
		ResultSet res = aa.executeSelect(sql, new Object[] {review_Id});
		Review t = null;
		try {
			if(res.next()) {
				int reviewId = res.getInt(1);
				int commentId1 = res.getInt(2);
				int userId = res.getInt(3);
				String content = res.getString(4);
				String remarkstr = res.getString(5);
				String NickName = res.getString(6);
				t = new Review(reviewId,commentId1,userId, content, remarkstr,NickName);
			}
		} catch (SQLException e) {
		}
		return t;
	}

}
