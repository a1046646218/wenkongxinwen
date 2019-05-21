package neu.edu.entity;

public class News {
	private int newsId;//���ű������
	private String title;//���ŵı���
	private int favorites;//���������ղ�
	private int userId;//���ŵķ�����
	private int like;//�������˵���
	private String content;//����
	private String type; //��������
	private int comments;//������
	private String nickname;//�������û��ǳ�
	private String url;//���ͼƬ�ľ��Ե�ַ
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public News() {
		
	}
	public News(int newsId, String title, int favorites, int userId, int like, String content, String type,
			int comments, String nickname,String url) {
		super();
		this.newsId = newsId;
		this.title = title;
		this.favorites = favorites;
		this.userId = userId;
		this.like = like;
		this.content = content;
		this.type = type;
		this.comments = comments;
		this.nickname = nickname;
		this.url = url;
	}
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getTitile() {
		return title;
	}
	public void setTitile(String title) {
		this.title = title;
	}
	public int getFavorites() {
		return favorites;
	}
	public void setFavorites(int favorites) {
		this.favorites = favorites;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getComments() {
		return comments;
	}
	public void setComments(int comments) {
		this.comments = comments;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
