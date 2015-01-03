package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcTemplate;
import jdbc.RowMapper;
import entity.Usr;
import entity.Work;

public class WorkDao {
	public int insertGoToWork(final Usr usr, final String storeSeq) {
		String currentMethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "INSERT INTO TB_WORK(WRK_STO_SEQ, WRK_ALBA_SEQ, WRK_START, CREATE_USR) VALUES(?,?,NOW(),?)";
		return jdbcTemplate.executeUpdate(sql, Integer.parseInt(storeSeq),
				usr.getSeq(), currentMethod);
	}

	public int insertLeaveWork(final Usr usr, final String storeSeq) {
		String currentMethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "UPDATE TB_WORK SET WRK_STUS=1002, WRK_FINISH=NOW(), UPDATE_USR=? WHERE WRK_STUS=1001 AND WRK_STO_SEQ=? AND WRK_ALBA_SEQ=?";
		return jdbcTemplate.executeUpdate(sql, currentMethod,
				Integer.parseInt(storeSeq), usr.getSeq());
	}

	public ArrayList<Work> selectWork(final String storeSeq) {
		RowMapper<Work> rm = resultSetOfWorkAndName();
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT W.*, U.USR_NM FROM TB_WORK W "
				+ "JOIN TB_USR U "
				+ "ON W.WRK_ALBA_SEQ = U.USR_SEQ WHERE (W.WRK_STO_SEQ = ? AND (W.WRK_STUS = 1001 OR W.WRK_STUS = 1002 OR W.WRK_STUS = 1003))";
		return jdbcTemplate.executeQueryList(sql, rm, storeSeq);
	}

	private RowMapper<Work> resultSetOfWorkAndName() {
		return new RowMapper<Work>() {
			public Work mapRows(ResultSet rs) throws SQLException {
				return new Work(rs.getString("WRK_SEQ"),
						rs.getString("WRK_STO_SEQ"),
						rs.getString("WRK_ALBA_SEQ"), rs.getString("WRK_STUS"),
						rs.getString("WRK_START"), rs.getString("WRK_FINISH"),
						rs.getString("WRK_START_CONFIRM"),
						rs.getString("WRK_FINISH_CONFIRM"),
						rs.getString("USR_NM"));
			}
		};
	}

	public ArrayList<Work> showWork(final Usr usr) {
		RowMapper<Work> rm = resultSetOfWork();
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT * FROM TB_WORK WHERE WRK_ALBA_SEQ = ? AND WRK_STUS = 1004";
		return jdbcTemplate.executeQueryList(sql, rm, usr.getSeq());
	}

	public ArrayList<Work> showWorkOfStore(final String storeSeq) {
		RowMapper<Work> rm = resultSetOfWork();
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT * FROM TB_WORK WHERE WRK_STO_SEQ = ? AND WRK_STUS = 1004";
		return jdbcTemplate.executeQueryList(sql, rm, storeSeq);
	}

	public Work getConfirmWorkData(final String seq) {
		RowMapper<Work> rm = resultSetOfWork();
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT WRK_SEQ, WRK_STO_SEQ, WRK_ALBA_SEQ, WRK_STUS, WRK_START, WRK_FINISH, WRK_START_CONFIRM, WRK_FINISH_CONFIRM FROM TB_WORK"
				+ "WHERE WRK_SEQ = ?";
		return jdbcTemplate.executeQuery(sql, rm, Integer.parseInt(seq));
	}

	private RowMapper<Work> resultSetOfWork() {
		return new RowMapper<Work>() {
			public Work mapRows(ResultSet rs) throws SQLException {
				return new Work(rs.getString("WRK_SEQ"),
						rs.getString("WRK_STO_SEQ"),
						rs.getString("WRK_ALBA_SEQ"), rs.getString("WRK_STUS"),
						rs.getString("WRK_START"), rs.getString("WRK_FINISH"),
						rs.getString("WRK_START_CONFIRM"),
						rs.getString("WRK_FINISH_CONFIRM"));
			}
		};
	}
	public int confirmGoToWork(final Work work) {
		String sql = "UPDATE TB_WORK SET WRK_START_CONFIRM=NOW(), WRK_STUS=1003, UPDATE_USR=? WHERE WRK_SEQ=?";
		return confirmWork(work, sql);
	}
	public int confirmLeaveWork(final Work work) {
		String sql = "UPDATE TB_WORK SET WRK_FINISH_CONFIRM=NOW(), WRK_STUS=1004, UPDATE_USR=? WHERE WRK_SEQ=?";
		return confirmWork(work, sql);
	}
	public int confirmBoth(final Work work) {
		String sql = "UPDATE TB_WORK SET WRK_START_CONFIRM=NOW(), WRK_FINISH_CONFIRM=NOW(), WRK_STUS=1004, UPDATE_USR=? WHERE WRK_SEQ=?";	
		return confirmWork(work, sql);
	}
	public int confirmWork(final Work work, String sql){
		String currentMethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		JdbcTemplate template = new JdbcTemplate();
		return template.executeUpdate(sql, currentMethod, work.getSeq());
	}

	public List<Work> selectWorkForAlba(Usr usr) {
		String key="STO_NM";
		RowMapper<Work> rm = resultSetOfWorkAndStore(key);
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT W.*, S.STO_NM FROM TB_WORK W JOIN TB_STO S ON W.WRK_STO_SEQ = S.STO_SEQ WHERE W.WRK_ALBA_SEQ = ?";
		return jdbcTemplate.executeQueryList(sql, rm, usr.getSeq());
	}


	public List<Work> selectWorkForManager(String storeSeq) {
		String key="USR_NM";
		RowMapper<Work> rm = resultSetOfWorkAndStore(key);
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT W.*, U.USR_NM FROM TB_WORK W JOIN TB_USR U ON W.WRK_ALBA_SEQ = U.USR_SEQ WHERE W.WRK_STO_SEQ = ?";
		return jdbcTemplate.executeQueryList(sql, rm, storeSeq);
	}
	
	private RowMapper<Work> resultSetOfWorkAndStore(String key) {
		return new RowMapper<Work>() {
			public Work mapRows(ResultSet rs) throws SQLException {
				return new Work(rs.getString("WRK_SEQ"),
						rs.getString("WRK_STO_SEQ"),
						rs.getString("WRK_ALBA_SEQ"), rs.getString("WRK_STUS"),
						rs.getString("WRK_START"), rs.getString("WRK_FINISH"),
						rs.getString("WRK_START_CONFIRM"),
						rs.getString("WRK_FINISH_CONFIRM"),
						rs.getString(key));
			}
		};
	}

}
