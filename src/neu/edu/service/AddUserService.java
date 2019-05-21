package neu.edu.service;

import neu.edu.dao.UserDao;
import neu.edu.dao.impl.UserDaoImpl;
import neu.edu.entity.User;

public class AddUserService {
	
	private UserDao da = new UserDaoImpl();
	
	
	/**
	 * 方法名  addUser
	 * 输入    username String,Nickname String,Introduction string,Password   string
	 * 返回值 int flag
	 * 输入用户信息 之后在数据库中添加，成功返回1 失败返回0
	 * 默认 粉丝关注为0
	 *  用户类型为普通用户,Vip为0,User_id是自动增长不设置
	 * */
	public int addUser(String username,String Nickname,String introduction,String password) {
		int a = da.addUser(username,Nickname,introduction,password);
		return a;
	}
	
	/**
	 * 方法名  addUser
	 * 输入    user对象
	 * 返回值 int flag
	 * 输入用户信息 之后在数据库中添加，成功返回1 失败返回0
	 * 默认 粉丝关注为0
	 *  用户类型为普通用户,Vip为0,User_id是自动增长不设置
	 * */
	public int addUser(User user) {
		return da.addUser(user);
	}
	
}
