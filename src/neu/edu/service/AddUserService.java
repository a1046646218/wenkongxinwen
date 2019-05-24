package neu.edu.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import neu.edu.dao.UserDao;
import neu.edu.dao.impl.UserDaoImpl;
import neu.edu.entity.User;

public class AddUserService {
	
	private UserDao da = new UserDaoImpl();
	public String Md5(String Password) throws NoSuchAlgorithmException
	{MessageDigest md5 = MessageDigest.getInstance("MD5");
	byte[] bytes = Password.getBytes();
	byte[] digest =md5.digest(bytes);
	char[] c ={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	StringBuffer sb = new StringBuffer();
	for(byte bb:digest){
        //15��8������0000,1111
          sb.append(c[(bb>>4)&15]);
          sb.append(c[bb&15]);
          System.out.println(sb.toString());
        }
	System.out.println(sb.toString());
	return sb.toString();
		
	}
	
	/**
	 * ������  addUser
	 * ����    username String,Nickname String,Introduction string,Password   string
	 * ����ֵ int flag
	 * �����û���Ϣ ֮�������ݿ�����ӣ��ɹ�����1 ʧ�ܷ���0
	 * Ĭ�� ��˿��עΪ0
	 *  �û�����Ϊ��ͨ�û�,VipΪ0,User_id���Զ�����������
	 * */
	public int addUser(String username,String Nickname,String introduction,String password) {
		try {
			password=Md5(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
