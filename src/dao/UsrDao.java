package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcTemplate;
import jdbc.RowMapper;
import entity.Usr;

public class UsrDao {
	public Usr findUsrById(final String usrId) {
		RowMapper<Usr> rm = resultSetOfUsr();
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT USR_SEQ ,USR_ID, USR_NM, USR_PW, USR_TYPE, USR_PHONE1, USR_GENDER, USR_BIRTH FROM TB_USR WHERE USR_ID=?";	
		return jdbcTemplate.executeQuery(sql, rm, usrId);
	}
	public int insertUsr(final Usr usr) {
		String currentMethod = new Object() {}.getClass().getEnclosingMethod().getName();
		JdbcTemplate template = new JdbcTemplate();
		String sql = "INSERT INTO TB_USR(USR_ID, USR_NM, USR_PW, USR_TYPE, USR_PHONE1, USR_GENDER, USR_BIRTH, CREATE_USR) VALUES(?,?,?,?,?,?,?,?)";	
		return template.executeUpdate(sql, usr.getId(), usr.getName(), usr.getPw(),
				Integer.parseInt(usr.getType()), usr.getPhone1(), usr.getGender(), usr.getBirth(), currentMethod);
	}
	private RowMapper<Usr> resultSetOfUsr() {
		return new RowMapper<Usr>(){
			public Usr mapRows(ResultSet rs) throws SQLException {
				return new Usr(rs.getString("USR_SEQ"), rs.getString("USR_ID"), 
						rs.getString("USR_PW"),rs.getString("USR_NM"), rs.getString("USR_TYPE"),rs.getString("USR_PHONE1"),rs.getString("USR_GENDER"),rs.getString("USR_BIRTH"));
			}
		};
	}
}
