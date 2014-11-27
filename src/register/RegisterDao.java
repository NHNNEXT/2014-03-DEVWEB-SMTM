package register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import entity.Usr;

public class RegisterDao {
	
	public int registerDao(Usr usr) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String address = "jdbc:mysql://10.73.45.134/SMARTJUNDB";
		String id = "smartjun";
		String pw = "smartjun";
		String sql = "INSERT INTO TB_USR(USR_ID, USR_NM, USR_PW) VALUES(?,?,?)";	
		int updatedRows = 0;
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,usr.getId());
			pstmt.setString(2,usr.getName());
			pstmt.setString(3,usr.getPw());
			
			updatedRows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
			if(conn != null) try { conn.close(); } catch (SQLException e) {}				
		}
		
		System.out.println(usr.toString());
		return updatedRows;
	}
}
