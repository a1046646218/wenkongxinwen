package neu.edu.dao;

import java.util.ArrayList;

import neu.edu.entity.Sence;
import neu.edu.entity.User;

public interface SensibleDao {
	public int addSence(Sence se);
	public int downvip(int userid);
	public int upvip(int userid);
	
	public int deleteSence(int senceId);
	
	public ArrayList<Sence> findSenceByUserId(int userId);
}
