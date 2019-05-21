package neu.edu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import neu.edu.dao.FollowingDao;
import neu.edu.dbutil.BaseDao;

public class FollowingDaoImpl implements FollowingDao{
	
	
	/**
	 * ����user_id����following�����ҳ�����ƥ��������
	 * �����е�followerIdֵ����
	 * @param user_id
	 */
	@Override
	public ArrayList<Integer> getFollowersByID(int user_id) {
		String sql = "Select *from following where followingId=? ";
		return selectUserId(user_id,sql,2);
	}
	
	/**
	 * ����user_id����following�����ҳ�����ƥ�����
	 * �����е�followingId����
	 * @param user_id
	 */
	@Override
	public ArrayList<Integer> getFollowingByID(int user_id) {
		String sql = "Select *from following where followerId=? ";
		return selectUserId(user_id,sql,1);
	}
	
	/**
	 * ����user_id,��sql��䣬��following�����ҵ�ƥ�����
	 * �����еĵ�col��ֵ����
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
	 * �ú��������ڱ�following������һ����˿��ע��¼
	 * ��followingId��followerId�����following��
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
	 * �ú��������ж������û��Ƿ��ǹ�ע���뱻��ע�ߵĹ�ϵ
	 * ��followingId��followerId�ڱ�following��ƥ�� ���ҳ��Ƿ���ƥ����
	 * ����� ����1		û�� ����0    sql�쳣���� 0
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
	 * �ú�������ɾ��following���еĹ�ע��¼��
	 * ����followingId��followerId����following�����ҵ�ƥ���У���ɾ��
	 * ɾ���ɹ�����1 	ɾ��ʧ�ܷ���0
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
