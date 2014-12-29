package register;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.JdbcTemplate;
import dao.PreparedStatementSetter;
import entity.Usr;

public class RegisterDao {
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
