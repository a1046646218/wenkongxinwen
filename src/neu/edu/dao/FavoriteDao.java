package neu.edu.dao;

import java.util.ArrayList;

/**
 * ��favorte���йص�Dao�ӿ�
 * @author mr.H
 *
 */
public interface FavoriteDao {
	
	/**
	 * ͨ�������user_idֵ���ҵ�����favorite(�ղر�)�е�newsId,�������ð�װ��ArrayList�з���
	 * @param user_id
	 * @return
	 */
	public ArrayList<Integer> getNewsIdListByUserId(int user_id);
	
	public int addFavorite(int new_id,int user_id);
	
	public int isFavoriteNews(int new_id, int user_id);

	
}
