package neu.edu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import neu.edu.dao.FavoriteDao;
import neu.edu.dbutil.BaseDao;

public class FavoriteDaoImpl  implements FavoriteDao{

	/**
	 * 实现了neu.edu.dao包下的FavoriteDao接口
	 * 传入一个user_id，即可返回favorite表中与它相关的news_id的值
	 * 返回一个ArrayList
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
	 * 根据传入的new_id（新闻id）和user_id（用户id），在表favorite增加一行收藏关系记录
	 * 若成功返回1  失败返回0
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
	 * 通过user_id和user_id 从favorite表中找出是否有匹配行
	 * 有的话返回 1   没有的话返回0 sql异常时也返回0
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
