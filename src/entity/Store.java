package entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Store {
	private String seq;
	
	@NotNull @Size(min = 4, max = 45)
	private String usr;
	@NotNull @Size(min = 4, max = 45)
	private String name;
	@NotNull @Size(min = 4, max = 45)
	private String addr;
	@NotNull @Size(min = 4, max = 45)
	private String phone1;

	public Store(String name) {
		this(null, name, null, null);
	}
	
	public Store(String usr, String name, String addr, String phone1) {
		this(null, usr, name, addr, phone1);
	}
	
	public Store(String seq, String usr, String name, String addr, String phone1) {
		super();
		this.seq = seq;
		this.usr = usr;
		this.name = name;
		this.addr = addr;
		this.phone1 = phone1;
	}
	
	public String getSeq() {
		return seq;
	}

	public String getUsr() {
		return usr;
	}

	public String getName() {
		return name;
	}

	public String getAddr() {
		return addr;
	}

	public String getPhone1() {
		return phone1;
	}

	@Override
	public String toString() {
		return "Store [usr=" + usr + ", name=" + name + ", addr=" + addr
				+ ", phone1=" + phone1 + "]";
	}
	
}
