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
		
		String address = "jdbc:mysql://10.73.45.134/SMARTJUNDB";
		String id = "smartjun";
		String pw = "smartjun";
		String sql = "SELECT USR_ID, USR_NM, USR_PW FROM TB_USR WHERE USR_ID=? AND USR_PW=?";	
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,usr.getId());
			pstmt.setString(2,usr.getPw());
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				returnUsr = new Usr(rs.getString("USR_ID"), 
						rs.getString("USR_PW"),rs.getString("USR_NM"));
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
