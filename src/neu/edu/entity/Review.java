package neu.edu.entity;

public class Review {
	private int reviewId;//二级评论的主建
	private int commentId;//在哪条一级评论下
	private int userId;//这个评论的id
	private String content;//内容
	private String remarkstr;//表明这条回复B是否是对某条回复A的回复，如果是，存放着回复A	@A.nickname:content m 
	private String NickName;//这个review的人的nickname
	public Review() {
		
	}
	public Review(int reviewId, int commentId, int userId, String content, String remarkstr, String nickName) {
		super();
		this.reviewId = reviewId;
		this.commentId = commentId;
		this.userId = userId;
		this.content = content;
		this.remarkstr = remarkstr;
		NickName = nickName;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRemarkstr() {
		return remarkstr;
	}
	public void setRemarkstr(String remarkstr) {
		this.remarkstr = remarkstr;
	}
	public String getNickName() {
		return NickName;
	}
	public void setNickName(String nickName) {
		NickName = nickName;
	}
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", commentId=" + commentId + ", userId=" + userId + ", content="
				+ content + ", remarkstr=" + remarkstr + ", NickName=" + NickName + "]";
	}
	
}
