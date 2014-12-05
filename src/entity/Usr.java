package entity;

public class Usr {	
	
	String seq;
	String id;
	String pw;
	String name;
	String type;
	String phone1;
	String gender;
	String birth;
	
	public Usr (String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	public Usr(String seq, String id, String pw, String name, String type, String phone1, String gender,
			String birth) {
		super();
		this.seq = seq;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.type = type;
		this.phone1 = phone1;
		this.gender = gender;
		this.birth = birth;
	}
	
	public Usr(String id, String pw, String name, String phone1, String gender,
			String birth) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone1 = phone1;
		this.gender = gender;
		this.birth = birth;
	}
	
	public String getSeq() {
		return seq;
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
	
	public String getType() {
		return type;
	}
	
	public String getPhone1() {
		return phone1;
	}

	public String getGender() {
		return gender;
	}

	public String getBirth() {
		return birth;
	}


	@Override
	public String toString() {
		return "Usr [seq=" + seq + ", id=" + id + ", pw=" + pw + ", name="
				+ name + ", type=" + type + ", phone1=" + phone1 + ", gender="
				+ gender + ", birth=" + birth + "]";
	}
	
}
