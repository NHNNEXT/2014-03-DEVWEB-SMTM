package entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class User {
	private String seq;
	
	@NotNull @Size(min = 4, max = 24)
	private String id;
	@NotNull @Size(min = 4, max = 24)
	private String pw;
	@NotNull @Size(min = 4, max = 45)
	private String name;
	@NotNull
	private String type;
	@NotNull @Size(min = 4, max = 16)
	private String phone;
	private String gender;
	@NotBlank
	private String birth;
	
	public User(String id, String pw, String name, String type, String phone,
			String gender, String birth) {
		this(null, id, pw, name, type, phone, gender, birth);
	}
	
	public User(String seq, String id, String pw, String name, String type,
			String phone, String gender, String birth) {
		super();
		this.seq = seq;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.type = type;
		this.phone = phone;
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

	public String getPhone() {
		return phone;
	}

	public String getGender() {
		return gender;
	}

	public String getBirth() {
		return birth;
	}

	public boolean checkPassword(String loginPw) {
		return this.pw.equals(loginPw);
	}
	
	@Override
	public String toString() {
		return "Usr [seq=" + seq + ", id=" + id + ", pw=" + pw + ", name="
				+ name + ", type=" + type + ", phone1=" + phone + ", gender="
				+ gender + ", birth=" + birth + "]";
	}

}