package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Usr;

public class LoginDao {

	public Usr loginDao(Usr usr) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Usr returnUsr = null;
		
		String address = "jdbc:mysql://10.73.45.134/DEV";
		String id = "erin314";
		String pw = "1234";
		String sql = "SELECT USR_ID, USR_NM, USR_PW, USR_PHONE1, USR_GENDER, USR_BIRTH FROM TB_USR WHERE USR_ID=? AND USR_PW=?";	
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,usr.getId());
			pstmt.setString(2,usr.getPw());
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				returnUsr = new Usr(rs.getString("USR_ID"), 
						rs.getString("USR_PW"),rs.getString("USR_NM"),rs.getString("USR_PHONE1"),rs.getString("USR_GENDER"),rs.getString("USR_BIRTH"));
	
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
			if(conn != null) try { conn.close(); } catch (SQLException e) {}				
		}
				
		return returnUsr;
		
			
	}

}
