package neu.edu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import neu.edu.dao.SensibleDao;
import neu.edu.dbutil.BaseDao;
import neu.edu.entity.Sence;

public class SensibleDaolmpl implements SensibleDao{

	@Override
	public int addSence(Sence se) {
		BaseDao aa = new BaseDao();
		String sql = "insert into sensible (content,sencecontent,userId,nickName,iscomment,relativeid)"
				+ " values(?,?,?,?,?,?)";
		int bb =  aa.executeIUD(sql,new Object[] {se.getContent(),se.getSencecontent(),se.getUserId(),se.getNickName(),se.getIscomment(),se.getRelativeid()});	
		return bb;
	}

	@Override
	public int downvip(int userid) {
		BaseDao aa = new BaseDao();
		Object[] params =new Object[]{userid};
		int a = aa.executeIUD("update user set vip=vip-1 where userId=?",params);
		return a;
	}

	@Override
	public int upvip(int userid) {
		BaseDao aa = new BaseDao();
		Object[] params =new Object[]{userid};
		int a = aa.executeIUD("update user set vip=vip+1 where userId=?",params);
		return a;
	}

	@Override
	public int deleteSence(int senceId) {
		BaseDao aa = new BaseDao();
		String sql = "delete from sensible where senceId = ?";
		Object[] params = new Object[] {senceId};
		int a = aa.executeIUD(sql, params);
		return a;
	}

	@Override
	public ArrayList<Sence> findSenceByUserId(int userId) {
	
		String sql = "select * from sensible where userId = ?";
		ArrayList<Sence> list = selectSence(sql,userId);
		return list;
		
	}
	
	private ArrayList<Sence> selectSence(String sql,Object... params) {
		BaseDao aa = new BaseDao();
		ResultSet rs =  aa.executeSelect(sql, params);
		ArrayList<Sence> list = new ArrayList<Sence>();
		try {
			
			while(rs.next()) {
				Sence sence = new Sence();
				sence.setSenceid(rs.getInt(1));
				sence.setContent(rs.getString(2));
				sence.setSencecontent(rs.getString(3));
				sence.setUserId(rs.getInt(4));
				sence.setNickName(rs.getString(5));
				sence.setIscomment(rs.getInt(6));
				sence.setRelativeid(rs.getInt(7));
				list.add(sence);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	

}
