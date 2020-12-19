package vo;

public class Score {

	private String tid;
	private String cid;
	private String courseName;
	private String score;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Score() {
		super();
	}

	public Score(String tid, String cid, String score) {
		super();
		this.tid = tid;
		this.cid = cid;
		this.score = score;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

}
