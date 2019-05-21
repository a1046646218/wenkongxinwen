package neu.edu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import neu.edu.dao.CommentLikeDao;
import neu.edu.dbutil.BaseDao;

/**
 * ��CommentLike����ص�Daoʵ����
 * @author mr.H
 *
 */
public class CommentLikeDaoImpl implements CommentLikeDao {

	
	
	/**
	 * ͨ��user_id�û�id����comment_id����id,�ڱ�commentLike�в�����޼�¼
	 * @param user_id
	 * @param comment_id
	 * @return
	 */
	@Override
	public int addCommentLike(int user_id, int comment_id) {
		BaseDao aa = new BaseDao();
		String sql = "insert into commentlike (userId,commentId) values(?,?)";
		int res = aa.executeIUD(sql,new Object[] {user_id,comment_id});
		return res;
	}

	/**
	 * ����user_id��comment_id�� commentlike�����ҳ��Ƿ���ƥ����
	 * ����з���1  û�з���0 ������sql�쳣Ҳ����0
	 * @param user_id
	 * @param comment_id
	 */
	@Override
	public int isUpVoted(int user_id, int comment_id) {
		BaseDao aa = new BaseDao();
		String sql = "Select *from commentlike where userId=? and commentId=?";
		ResultSet res = aa.executeSelect(sql, new Object[] {user_id,comment_id});
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
