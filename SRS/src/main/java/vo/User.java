package vo;

public class User {

	private String tid;
	private String name;
	private String password;
	public User() {
		super();
	}
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}
	public User(String tid, String name, String password) {
		super();
		this.tid = tid;
		this.name = name;
		this.password = password;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
