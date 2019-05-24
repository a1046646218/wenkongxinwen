package neu.edu.service;

import java.util.ArrayList;

import neu.edu.dao.CommentDao;
import neu.edu.dao.NewsDao;
import neu.edu.dao.impl.CommentDaoImpl;
import neu.edu.dao.impl.NewsDaoImpl;
import neu.edu.entity.Comment;
import neu.edu.entity.News;

public class ShowNewsCommentService {
	
	private NewsDao newsDao = new NewsDaoImpl();
	private CommentDao commentDao = new CommentDaoImpl();
	
	public ArrayList<Comment> showNewsComments(int user_id) {
		ArrayList<News> newsList = newsDao.getNewsListByID(user_id);
		ArrayList<Comment> commentList = new ArrayList<Comment>();
		for(News news :newsList) {
			ArrayList<Comment> list = commentDao.getCommentListByNewId(news.getNewsId(),user_id);
			for(Comment comment : list) {
				commentList.add(comment);
			}
		}
		return commentList;
	}
	
	public static void main(String[] args) {
		ShowNewsCommentService showNewsCommentService = new ShowNewsCommentService();
		showNewsCommentService.showNewsComments(1);
	}
}
