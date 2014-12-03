package work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Store;
import entity.Usr;

public class WorkDao {
	

	public ArrayList<Store> workDao(Usr usr) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Store> storeList = new ArrayList<Store>();
		
		String address = "jdbc:mysql://10.73.45.134/DEV";
		String id = "erin314";
		String pw = "1234";
		String sql = "SELECT S.STO_SEQ, S.STO_ONR_ID, S.STO_NM, S.STO_ADDR, S.STO_PHONE1 "
				+ "FROM TB_EMPT E "
				+ "JOIN TB_STO S "
				+ "ON E.EMPT_STO_SEQ = S.STO_SEQ WHERE E.EMPT_ALBA_SEQ = ?";	
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usr.getSeq());
			System.out.println("pstmt: "+pstmt); 
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				 storeList.add(new Store(rs.getString("STO_SEQ"), rs.getString("STO_ONR_ID"), rs.getString("STO_NM"), rs.getString("STO_ADDR"), rs.getString("STO_PHONE1")));
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
			if(conn != null) try { conn.close(); } catch (SQLException e) {}				
		}
		
		return storeList;
	}
}
