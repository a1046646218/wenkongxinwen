package neu.edu.entity;
//一级评论
public class Comment{
	private int commentId;//主键
	private int userId;//评论人
	private int newsId;//评论的哪条新闻
	private String content;//内容
	private int likes;//点赞数
	private int reviews;//这条评论的子评论	
	private String nickName;//这条评论人的nickname
	public Comment() {
		
	}
	public Comment(int commentId, int userId, int newsId, String content, int likes, int reviews,
			String nickName) {
		super();
		this.commentId = commentId;
		this.userId = userId;
		this.newsId = newsId;
		this.content = content;
		this.likes = likes;
		this.reviews = reviews;
		this.nickName = nickName;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getReviews() {
		return reviews;
	}
	public void setReviews(int reviews) {
		this.reviews = reviews;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
}
