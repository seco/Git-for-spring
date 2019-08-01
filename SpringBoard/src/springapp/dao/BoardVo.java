package springapp.dao;

public class BoardVo {

	private int seq;
	private String writer;
	private String title;
	private String content;
	private String password;
	private int hit;
	private int groups;
	private int step;
	private int levels;
	private String regdate;
	
	//Getter
	public int getSeq() {
		return seq;
	}
	public String getWriter() {
		return writer;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getPassword() {
		return password;
	}
	public int getHit() {
		return hit;
	}
	public int getGroups() {
		return groups;
	}
	public int getStep() {
		return step;
	}
	public int getLevels() {
		return levels;
	}
	public String getRegdate() {
		return regdate;
	}
	//Setter
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public void setGroups(int groups) {
		this.groups = groups;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public void setLevels(int levels) {
		this.levels = levels;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
}
