package entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Store {
	private String seq;
	@NotNull
	private String userSeq;
	@NotNull @Size(min = 4, max = 45)
	private String name;
	@NotNull @Size(min = 4, max = 128)
	private String addr;
	@NotNull @Size(min = 4, max = 16)
	private String phone;

	public Store(String name) {
		this(null, name, null, null);
	}

	public Store(String userSeq, String name, String addr, String phone) {
		this(null, userSeq, name, addr, phone);
	}

	public Store(String seq, String userSeq, String name, String addr, String phone) {
		super();
		this.seq = seq;
		this.userSeq = userSeq;
		this.name = name;
		this.addr = addr;
		this.phone = phone;
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

	@Override
	public String toString() {
		return "Store [usr=" + userSeq + ", name=" + name + ", addr=" + addr
				+ ", phone1=" + phone + "]";
	}

}
