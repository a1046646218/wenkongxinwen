package neu.edu.entity;

public class Review {
	private int reviewId;//�������۵�����
	private int commentId;//������һ��������
	private int userId;//������۵�id
	private String content;//����
	private String remarkstr;//���������ظ�B�Ƿ��Ƕ�ĳ���ظ�A�Ļظ�������ǣ�����Żظ�A	@A.nickname:content m 
	private String NickName;//���review���˵�nickname
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
