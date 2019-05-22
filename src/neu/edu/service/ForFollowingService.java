package neu.edu.service;

import java.util.ArrayList;

import neu.edu.dao.FollowingDao;
import neu.edu.dao.UserDao;
import neu.edu.dao.impl.FollowingDaoImpl;
import neu.edu.dao.impl.UserDaoImpl;
import neu.edu.entity.User;

public class ForFollowingService {

	private FollowingDao followingDao = new FollowingDaoImpl();
	private UserDao userDao = new UserDaoImpl();
	/**
	 * 方法名  getUserGuanByID
	 * 输入值  int user_id
	 * 返回值  ArrayList<User> list
	 * 去数据库中根据用户id找到所有这个用户关注的人
	 * 注意，如果没有返回的是一个空的ArrayList,而不是null
	 * */
	public ArrayList<User> getUserGuanByID(int user_id){
		ArrayList<User> list = new ArrayList<>();
		
		ArrayList<Integer> li  =  followingDao.getFollowingByID(user_id);
		for(int i=0;i<li.size();i++) {
			User u = userDao.getUserByUserId(li.get(i));
			list.add(u);
		}
		return list;
	}
	
	/**
	 * 方法名  getUserFenByID
	 * 输入值  int user_id
	 * 返回值  ArrayList<User> list
	 * 去数据库中根据用户id找到所有这个用户的粉丝
	 * 注意，如果没有返回的是一个空的ArrayList,而不是null
	 * */
	public ArrayList<User> getUserFenByID(int user_id){
		ArrayList<User> list = new ArrayList<>();
		
		ArrayList<Integer> li  =  followingDao.getFollowersByID(user_id);
		for(int i=0;i<li.size();i++) {
			User u = userDao.getUserByUserId(li.get(i));
			list.add(u);
		}
		return list;
	}
	
	/**
	 * 第一个参数是关注者的id  第二个参数是被关注者的id
	 * 在following表中删去一行关注关系，并对user表中user_id匹配的用户，使其following关注数-1
	 * 操作成功返回true
	 * @param user_id
	 * @param guan_id
	 * @return
	 */
	public boolean RemoveGuan(int user_id,int guan_id) {
		int a=followingDao.removeFollowing(guan_id, user_id);
		userDao.reduceNumOfFollowings(user_id);
		if(a>0)
		{
			return true;
		}
		return false;
	}

	/**
	 * 第一个参数是关注者的id  第二个参数是被关注者的id
	 * 在following表中增加一行关注关系，并对user表中user_id匹配的用户，使其following关注数+1
	 * 操作成功返回true
	 * @param user_id
	 * @param guan_id
	 * @return
	 */
	public boolean addGuan(int user_id,int guan_id) {

		int a=followingDao.addFollowing(guan_id, user_id);
		userDao.addNumOfFollowings(user_id);
		if(a>0)
		{
			return true;
		}
		return false;
	}
}
