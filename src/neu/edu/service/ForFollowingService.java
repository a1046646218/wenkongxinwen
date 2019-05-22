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
	 * ������  getUserGuanByID
	 * ����ֵ  int user_id
	 * ����ֵ  ArrayList<User> list
	 * ȥ���ݿ��и����û�id�ҵ���������û���ע����
	 * ע�⣬���û�з��ص���һ���յ�ArrayList,������null
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
	 * ������  getUserFenByID
	 * ����ֵ  int user_id
	 * ����ֵ  ArrayList<User> list
	 * ȥ���ݿ��и����û�id�ҵ���������û��ķ�˿
	 * ע�⣬���û�з��ص���һ���յ�ArrayList,������null
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
	 * ��һ�������ǹ�ע�ߵ�id  �ڶ��������Ǳ���ע�ߵ�id
	 * ��following����ɾȥһ�й�ע��ϵ������user����user_idƥ����û���ʹ��following��ע��-1
	 * �����ɹ�����true
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
	 * ��һ�������ǹ�ע�ߵ�id  �ڶ��������Ǳ���ע�ߵ�id
	 * ��following��������һ�й�ע��ϵ������user����user_idƥ����û���ʹ��following��ע��+1
	 * �����ɹ�����true
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
