package entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Store {
	private String seq;

	@NotNull
	private String userSeq;

	private String userName;

	@NotNull
	@Size(min = 4, max = 45)
	private String name;

	@NotNull
	@Size(min = 4, max = 128)
	private String addr;

	@NotNull
	@Size(min = 4, max = 16)
	private String phone;

	public Store(String userSeq, String name, String addr, String phone) {
		this(null, userSeq, name, addr, phone, null);
	}

	public Store(String seq, String userSeq, String name, String addr, String phone, String userName) {
		super();
		this.seq = seq;
		this.userSeq = userSeq;
		this.name = name;
		this.addr = addr;
		this.phone = phone;
		this.userName = userName;
	}

	public String getSeq() {
		return seq;
	}

	public String getUserSeq() {
		return userSeq;
	}

	public String getName() {
		return name;
	}

	public String getAddr() {
		return addr;
	}

	public String getPhone() {
		return phone;
	}

	public String getUserName() {
		return userName;
	}

	@Override
	public String toString() {
		return "Store [seq=" + seq + ", userSeq=" + userSeq + ", userName=" + userName + ", name=" + name + ", addr="
				+ addr + ", phone=" + phone + "]";
	}

}
