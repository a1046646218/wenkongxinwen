package neu.edu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import neu.edu.dao.UserDao;
import neu.edu.dbutil.BaseDao;
import neu.edu.entity.User;

public class UserDaoImpl implements UserDao {
	


	/**
	 * �������в�������user��������һ���û���¼
	 * �ɹ�����1 ʧ�ܷ���0
	 * @param username
	 * @param nickname
	 * @param introduction
	 * @param password
	 */
	@Override
	public int addUser(String username, String nickname, String introduction, String password) {
		BaseDao aa = new BaseDao();
		String sql = "insert into user (userName,nickName,followings,followers,introduction,vip,type,Password)"
				+ " values(?,?,?,?,?,?,?,?)";
		int bb =  aa.executeIUD(sql,new Object[] {username,nickname,0,0,introduction,0,0,password});	
		return bb;
	}
	
	/**
	 * ����һ��user������user��������һ���û���¼
	 * �ɹ�����1 ʧ�ܷ���0
	 * @param user
	 */
	@Override
	public int addUser(User user) {
		BaseDao aa = new BaseDao();
		String sql = "insert into user (userName,nickName,followings,followers,introduction,vip,type,Password)"
				+ " values(?,?,?,?,?,?,?,?)";
		int bb =  aa.executeIUD(sql,new Object[] {user.getUserName(),user.getNickName(),user.getFollowings()
				,user.getFollowers(),user.getIntroduction(),user.getVip(),user.getType(),user.getPwd()});	
		return bb;
	}
	
	/**
	 * ����user_id �ӱ�user���ҳ�����Ψһƥ�����
	 * ���������ݷ�װ��user���󷵻�
	 * ���û���ҵ�ƥ���з���null
	 * @param user_id
	 */
	@Override
	public User getUserByUserId(int user_id) {
		
		String sql = "Select *from user where userId=? ";
		return getUser(sql,user_id);
	}
	/**
	 * ����userName��password ��user�����ҵ�Ψһƥ�����
	 * ���������ݷ�װ��user���󷵻�
	 * û���ҵ�ƥ���з���null
	 * @param userName
	 * @param password
	 */
	@Override
	public User getUserBypwdandusername(String userName, String password) {
		
		String sql = "Select *from user where userName=? and password=? ";
		return getUser(sql,userName,password);
	}
	
	/**
	 * ����userName��user�����ҵ�Ψһƥ�����
	 * ���������ݷ�װ��user���󷵻�
	 * û���ҵ�ƥ���з���null
	 * @param userName
	 */
	@Override
	public User getUserByusername(String userName) {
		
		String sql = "Select *from user where userName=? ";
		return getUser(sql,userName);
	}
	
	/**
	 * ���� userId��user�����ҵ�Ψһƥ�����
	 * ���������ݷ�װ��user���󷵻�
	 * û���ҵ�ƥ���з���null
	 * @param userId
	 */
	@Override
	public User getUserByuserId(int userId) {
		
		String sql = "Select *from user where userId=? ";
		Object[] params =new Object[] {userId};
		return getUser(sql,params);

	}

	/**
	 * �����û���ע��
	 * ����userId��user�����ҵ�ƥ���У���ƥ���е�followings-1
	 * @param userId
	 */
	@Override
	public int reduceNumOfFollowings(int userId) {
		BaseDao aa = new BaseDao();
		Object[] params =new Object[]{userId};
		int a = aa.executeIUD("update user set followings=followings-1 where userId=?",params);
		return a;
	}


	/**
	 * �����û��Ĺ�ע��
	 * ����userId��user�����ҵ�ƥ����У���ƥ���е�followings+1
	 * @param userId
	 */
	@Override
	public int addNumOfFollowings(int userId) {
		BaseDao aa = new BaseDao();
		Object[] params =new Object[]{userId};
		int a = aa.executeIUD("update user set followings=followings+1 where userId=?",params);
		return a;
	}
	
	/**
	 * ���ô���
	 * @param sql
	 * @param params
	 * @return
	 */
	private User getUser(String sql,Object... params) {
		BaseDao aa = new BaseDao();
		ResultSet bb =  aa.executeSelect(sql,params);
		User p = null;
		try {
			while(bb.next()) {
				p = new User();
				p.setUserName(bb.getString(2));
				p.setPwd(bb.getString(9));
				p.setFollowers(bb.getInt(5));
				p.setFollowings(bb.getInt(4));
				p.setIntroduction(bb.getString(6));
				p.setNickName(bb.getString(3));     
				p.setType( Integer.parseInt(bb.getString(8)));     //�ַ���ת����
				p.setVip(bb.getInt(7));
				p.setUserId(bb.getInt(1));
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			aa.closeAll(aa.con, aa.pst,aa.rs);
		}
		return p;
	}

}
