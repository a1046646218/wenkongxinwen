package neu.edu.dao;

import java.util.ArrayList;

/**
 * 与favorte表有关的Dao接口
 * @author mr.H
 *
 */
public interface FavoriteDao {
	
	/**
	 * 通过传入的user_id值，找到所有favorite(收藏表)中的newsId,并将其用包装在ArrayList中返回
	 * @param user_id
	 * @return
	 */
	public ArrayList<Integer> getNewsIdListByUserId(int user_id);
	
	public int addFavorite(int new_id,int user_id);
	
	public int isFavoriteNews(int new_id, int user_id);

	
}
