package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcTemplate;
import jdbc.RowMapper;
import entity.User;

public class UserDao {
	public User selectUsrById(final String usrId) {
		RowMapper<User> rm = resultSetOfUsr();
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT * FROM USER WHERE USER_ID=?";	
		return jdbcTemplate.executeQuery(sql, rm, usrId);
	}
	public int insertUsr(final User user) {
		JdbcTemplate template = new JdbcTemplate();
		String sql = "INSERT INTO USER(USER_ID, USER_NAME, USER_PW, USER_TYPE, USER_PHONE, USER_GENDER, USER_BIRTH) VALUES(?,?,?,?,?,?,?)";	
		return template.executeUpdate(sql, user.getId(), user.getName(), user.getPw(),
				Integer.parseInt(user.getType()), user.getPhone(), user.getGender(), user.getBirth());
	}
	private RowMapper<User> resultSetOfUsr() {
		return new RowMapper<User>(){
			public User mapRows(ResultSet rs) throws SQLException {
				return new User(rs.getString("USER_SEQ"), rs.getString("USER_ID"), 
						rs.getString("USER_PW"),rs.getString("USER_NAME"), rs.getString("USER_TYPE"),rs.getString("USER_PHONE"),rs.getString("USER_GENDER"),rs.getString("USER_BIRTH"));
			}
		};
	}
}
