package neu.edu.entity;

public class CommentDecode {
	private Comment com;
	private int flag;
	public CommentDecode(Comment com, int flag) {
		super();
		this.com = com;
		this.flag = flag;
	}
	public Comment getCom() {
		return com;
	}
	public void setCom(Comment com) {
		this.com = com;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
}
