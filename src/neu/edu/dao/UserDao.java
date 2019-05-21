package neu.edu.dao;

import neu.edu.entity.User;

public interface UserDao {
	
	
	public int addUser(String username, String nickname, String introduction, String password);
	
	public int addUser(User user);
	
	public User getUserByUserId(int user_id);
	
	public User getUserBypwdandusername(String userName,String password) ;
	
	public User getUserByusername(String userName);
	
	public User getUserByuserId(int userId);
	
	public int reduceNumOfFollowings(int userId);
	
	public int addNumOfFollowings(int userId);
	

}
