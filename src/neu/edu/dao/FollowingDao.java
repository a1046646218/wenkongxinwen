package neu.edu.dao;

import java.util.ArrayList;

public interface FollowingDao {
	
	
	public ArrayList<Integer> getFollowersByID(int user_id);
	
	public ArrayList<Integer> getFollowingByID(int user_id);
	
	public int addFollowing(int followingId,int followerId);
	
	public int isFollowing(int followingId,int followerId);
	
	public int removeFollowing(int followingId,int followerId);
}
