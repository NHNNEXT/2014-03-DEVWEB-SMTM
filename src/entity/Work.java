package entity;

public class Work {
	String seq;
	String stoSeq;
	String albaSeq;
	String stus;
	String start;
	String finish;
	
	public Work(String seq, String stoSeq, String albaSeq, String stus,
			String start, String finish) {
		super();
		this.seq = seq;
		this.stoSeq = stoSeq;
		this.albaSeq = albaSeq;
		this.stus = stus;
		this.start = start;
		this.finish = finish;
	}

	public String getSeq() {
		return seq;
	}
	
	public String getStoSeq() {
		return stoSeq;
	}
	public String getAlbaSeq() {
		return albaSeq;
	}
	public String getStus() {
		return stus;
	}
	public String getStart() {
		return start;
	}
	public String getFinish() {
		return finish;
	}

	@Override
	public String toString() {
		return "Work [seq=" + seq + ", stoSeq=" + stoSeq + ", albaSeq="
				+ albaSeq + ", stus=" + stus + ", start=" + start + ", finish="
				+ finish + "]";
	}
}
