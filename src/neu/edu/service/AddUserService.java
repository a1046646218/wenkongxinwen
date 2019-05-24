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
        //15的8进制是0000,1111
          sb.append(c[(bb>>4)&15]);
          sb.append(c[bb&15]);
          System.out.println(sb.toString());
        }
	System.out.println(sb.toString());
	return sb.toString();
		
	}
	
	/**
	 * 方法名  addUser
	 * 输入    username String,Nickname String,Introduction string,Password   string
	 * 返回值 int flag
	 * 输入用户信息 之后在数据库中添加，成功返回1 失败返回0
	 * 默认 粉丝关注为0
	 *  用户类型为普通用户,Vip为0,User_id是自动增长不设置
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
