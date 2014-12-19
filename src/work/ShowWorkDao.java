package work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Usr;
import entity.Work;

public class ShowWorkDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<Work> workList = new ArrayList<Work>();
	String address = "jdbc:mysql://10.73.45.134/DEV";
	String id = "erin314";
	String pw = "1234";

	public ArrayList<Work> showWorkDao(Usr usr) {
		String sql = "SELECT * FROM TB_WORK WHERE WRK_ALBA_SEQ = ? WHERE WRK_STUS = 1004";	
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usr.getSeq());
			System.out.println("pstmt: "+pstmt); 
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				 workList.add(new Work(rs.getString("WRK_SEQ"), rs.getString("WRK_STO_SEQ"), rs.getString("WRK_ALBA_SEQ"), rs.getString("WRK_STUS"), rs.getString("WRK_START"), rs.getString("WRK_FINISH"), rs.getString("WRK_START_CONFIRM"), rs.getString("WRK_FINISH_CONFIRM")));
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
