package neu.edu.service;

import neu.edu.dao.UserDao;
import neu.edu.dao.impl.UserDaoImpl;
import neu.edu.entity.User;

public class AddUserService {
	
	private UserDao da = new UserDaoImpl();
	
	
	/**
	 * ������  addUser
	 * ����    username String,Nickname String,Introduction string,Password   string
	 * ����ֵ int flag
	 * �����û���Ϣ ֮�������ݿ�����ӣ��ɹ�����1 ʧ�ܷ���0
	 * Ĭ�� ��˿��עΪ0
	 *  �û�����Ϊ��ͨ�û�,VipΪ0,User_id���Զ�����������
	 * */
	public int addUser(String username,String Nickname,String introduction,String password) {
		int a = da.addUser(username,Nickname,introduction,password);
		return a;
	}
	
	/**
	 * ������  addUser
	 * ����    user����
	 * ����ֵ int flag
	 * �����û���Ϣ ֮�������ݿ�����ӣ��ɹ�����1 ʧ�ܷ���0
	 * Ĭ�� ��˿��עΪ0
	 *  �û�����Ϊ��ͨ�û�,VipΪ0,User_id���Զ�����������
	 * */
	public int addUser(User user) {
		return da.addUser(user);
	}
	
}
