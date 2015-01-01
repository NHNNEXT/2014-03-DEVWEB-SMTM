package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JdbcTemplate;
import jdbc.PreparedStatementSetter;
import jdbc.RowMapper;
import entity.Store;
import entity.Usr;
import entity.Work;
import entity.WorkAndUsrName;

public class WorkDao {
	public int goToWorkDao(final Usr usr, final String storeSeq) {
		PreparedStatementSetter pss = new PreparedStatementSetter(){
			public void setParameters(PreparedStatement pstmt)
					throws SQLException {
				pstmt.setInt(1, Integer.parseInt(storeSeq));
				pstmt.setString(2, usr.getSeq());
			}
		};
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "INSERT INTO TB_WORK(WRK_STO_SEQ, WRK_ALBA_SEQ, WRK_START) VALUES(?,?,NOW())";	
		return jdbcTemplate.executeUpdate(sql, pss);
	}
	
	public int leaveWorkDao(final Usr usr, final String storeSeq) {
		PreparedStatementSetter pss = new PreparedStatementSetter(){
			public void setParameters(PreparedStatement pstmt)
					throws SQLException {
				pstmt.setInt(1, Integer.parseInt(storeSeq));
				pstmt.setString(2, usr.getSeq());
			}
		};
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "UPDATE TB_WORK SET WRK_STUS=1002, WRK_FINISH=NOW() WHERE WRK_STUS=1001 AND WRK_STO_SEQ=? AND WRK_ALBA_SEQ=?";	
		return jdbcTemplate.executeUpdate(sql, pss);
	}
	
	public ArrayList<Store> selectStoreForAlba(final Usr usr) {
		PreparedStatementSetter pss = new PreparedStatementSetter(){
			public void setParameters(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, usr.getSeq());
			}	
		};
		
		RowMapper<Store> rm = new RowMapper<Store>(){
			public Store mapRows(ResultSet rs) throws SQLException {
				return new Store(rs.getString("STO_SEQ"), rs.getString("STO_ONR_ID"), rs.getString("STO_NM"), rs.getString("STO_ADDR"), rs.getString("STO_PHONE1"));
			}
		};
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT S.STO_SEQ, S.STO_ONR_ID, S.STO_NM, S.STO_ADDR, S.STO_PHONE1 "
				+ "FROM TB_EMPT E "
				+ "JOIN TB_STO S "
				+ "ON E.EMPT_STO_SEQ = S.STO_SEQ WHERE E.EMPT_ALBA_SEQ = ?";	

		return jdbcTemplate.executeQueryList(sql, pss, rm);
	}
	
	public ArrayList<Store> selectStoreForManager(final Usr usr) {
		PreparedStatementSetter pss = new PreparedStatementSetter(){
			public void setParameters(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, usr.getId());
			}	
		};
		
		RowMapper<Store> rm = new RowMapper<Store>(){
			public Store mapRows(ResultSet rs) throws SQLException {
				return new Store(rs.getString("STO_SEQ"), rs.getString("STO_ONR_ID"), rs.getString("STO_NM"), rs.getString("STO_ADDR"), rs.getString("STO_PHONE1"));
			}
		};
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT STO_SEQ, STO_ONR_ID, STO_NM, STO_ADDR, STO_PHONE1 "
				+ "FROM TB_STO "
				+ "WHERE STO_ONR_ID = ?";	

		return jdbcTemplate.executeQueryList(sql, pss, rm);
	}
	
	public ArrayList<WorkAndUsrName> selectWorkDao(final String storeSeq) {
		PreparedStatementSetter pss = new PreparedStatementSetter(){
			public void setParameters(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, storeSeq);
			}	
		};
		
		RowMapper<WorkAndUsrName> rm = new RowMapper<WorkAndUsrName>(){
			public WorkAndUsrName mapRows(ResultSet rs) throws SQLException {
				return new WorkAndUsrName(new Work(rs.getString("WRK_SEQ"), rs.getString("WRK_STO_SEQ"), rs.getString("WRK_ALBA_SEQ"), rs.getString("WRK_STUS"), rs.getString("WRK_START"), rs.getString("WRK_FINISH")), rs.getString("USR_NM"));
			}
		};
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT W.WRK_SEQ, W.WRK_STO_SEQ, W.WRK_ALBA_SEQ, W.WRK_STUS, W.WRK_START, W.WRK_FINISH, U.USR_NM FROM TB_WORK W "
				+ "JOIN TB_USR U "
				+ "ON W.WRK_ALBA_SEQ = U.USR_SEQ WHERE (W.WRK_STO_SEQ = ? AND (W.WRK_STUS = 1001 OR W.WRK_STUS = 1002 OR W.WRK_STUS = 1003))";
		

		return jdbcTemplate.executeQueryList(sql, pss, rm);
	}
	
	public ArrayList<Work> showWorkDao(final Usr usr) {
		PreparedStatementSetter pss = new PreparedStatementSetter(){
			public void setParameters(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, usr.getSeq());
			}	
		};
		
		RowMapper<Work> rm = new RowMapper<Work>(){
			public Work mapRows(ResultSet rs) throws SQLException {
				return new Work(rs.getString("WRK_SEQ"), rs.getString("WRK_STO_SEQ"), rs.getString("WRK_ALBA_SEQ"), rs.getString("WRK_STUS"), rs.getString("WRK_START"), rs.getString("WRK_FINISH"), rs.getString("WRK_START_CONFIRM"), rs.getString("WRK_FINISH_CONFIRM"));
			}
		};
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT * FROM TB_WORK WHERE WRK_ALBA_SEQ = ? AND WRK_STUS = 1004";
		return jdbcTemplate.executeQueryList(sql, pss, rm);
	}
	
	public ArrayList<Work> showWorkOfStoreDao(final String storeSeq) {
		PreparedStatementSetter pss = new PreparedStatementSetter(){
			public void setParameters(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, storeSeq);
			}	
		};
		
		RowMapper<Work> rm = new RowMapper<Work>(){
			public Work mapRows(ResultSet rs) throws SQLException {
				return new Work(rs.getString("WRK_SEQ"), rs.getString("WRK_STO_SEQ"), rs.getString("WRK_ALBA_SEQ"), rs.getString("WRK_STUS"), rs.getString("WRK_START"), rs.getString("WRK_FINISH"), rs.getString("WRK_START_CONFIRM"), rs.getString("WRK_FINISH_CONFIRM"));
			}
		};
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT * FROM TB_WORK WHERE WRK_STO_SEQ = ? AND WRK_STUS = 1004";	
		return jdbcTemplate.executeQueryList(sql, pss, rm);
	}
	
	public Work getConfirmWorkData(final String seq) {
		PreparedStatementSetter pss = new PreparedStatementSetter(){
			public void setParameters(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, Integer.parseInt(seq));
			}	
		};
		
		RowMapper<Work> rm = new RowMapper<Work>(){
			public Work mapRows(ResultSet rs) throws SQLException {
				return new Work(rs.getString("WRK_SEQ"), rs.getString("WRK_STO_SEQ"), rs.getString("WRK_ALBA_SEQ"),
						 rs.getString("WRK_STUS"), rs.getString("WRK_START"), rs.getString("WRK_FINISH"),
						 rs.getString("WRK_START_CONFIRM"), rs.getString("WRK_FINISH_CONFIRM"));
			}
		};
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT WRK_SEQ, WRK_STO_SEQ, WRK_ALBA_SEQ, WRK_STUS, WRK_START, WRK_FINISH, WRK_START_CONFIRM, WRK_FINISH_CONFIRM FROM TB_WORK"
				+ "WHERE WRK_SEQ = ?";	
		return jdbcTemplate.executeQuery(sql, pss, rm);
	}

	public int confirmGoToWork(Work work) {
		PreparedStatementSetter pss = new PreparedStatementSetter(){
		public void setParameters(PreparedStatement pstmt)
				throws SQLException {
				pstmt.setString(1, work.getSeq());
			}	
		};
		JdbcTemplate template = new JdbcTemplate();
		String sql = "UPDATE TB_WORK SET WRK_START_CONFIRM=NOW(), WRK_STUS=1003 WHERE WRK_SEQ=?";
		return template.executeUpdate(sql, pss);
	}

	public int confirmBoth(Work work) {
		PreparedStatementSetter pss = new PreparedStatementSetter(){
			public void setParameters(PreparedStatement pstmt)
					throws SQLException {
				pstmt.setString(1, work.getSeq());
				}	
			};
		JdbcTemplate template = new JdbcTemplate();
		String sql = "UPDATE TB_WORK SET WRK_START_CONFIRM=NOW(), WRK_FINISH_CONFIRM=NOW(), WRK_STUS=1004 WHERE WRK_SEQ=?";	
		return template.executeUpdate(sql, pss);
	}

	public int confirmLeaveWork(Work work) {
		PreparedStatementSetter pss = new PreparedStatementSetter(){
			public void setParameters(PreparedStatement pstmt)
					throws SQLException {
					pstmt.setString(1, work.getSeq());
				}	
			};
		JdbcTemplate template = new JdbcTemplate();
		String sql = "UPDATE TB_WORK SET WRK_FINISH_CONFIRM=NOW(), WRK_STUS=1004 WHERE WRK_SEQ=?";	
		return template.executeUpdate(sql, pss);
	}
}
