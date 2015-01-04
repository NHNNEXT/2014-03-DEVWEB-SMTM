package entity;

import javax.validation.constraints.NotNull;

public class Employment {
	@NotNull
	private String storeSeq;
	
	@NotNull
	private String UserSeq;

	public Employment(String storeSeq, String userSeq) {
		super();
		this.storeSeq = storeSeq;
		UserSeq = userSeq;
	}

	public String getStoreSeq() {
		return storeSeq;
	}

	public String getUserSeq() {
		return UserSeq;
	}

}
