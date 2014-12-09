package entity;

public class Work {
	String seq;
	String stoSeq;
	String albaSeq;
	String stus;
	String start;
	String finish;
	String startConfirm;
	String finishConfirm;

	public Work(String seq, String stoSeq, String albaSeq, String stus,
			String start, String finish) {
		this(seq, stoSeq, albaSeq, stus, start, finish, null, null);
	}
	
	public Work(String seq, String stoSeq, String albaSeq, String stus,
			String start, String finish, String startConfirm,
			String finishConfirm) {
		super();
		this.seq = seq;
		this.stoSeq = stoSeq;
		this.albaSeq = albaSeq;
		this.stus = stus;
		this.start = start;
		this.finish = finish;
		this.startConfirm = startConfirm;
		this.finishConfirm = finishConfirm;
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
	public String getStartConfirm() {
		return startConfirm;
	}

	public String getFinishConfirm() {
		return finishConfirm;
	}

	@Override
	public String toString() {
		return "Work [seq=" + seq + ", stoSeq=" + stoSeq + ", albaSeq="
				+ albaSeq + ", stus=" + stus + ", start=" + start + ", finish="
				+ finish + ", startConfirm=" + startConfirm
				+ ", finishConfirm=" + finishConfirm + "]";
	}
}
