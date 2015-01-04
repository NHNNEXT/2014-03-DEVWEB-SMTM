package entity;

import javax.validation.constraints.NotNull;

public class Employment {
	@NotNull
	private String storeSeq;
	@NotNull
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
