package work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Usr;
import entity.Work;

public class ConfirmListDao {
	public ArrayList<Work> confirmListDao(Usr usr) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Work> workList = new ArrayList<Work>();
		String address = "jdbc:mysql://10.73.45.134/DEV";
		String id = "erin314";
		String pw = "1234";

		String sql = "SELECT W.WRK_SEQ, W.WRK_STO_SEQ, W.WRK_ALBA_SEQ, W.WRK_STUS, W.WRK_START, W.WRK_FINISH " 
				+ "FROM TB_WORK W "
				+ "JOIN TB_STO S "
				+ "ON W.WRK_STO_SEQ = S.STO_SEQ "
				+ "WHERE ( S.STO_ONR_ID = ? AND (W.WRK_STUS=1001 OR W.WRK_STUS=1002))";	
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usr.getId());
			System.out.println("pstmt: "+pstmt); 
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				workList.add(new Work(rs.getString("WRK_SEQ"), rs.getString("WRK_STO_SEQ"), rs.getString("WRK_ALBA_SEQ"), rs.getString("WRK_STUS"), rs.getString("WRK_START"), rs.getString("WRK_FINISH")));
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
			if(conn != null) try { conn.close(); } catch (SQLException e) {}				
		}
		return workList;
	}
}
