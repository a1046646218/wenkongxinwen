package neu.edu.entity;

public class Sence {
	private int senceid;
	private String content;
	private String sencecontent;
	private int userId;
	private String nickName;
	private int iscomment;
	private int relativeid;
	public int getSenceid() {
		return senceid;
	}
	public Sence(int senceid, String content, String sencecontent, int userId, String nickName, int iscomment,
			int relativeid) {
		super();
		this.senceid = senceid;
		this.content = content;
		this.sencecontent = sencecontent;
		this.userId = userId;
		this.nickName = nickName;
		this.iscomment = iscomment;
		this.relativeid = relativeid;
	}
	public void setSenceid(int senceid) {
		this.senceid = senceid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSencecontent() {
		return sencecontent;
	}
	public void setSencecontent(String sencecontent) {
		this.sencecontent = sencecontent;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getIscomment() {
		return iscomment;
	}
	public void setIscomment(int iscomment) {
		this.iscomment = iscomment;
	}
	public int getRelativeid() {
		return relativeid;
	}
	public void setRelativeid(int relativeid) {
		this.relativeid = relativeid;
	}

}
