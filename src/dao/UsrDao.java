package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Usr;

public class UsrDao {
	public Usr loginDao(final Usr usr) {
		PreparedStatementSetter pss = new PreparedStatementSetter(){
			public void setParameters(PreparedStatement pstmt)
					throws SQLException {
				pstmt.setString(1,usr.getId());
				pstmt.setString(2,usr.getPw());
			}
		};
		RowMapper<Usr> rm = new RowMapper<Usr>(){
			public Usr mapRows(ResultSet rs) throws SQLException {
				return new Usr(rs.getString("USR_SEQ"), rs.getString("USR_ID"), 
						rs.getString("USR_PW"),rs.getString("USR_NM"), rs.getString("USR_TYPE"),rs.getString("USR_PHONE1"),rs.getString("USR_GENDER"),rs.getString("USR_BIRTH"));
			}
		};
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT USR_SEQ ,USR_ID, USR_NM, USR_PW, USR_TYPE, USR_PHONE1, USR_GENDER, USR_BIRTH FROM TB_USR WHERE USR_ID=? AND USR_PW=?";	
		return jdbcTemplate.executeQuery(sql, pss, rm);
	}
	
	public int registerDao(final Usr usr) {
		
		PreparedStatementSetter pss = new PreparedStatementSetter(){
			public void setParameters(PreparedStatement pstmt)
					throws SQLException {
				pstmt.setString(1,usr.getId());
				pstmt.setString(2,usr.getName());
				pstmt.setString(3,usr.getPw());
				pstmt.setInt(4, Integer.parseInt(usr.getType()));
				pstmt.setString(5,usr.getPhone1());
				pstmt.setString(6,usr.getGender());
				pstmt.setString(7,usr.getBirth());
				pstmt.setString(8,new Object() {}.getClass().getEnclosingMethod().getName());
			}	
		};
		JdbcTemplate template = new JdbcTemplate();
		String sql = "INSERT INTO TB_USR(USR_ID, USR_NM, USR_PW, USR_TYPE, USR_PHONE1, USR_GENDER, USR_BIRTH, CREATE_USR) VALUES(?,?,?,?,?,?,?,?)";	
		return template.excuteUpdate(sql, pss);
	}
}