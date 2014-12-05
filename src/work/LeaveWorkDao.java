package work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Usr;

public class LeaveWorkDao {
	
	public int workDao(Usr usr, String storeSeq) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String address = "jdbc:mysql://10.73.45.134/DEV";
		String id = "erin314";
		String pw = "1234";
		String sql = "UPDATE TB_WORK SET WRK_STUS=1002, WRK_FINISH=NOW() WHERE WRK_STUS=1001 AND WRK_STO_SEQ=? AND WRK_ALBA_SEQ=?";	
		
		int updatedRows = 0;

		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(storeSeq));
			pstmt.setString(2, usr.getSeq());
			System.out.println("pstmt: "+pstmt); 
			
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
