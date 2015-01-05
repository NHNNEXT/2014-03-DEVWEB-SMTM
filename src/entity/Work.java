package entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;

public class Work {
	public static final String STATUS_GO_TO_WORK = "1001";
	public static final String STATUS_LEAVE_WORK = "1002";
	public static final String STATUS_GO_TO_WORK_CONFIRM = "1003";
	public static final String STATUS_LEAVE_WORK_CONFIRM = "1004";
	
	@NotNull
	private String seq;
	
	@NotNull
	private String stoSeq;
	
	@NotNull
	private String userSeq;
	
	@NotNull
	private String status;
	
	private String start;
	
	private String finish;
	
	private String startConfirm;
	
	private String finishConfirm;
	
	private String name;

	// name it can be storeName or userName;
	public Work(String seq, String stoSeq, String userSeq, String status, String start, String finish,
			String startConfirm, String finishConfirm, String name) {
		super();
		this.seq = seq;
		this.stoSeq = stoSeq;
		this.userSeq = userSeq;
		this.status = status;
		this.start = start;
		this.finish = finish;
		this.startConfirm = startConfirm;
		this.finishConfirm = finishConfirm;
		this.name = name;
	}

	public Work(String seq, String stoSeq, String userSeq, String status, String start, String finish,
			String startConfirm, String finishConfirm) {
		this(seq, stoSeq, userSeq, status, start, finish, startConfirm, finishConfirm, null);

	}

	public String getSeq() {
		return seq;
	}

	public String getStoSeq() {
		return stoSeq;
	}

	public String getUserSeq() {
		return userSeq;
	}

	public String getStatus() {
		return status;
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
	
	public boolean isGoToWorkRequest() {
		return (this.status == STATUS_GO_TO_WORK) ? true : false;
	}

	public boolean isLeaveWorkRequest() {
		return (this.status == STATUS_LEAVE_WORK) ? true : false;
	}
	
	public boolean isGoToWorkConfirmed() {
		return (this.status == STATUS_GO_TO_WORK_CONFIRM) ? true : false;
	}
	
	public boolean isLeaveWorkConfirmed() {
		return (this.status == STATUS_LEAVE_WORK_CONFIRM) ? true : false;
	}

	@Override
	public String toString() {
		return "Work [seq=" + seq + ", stoSeq=" + stoSeq + ", albaSeq=" + userSeq + ", stus=" + status + ", start="
				+ start + ", finish=" + finish + ", startConfirm=" + startConfirm + ", finishConfirm=" + finishConfirm
				+ "]";
	}

	public float getTime() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (finish == null) {
			return 0;
		}
		Date finishTime = format.parse(finish);
		Date startTime = format.parse(start);
		float time = (finishTime.getTime() - startTime.getTime()) / 1000;
		return time;

	}
}
