package entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

	// name it can be storeName or userName;
	public Work(String seq, String stoSeq, String albaSeq, String stus,
			String start, String finish, String startConfirm,
			String finishConfirm, String name) {
		super();
		this.seq = seq;
		this.stoSeq = stoSeq;
		this.albaSeq = albaSeq;
		this.stus = stus;
		this.start = start;
		this.finish = finish;
		this.startConfirm = startConfirm;
		this.finishConfirm = finishConfirm;
		this.name = name;
	}

	public Work(String seq, String stoSeq, String albaSeq, String stus,
			String start, String finish, String startConfirm,
			String finishConfirm) {
		this(seq, stoSeq, albaSeq, stus, start, finish, startConfirm,
				finishConfirm, null);

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

	public float getTime() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (finish==null){
			return 0;
		}
		Date finishTime = format.parse(finish);
		Date startTime = format.parse(start);
		float time = (finishTime.getTime() - startTime.getTime())/1000;
		return time;

	}
}
