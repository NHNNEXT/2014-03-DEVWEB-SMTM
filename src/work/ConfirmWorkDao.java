package work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Store;
import entity.Work;

public class ConfirmWorkDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String address = "jdbc:mysql://10.73.45.134/DEV";
	String id = "erin314";
	String pw = "1234";

	public Work getConfirmWorkData(String seq) {
		Work work = null;
		
		String sql = "SELECT WRK_SEQ, WRK_STO_SEQ, WRK_ALBA_SEQ, WRK_STUS, WRK_START, WRK_FINISH, WRK_START_CONFIRM, WRK_FINISH_CONFIRM FROM TB_WORK"
					+ "WHERE WRK_SEQ = ?";	
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(seq));
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				 work = new Work(rs.getString("WRK_SEQ"), rs.getString("WRK_STO_SEQ"), rs.getString("WRK_ALBA_SEQ"),
						 rs.getString("WRK_STUS"), rs.getString("WRK_START"), rs.getString("WRK_FINISH"),
						 rs.getString("WRK_START_CONFIRM"), rs.getString("WRK_FINISH_CONFIRM"));				 
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
			if(conn != null) try { conn.close(); } catch (SQLException e) {}				
		}		
		
		return work;		
	}
	
}
