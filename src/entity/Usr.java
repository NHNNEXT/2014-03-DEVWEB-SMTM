package entity;

public class Usr {	
	String id;
	String pw;
	String name;
	
	public Usr (String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	public Usr (String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPw() {
		return pw;
	}
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Usr [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}
	
}
