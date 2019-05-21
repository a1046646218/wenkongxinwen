package neu.edu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import neu.edu.dao.FollowingDao;
import neu.edu.dbutil.BaseDao;

public class FollowingDaoImpl implements FollowingDao{
	
	
	/**
	 * 传入user_id，从following表中找出所有匹配它的行
	 * 将该行的followerId值返回
	 * @param user_id
	 */
	@Override
	public ArrayList<Integer> getFollowersByID(int user_id) {
		String sql = "Select *from following where followingId=? ";
		return selectUserId(user_id,sql,2);
	}
	
	/**
	 * 传入user_id，从following表中找出所有匹配的行
	 * 将该行的followingId返回
	 * @param user_id
	 */
	@Override
	public ArrayList<Integer> getFollowingByID(int user_id) {
		String sql = "Select *from following where followerId=? ";
		return selectUserId(user_id,sql,1);
	}
	
	/**
	 * 传入user_id,和sql语句，从following表中找到匹配的行
	 * 将该行的第col个值返回
	 * @param user_id
	 * @param sql
	 * @param col
	 * @return
	 */
	private ArrayList<Integer> selectUserId(int user_id,String sql,int col){
		BaseDao aa = new BaseDao();
		ResultSet bb =  aa.executeSelect(sql,new Object[] {user_id});
		ArrayList<Integer> p = new ArrayList<Integer>();
		try {
			while(bb.next()) {
				p.add(bb.getInt(col));
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	/**
	 * 该函数用于在表following中增加一条粉丝关注记录
	 * 将followingId和followerId插入表following中
	 * @param followingId
	 * @param followerId
	 */
	@Override
	public int addFollowing(int followingId, int followerId) {
		BaseDao aa = new BaseDao();
		Object[] params =new Object[]{followingId, followerId};
		int a = aa.executeIUD("insert into following(followingId,followerId)values(?,?)", params);
		return a;
	}
	
	/**
	 * 该函数用于判断两个用户是否是关注者与被关注者的关系
	 * 将followingId和followerId在表following中匹配 ，找出是否有匹配行
	 * 如果有 返回1		没有 返回0    sql异常返回 0
	 * @param followingId
	 * @param followerId
	 */
	@Override
	public int isFollowing(int followingId, int followerId) {
		BaseDao aa = new BaseDao();
		String sql = "Select *from following where followingId=? and followerId=?";
		ResultSet res = aa.executeSelect(sql, new Object[] { followingId,followerId});
		try {
			if(res.next()) return 1;
			else return 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			aa.closeAll(aa.con, aa.pst, aa.rs);
		}
		return 0;
	}
	
	/**
	 * 该函数用于删除following表中的关注记录行
	 * 根据followingId和followerId，从following表中找到匹配行，并删除
	 * 删除成功返回1 	删除失败返回0
	 * @param followingId
	 * @param followerId
	 */
	@Override
	public int removeFollowing(int followingId, int followerId) {
		BaseDao aa = new BaseDao();
		Object[] params =new Object[]{followingId, followerId};
		int a = aa.executeIUD("delete from following where followingId=? and followerId=?", params);
		return a;
	}

}
