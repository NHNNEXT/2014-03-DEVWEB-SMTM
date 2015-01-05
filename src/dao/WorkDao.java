package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcTemplate;
import jdbc.RowMapper;
import entity.User;
import entity.Work;

public class WorkDao {
	public int insertGoToWork(final User user, final String storeSeq) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "INSERT INTO WORK(WORK_STO_SEQ, WORK_USER_SEQ, WORK_START, WORK_FINISH) VALUES(?,?,NOW(),NOW())";
		return jdbcTemplate.executeUpdate(sql, Integer.parseInt(storeSeq), user.getSeq());
	}

	public int insertLeaveWork(final User user, final String storeSeq) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "UPDATE WORK SET WORK_STATUS=1002, WORK_FINISH=NOW() WHERE WORK_STO_SEQ=? AND WORK_USER_SEQ=?";
		return jdbcTemplate.executeUpdate(sql, Integer.parseInt(storeSeq), user.getSeq());
	}

	public ArrayList<Work> selectWork(final String storeSeq) {
		RowMapper<Work> rm = resultSetOfWorkAndName();
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT W.*, U.USER_NAME FROM WORK W "
				+ "JOIN USER U "
				+ "ON W.WORK_USER_SEQ = U.USER_SEQ WHERE (W.WORK_STO_SEQ = ? AND (W.WORK_STATUS = 1001 OR W.WORK_STATUS = 1002 OR W.WORK_STATUS = 1003))";
		return jdbcTemplate.executeQueryList(sql, rm, storeSeq);
	}

	private RowMapper<Work> resultSetOfWorkAndName() {
		return new RowMapper<Work>() {
			public Work mapRows(ResultSet rs) throws SQLException {
				return new Work(rs.getString("WORK_SEQ"), rs.getString("WORK_STO_SEQ"), rs.getString("WORK_USER_SEQ"),
						rs.getString("WORK_STATUS"), rs.getString("WORK_START"), rs.getString("WORK_FINISH"),
						rs.getString("WORK_START_CONFIRM"), rs.getString("WORK_FINISH_CONFIRM"),
						rs.getString("USER_NAME"));
			}
		};
	}

	public ArrayList<Work> showWork(final User user) {
		RowMapper<Work> rm = resultSetOfWork();
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT * FROM WORK WHERE WORK_USER_SEQ = ? AND WORK_STATUS = 1004";
		return jdbcTemplate.executeQueryList(sql, rm, user.getSeq());
	}

	public ArrayList<Work> showWorkOfStore(final String storeSeq) {
		RowMapper<Work> rm = resultSetOfWork();
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT * FROM WORK WHERE WORK_USER_SEQ = ? AND WORK_STATUS = 1004";
		return jdbcTemplate.executeQueryList(sql, rm, storeSeq);
	}

	public Work getConfirmWorkData(final String seq) {
		RowMapper<Work> rm = resultSetOfWork();
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT WORK_SEQ, WORK_STO_SEQ, WORK_USER_SEQ, WORK_STATUS, WORK_START, WORK_FINISH, WORK_START_CONFIRM, WORK_FINISH_CONFIRM FROM WORK"
				+ "WHERE WORK_SEQ = ?";
		return jdbcTemplate.executeQuery(sql, rm, Integer.parseInt(seq));
	}

	private RowMapper<Work> resultSetOfWork() {
		return new RowMapper<Work>() {
			public Work mapRows(ResultSet rs) throws SQLException {
				return new Work(rs.getString("WORK_SEQ"), rs.getString("WORK_STO_SEQ"), rs.getString("WORK_USER_SEQ"),
						rs.getString("WORK_STATUS"), rs.getString("WORK_START"), rs.getString("WORK_FINISH"),
						rs.getString("WORK_START_CONFIRM"), rs.getString("WORK_FINISH_CONFIRM"));
			}
		};
	}

	public int confirmGoToWork(final Work work) {
		String sql = "UPDATE WORK SET WORK_START_CONFIRM=NOW(), WORK_STATUS=1003 WHERE WORK_SEQ=?";
		return confirmWork(work, sql);
	}

	public int confirmLeaveWork(final Work work) {
		String sql = "UPDATE WORK SET WORK_FINISH_CONFIRM=NOW(), WORK_STATUS=1004 WHERE WORK_SEQ=?";
		return confirmWork(work, sql);
	}

	public int confirmBoth(final Work work) {
		String sql = "UPDATE WORK SET WORK_START_CONFIRM=NOW(), WORK_FINISH_CONFIRM=NOW(), WORK_STATUS=1004 WHERE WORK_SEQ=?";
		return confirmWork(work, sql);
	}

	public int confirmWork(final Work work, String sql) {
		JdbcTemplate template = new JdbcTemplate();
		return template.executeUpdate(sql, work.getSeq());
	}

	public List<Work> selectWorkForAlba(User user) {
		String key = "STO_NAME";
		RowMapper<Work> rm = resultSetOfWorkAndStore(key);
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT W.*, S.STO_NAME FROM WORK W JOIN STORE S ON W.WORK_STO_SEQ = S.STO_SEQ WHERE W.WORK_USER_SEQ = ?";
		return jdbcTemplate.executeQueryList(sql, rm, user.getSeq());
	}

	public List<Work> selectWorkForManager(String storeSeq) {
		String key = "USER_NAME";
		RowMapper<Work> rm = resultSetOfWorkAndStore(key);
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT W.*, U.USER_NAME FROM WORK W JOIN USER U ON W.WORK_USER_SEQ = U.USER_SEQ WHERE W.WORK_STO_SEQ = ?";
		return jdbcTemplate.executeQueryList(sql, rm, storeSeq);
	}

	private RowMapper<Work> resultSetOfWorkAndStore(String key) {
		return new RowMapper<Work>() {
			public Work mapRows(ResultSet rs) throws SQLException {
				return new Work(rs.getString("WORK_SEQ"), rs.getString("WORK_STO_SEQ"), rs.getString("WORK_USER_SEQ"),
						rs.getString("WORK_STATUS"), rs.getString("WORK_START"), rs.getString("WORK_FINISH"),
						rs.getString("WORK_START_CONFIRM"), rs.getString("WORK_FINISH_CONFIRM"), rs.getString(key));
			}
		};
	}

}
