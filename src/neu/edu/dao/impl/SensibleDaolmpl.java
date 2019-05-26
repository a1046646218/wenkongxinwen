package neu.edu.dao.impl;

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

}
