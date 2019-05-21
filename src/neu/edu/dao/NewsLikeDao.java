package neu.edu.dao;

public interface NewsLikeDao {

	
	public int addNewsLike(int new_id,int user_id);
	
	public int isLikeNews(int new_id, int user_id);
}
