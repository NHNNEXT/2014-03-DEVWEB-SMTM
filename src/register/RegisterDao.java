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
		
		String address = "jdbc:mysql://10.73.45.134/DEV";
		String id = "erin314";
		String pw = "1234";
		String sql = "INSERT INTO TB_USR(USR_ID, USR_NM, USR_PW, USR_TYPE, USR_PHONE1, USR_GENDER, USR_BIRTH, CREATE_USR) VALUES(?,?,?,?,?,?,?,?)";	
		int updatedRows = 0;
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,usr.getId());
			pstmt.setString(2,usr.getName());
			pstmt.setString(3,usr.getPw());
			pstmt.setInt(4, Integer.parseInt(usr.getType()));
			pstmt.setString(5,usr.getPhone1());
			pstmt.setString(6,usr.getGender());
			pstmt.setString(7,usr.getBirth());
			pstmt.setString(8,new Object() {}.getClass().getEnclosingMethod().getName());
//			System.out.println("pstmt: "+pstmt); 
			
			updatedRows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
			if(conn != null) try { conn.close(); } catch (SQLException e) {}				
		}
		
		return updatedRows;
	}
}
