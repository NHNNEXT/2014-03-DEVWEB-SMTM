package entity;

public class Store {

	String usr;
	String name;
	String addr;
	String phone1;
	
	public Store(String usr, String name, String addr, String phone1) {
		super();
		this.usr = usr;
		this.name = name;
		this.addr = addr;
		this.phone1 = phone1;
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
