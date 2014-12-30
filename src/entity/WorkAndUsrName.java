package entity;

public class WorkAndUsrName {
	private Work work;
	private String usrName;
	
	public WorkAndUsrName(Work work, String usrName) {
		super();
		this.work = work;
		this.usrName = usrName;
	}

	public Work getWork() {
		return work;
	}

	public String getUsrName() {
		return usrName;
	}
}
