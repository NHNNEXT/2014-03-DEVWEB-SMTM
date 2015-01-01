package entity;

public class Employment {
	private String storeSeq;
	private String UsrSeq;
	
	public Employment(String storeSeq, String usrSeq) {
		super();
		this.storeSeq = storeSeq;
		UsrSeq = usrSeq;
	}

	public String getStoreSeq() {
		return storeSeq;
	}

	public String getUsrSeq() {
		return UsrSeq;
	}
	
}
