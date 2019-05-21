package neu.edu.entity;

public class User {
	private int userId;  //用户表的主键 
	private String userName; //用户登陆用的
	private String nickName;//用户昵称
	private int followings;//用户的关注数
	private int followers;//用户被关注数
	private String introduction;//用户简介
	private int vip; //vip
	private int type;//用户是否为能发新闻的 0/1
	private String Password;//密码
		public User() {
			
		}
	public User(int userId, String userName, String nickName, int followings, int followers, String introduction,
			int vip, int type, String pwd) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.nickName = nickName;
		this.followings = followings;
		this.followers = followers;
		this.introduction = introduction;
		this.vip = vip;
		this.type = type;
		this.Password = pwd;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getFollowings() {
		return followings;
	}
	public void setFollowings(int followings) {
		this.followings = followings;
	}
	public int getFollowers() {
		return followers;
	}
	public void setFollowers(int followers) {
		this.followers = followers;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public int getVip() {
		return vip;
	}
	public void setVip(int vip) {
		this.vip = vip;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getPwd() {
		return Password;
	}
	public void setPwd(String pwd) {
		this.Password = pwd;
	}
	
}
