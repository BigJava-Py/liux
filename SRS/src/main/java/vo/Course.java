package vo;

public class Course {

	private String cid;
	private String courseName;
	private String score;//学分
	private int time;
	private String teacher;
	public Course() {
		super();
	}
	public Course(String cid, String courseName, String score) {
		super();
		this.cid = cid;
		this.courseName = courseName;
		this.score = score;
	}
	
	public Course(String cid, String courseName, String score, int time, String teacher) {
		super();
		this.cid = cid;
		this.courseName = courseName;
		this.score = score;
		this.time = time;
		this.teacher = teacher;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	
	
}
