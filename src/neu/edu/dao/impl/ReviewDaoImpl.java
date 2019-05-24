package neu.edu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import neu.edu.dao.ReviewDao;
import neu.edu.dbutil.BaseDao;
import neu.edu.entity.Review;

public class ReviewDaoImpl  implements ReviewDao {
	

	
	/**
	 * 将Review对象中的成员属性插入数据库的review表中
	 * @param review 它是一个二级评论对象
	 * @return
	 */
	@Override
	public int addReview(Review review) {
		BaseDao aa = new BaseDao();
		String sql = "insert into review(commentId,userId,content,remarkStr,nickName) values(?,?,?,?,?)";
		Object[] params = new Object[] {review.getCommentId(),review.getUserId()
				,review.getContent(),review.getRemarkstr(),review.getNickName()};
		ResultSet rs = null;
		int  increasenum = 0;
		try {
			Connection conn = aa.getCon();
			System.out.println(conn);
			PreparedStatement st;
			st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			if (null!=params) {
				for (int i = 0; i <params.length; i++) {
					st.setObject(i+1, params[i]);//为sql中的每一个?赋值
				}
			}
			st.executeUpdate();
			rs = st.getGeneratedKeys(); //获取自动增加主键
			if(rs.next()) {
					increasenum=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return increasenum;
	}
	
	/**
	 * 根据commentId 从review表中找出所有匹配的行
	 * 将每个匹配行封装成review对象，并将所有review对象装入ArrayList返回
	 * @param commentId
	 */
	@Override
	public ArrayList<Review> getReviewsListByCommentId(int commentId) {
		String sql = "Select *from review where commentId = ?";
		ArrayList<Review> list = getReviewsList(sql,commentId);
		return list;
	}
	/**
	 * 
	 * 根据reviewid获取到review
	 * 沒有找到的話返回null
	 * 
	 * **/
	@Override
	public Review getReviewById(int review_Id) {
		String sql = "Select *from review where reviewId = ?";
		ArrayList<Review> list = getReviewsList(sql,review_Id);
		Review review = null;
		if(!list.isEmpty()) {
			review = list.get(0);
		}
		return review;
	}

	@Override
	public ArrayList<Review> getReviewsListByCommentId(int commentId, int userId) {
		String sql = "Select * from review where commentId = ? and userId != ?";
		ArrayList<Review> list = getReviewsList(sql,commentId,userId);
		return list;
	}
	
	/**
	 * 複用代碼
	 * @param sql
	 * @param params
	 * @return
	 */
	private  ArrayList<Review> getReviewsList(String sql,Object... params ){
		BaseDao aa = new BaseDao();
		ResultSet res = aa.executeSelect(sql,params);
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
		}finally {
			aa.closeAll(aa.con, aa.pst, aa.rs);
		}
		
		return list;
	}


}
