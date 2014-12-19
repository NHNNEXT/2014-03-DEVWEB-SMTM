package work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Work;
import entity.WorkAndUsrName;

public class SelectWorkDao {
	public ArrayList<WorkAndUsrName> selectWorkDao(String storeSeq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<WorkAndUsrName> workAndUsrNameList = new ArrayList<WorkAndUsrName>();
		String address = "jdbc:mysql://10.73.45.134/DEV";
		String id = "erin314";
		String pw = "1234";
		String sql = "SELECT W.WRK_SEQ, W.WRK_STO_SEQ, W.WRK_ALBA_SEQ, W.WRK_STUS, W.WRK_START, W.WRK_FINISH, U.USR_NM FROM TB_WORK W "
				+ "JOIN TB_USR U "
				+ "ON W.WRK_ALBA_SEQ = U.USR_SEQ WHERE (W.WRK_STO_SEQ = ? AND (W.WRK_STUS = 1001 OR W.WRK_STUS = 1002 OR W.WRK_STUS = 1003))";
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, storeSeq);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				Work work = new Work(rs.getString("WRK_SEQ"), rs.getString("WRK_STO_SEQ"), rs.getString("WRK_ALBA_SEQ"), rs.getString("WRK_STUS"), rs.getString("WRK_START"), rs.getString("WRK_FINISH"));
				workAndUsrNameList.add(new WorkAndUsrName(work, rs.getString("USR_NM")));
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
			if(conn != null) try { conn.close(); } catch (SQLException e) {}				
		}
		return workAndUsrNameList;
	}
}
