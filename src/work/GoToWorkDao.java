package work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Store;
import entity.Usr;

public class GoToWorkDao {
	
	public int workDao(Usr usr, String storeSeq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		//PreparedStatement pstmt2 = null;

		String address = "jdbc:mysql://10.73.45.134/DEV";
		String id = "erin314";
		String pw = "1234";
		String sql = "INSERT INTO TB_WORK(WRK_STO_SEQ, WRK_ALBA_SEQ, WRK_START) VALUES(?,?,NOW())";	
		//String sql2 = "SELECT LAST_INSERT_ID()";
		int updatedRows = 0;
		//int insertedWorkSeq = 0;
		//ResultSet rs;

		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(storeSeq));
			pstmt.setString(2, usr.getSeq());
			System.out.println("pstmt: "+pstmt); 
			
			updatedRows = pstmt.executeUpdate();
			//pstmt2 = conn.prepareStatement(sql2);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
			//if(pstmt2 != null) try { pstmt.close(); } catch (SQLException e) {}				
			if(conn != null) try { conn.close(); } catch (SQLException e) {}				
		}
		
		return updatedRows;
	}
}
