package neu.edu.service;

import neu.edu.dao.UserDao;
import neu.edu.dao.impl.NewsDaoImpl;
import neu.edu.dao.impl.UserDaoImpl;
import neu.edu.entity.User;

public class ForUserService {

	private UserDao userDao = new UserDaoImpl();
	/**������   getUserBypwdandusername
     * �����û���  username  String
    * ����        password  String
     *����ֵ  user  u
     *ȥ���ݿ��в����˻���������ƥ����û�������з���u�������û�з���Null
	 * */
	public User getUserBypwdandusername(String userName,String password) {
		User u = userDao.getUserBypwdandusername(userName,password);
		return u;
	}
	/**������   getUserByusername
	 * �����û���  username  String
	 *����ֵ  user  u
	 *ȥ���ݿ��в����˻���ƥ����û�������з���u�������û�з���Null
	 * */
	public User getUserByusername(String userName) {
		User u = userDao.getUserByusername(userName);
		return u;
	}
	/**������   getUserByuserId
	 * �����û���  userId  int
	 *����ֵ  user  u
	 *ȥ���ݿ��в������û�ע���Id��ƥ����û�������з���u�������û�з���Null
	 * */
	public User getUserByuserId(int userId) {
		User u = userDao.getUserByuserId(userId);
		return u;
	}
	/**
	 * ����new_id�ҵ����ŵķ���user
	 * */
	public User getUserBynewId(int new_id) {
		NewsDaoImpl lmp = new NewsDaoImpl();
		int user_id = lmp.getNewsByID(new_id).getUserId();
		User u = userDao.getUserByuserId(user_id);
		return u;
	}
	
}
