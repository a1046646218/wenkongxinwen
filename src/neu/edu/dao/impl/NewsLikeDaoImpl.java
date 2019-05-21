package neu.edu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import neu.edu.dao.NewsLikeDao;
import neu.edu.dbutil.BaseDao;

public class NewsLikeDaoImpl implements NewsLikeDao {


	
	/**
	 * ���ݴ����new_id(����id)��user_id���û�id���ڱ��в���һ���û��������ŵĵ��޼�¼
	 * ���ɹ�����1 ʧ�ܷ���0
	 * @param new_id
	 * @param user_id
	 * @return
	 */
	@Override
	public int addNewsLike(int new_id, int user_id) {
		BaseDao aa = new BaseDao();
		String sql = "insert into newslike(userId,newsId)values(?,?)";
		int res = aa.executeIUD(sql,new Object[] {user_id,new_id});
		return res;
	}
	
	/**
	 * �ú��������ж��û��Ƿ��ĳ�����ŵ�����
	 * ����new_id �� user_id ��newslike�������Ƿ���ƥ����
	 * �еĻ� ����1 ��û�еĻ�����0 ��sql�쳣Ҳ����0
	 * @param new_id
	 * @param user_id
	 */
	@Override
	public int isLikeNews(int new_id, int user_id) {
		BaseDao aa = new BaseDao();
		String sql = "Select *from newslike where userId=? and newsId=?";
		ResultSet res = aa.executeSelect(sql, new Object[] {user_id,new_id});
		try {
			if(res.next()) return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			aa.closeAll(aa.con, aa.pst, aa.rs);
		}
		return 0;
	}

}
