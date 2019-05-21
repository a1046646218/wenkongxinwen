package neu.edu.service;

import neu.edu.dao.UserDao;
import neu.edu.dao.impl.UserDaoImpl;
import neu.edu.entity.User;

public class ForUserService {

	private UserDao userDao = new UserDaoImpl();
	/**方法名   getUserBypwdandusername
     * 输入用户名  username  String
    * 密码        password  String
     *返回值  user  u
     *去数据库中查找账户名和密码匹配的用户，如果有返回u对象，如果没有返回Null
	 * */
	public User getUserBypwdandusername(String userName,String password) {
		User u = userDao.getUserBypwdandusername(userName,password);
		return u;
	}
	/**方法名   getUserByusername
	 * 输入用户名  username  String
	 *返回值  user  u
	 *去数据库中查找账户名匹配的用户，如果有返回u对象，如果没有返回Null
	 * */
	public User getUserByusername(String userName) {
		User u = userDao.getUserByusername(userName);
		return u;
	}
	/**方法名   getUserByuserId
	 * 输入用户名  userId  int
	 *返回值  user  u
	 *去数据库中查找与用户注册的Id号匹配的用户，如果有返回u对象，如果没有返回Null
	 * */
	public User getUserByuserId(int userId) {
		User u = userDao.getUserByuserId(userId);
		return u;
	}
	
}
