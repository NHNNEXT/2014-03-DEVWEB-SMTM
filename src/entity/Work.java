package entity;

import javax.validation.constraints.NotNull;

public class Work {
	@NotNull
	private String seq;
	@NotNull
	private String stoSeq;
	@NotNull
	private String albaSeq;
	@NotNull
	private String stus;
	private String start;
	private String finish;
	private String startConfirm;
	private String finishConfirm;
	private String name;
	private int worktime;

	public Work(String seq, String stoSeq, String albaSeq, String stus,
			String start, String finish, String name) {
		super();
		this.seq = seq;
		this.stoSeq = stoSeq;
		this.albaSeq = albaSeq;
		this.stus = stus;
		this.start = start;
		this.finish = finish;
		this.name = name;
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
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Work [seq=" + seq + ", stoSeq=" + stoSeq + ", albaSeq="
				+ albaSeq + ", stus=" + stus + ", start=" + start + ", finish="
				+ finish + ", startConfirm=" + startConfirm
				+ ", finishConfirm=" + finishConfirm + "]";
	}
}
