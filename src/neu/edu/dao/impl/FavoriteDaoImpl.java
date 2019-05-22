package neu.edu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import neu.edu.dao.FavoriteDao;
import neu.edu.dbutil.BaseDao;

public class FavoriteDaoImpl  implements FavoriteDao{

	/**
	 * ʵ����neu.edu.dao���µ�FavoriteDao�ӿ�
	 * ����һ��user_id�����ɷ���favorite����������ص�news_id��ֵ
	 * ����һ��ArrayList
	 * @param user_id
	 * @return
	 */
	@Override
	public ArrayList<Integer> getNewsIdListByUserId(int user_id) {
		BaseDao aa = new BaseDao();
		String sql = "select newsId from favorite where userId = ?";
		Object[] param = new Object[] {user_id};
		ResultSet rs = aa.executeSelect(sql, param);
		ArrayList<Integer> newsIdList = new ArrayList<>();
		try {
			while(rs.next()) {
				newsIdList.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			aa.closeAll(aa.con, aa.pst, aa.rs);
		}
		return newsIdList;
	}
	
	/**
	 * ���ݴ����new_id������id����user_id���û�id�����ڱ�favorite����һ���ղع�ϵ��¼
	 * ���ɹ�����1  ʧ�ܷ���0
	 * @param new_id
	 * @param user_id
	 * @return
	 */
	@Override
	public int addFavorite(int new_id, int user_id) {
		BaseDao aa = new BaseDao();
		String sql = "insert into favorite (userId,newsId)values(?,?)";
		int res = aa.executeIUD(sql,new Object[] {user_id,new_id});
		return res;	
	}
	
	/**
	 * ͨ��user_id��user_id ��favorite�����ҳ��Ƿ���ƥ����
	 * �еĻ����� 1   û�еĻ�����0 sql�쳣ʱҲ����0
	 * @param new_id
	 * @param user_id
	 */
	@Override
	public int isFavoriteNews(int new_id, int user_id) {
		BaseDao aa = new BaseDao();
		String sql = "Select *from favorite where userId=? and newsId=?";
		ResultSet res = aa.executeSelect(sql, new Object[] {user_id,new_id});
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

}
