package neu.edu.dao;

import neu.edu.entity.Sence;
import neu.edu.entity.User;

public interface SensibleDao {
	public int addSence(Sence se);
	public int downvip(int userid);
	public int upvip(int userid);
}
