package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcTemplate;
import jdbc.RowMapper;
import entity.User;

public class UsrDao {
	public User selectUsrById(final String usrId) {
		RowMapper<User> rm = resultSetOfUsr();
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT USR_SEQ ,USR_ID, USR_NM, USR_PW, USR_TYPE, USR_PHONE1, USR_GENDER, USR_BIRTH FROM TB_USR WHERE USR_ID=?";	
		return jdbcTemplate.executeQuery(sql, rm, usrId);
	}
	public int insertUsr(final User usr) {
		String currentMethod = new Object() {}.getClass().getEnclosingMethod().getName();
		JdbcTemplate template = new JdbcTemplate();
		String sql = "INSERT INTO TB_USR(USR_ID, USR_NM, USR_PW, USR_TYPE, USR_PHONE1, USR_GENDER, USR_BIRTH, CREATE_USR) VALUES(?,?,?,?,?,?,?,?)";	
		return template.executeUpdate(sql, usr.getId(), usr.getName(), usr.getPw(),
				Integer.parseInt(usr.getType()), usr.getPhone(), usr.getGender(), usr.getBirth(), currentMethod);
	}
	private RowMapper<User> resultSetOfUsr() {
		return new RowMapper<User>(){
			public User mapRows(ResultSet rs) throws SQLException {
				return new User(rs.getString("USR_SEQ"), rs.getString("USR_ID"), 
						rs.getString("USR_PW"),rs.getString("USR_NM"), rs.getString("USR_TYPE"),rs.getString("USR_PHONE1"),rs.getString("USR_GENDER"),rs.getString("USR_BIRTH"));
			}
		};
	}
}
