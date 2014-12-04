package store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import entity.Store;

public class StoreDao {
	
	public int registerDao(Store store) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String address = "jdbc:mysql://10.73.45.134/DEV";
		String id = "erin314";
		String pw = "1234";
		String sql = "INSERT INTO TB_STO(STO_ONR_ID, STO_NM, STO_ADDR, STO_PHONE1,CREATE_USR) VALUES(?,?,?,?,?)";	
		int updatedRows = 0;
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,store.getUsr());
			pstmt.setString(2,store.getName());
			pstmt.setString(3,store.getAddr());
			pstmt.setString(4,store.getPhone1());
			pstmt.setString(5,new Object() {}.getClass().getEnclosingMethod().getName());
//			System.out.println("pstmt: "+pstmt); 
			
			updatedRows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
			if(conn != null) try { conn.close(); } catch (SQLException e) {}				
		}
		
		System.out.println(store.toString());
		return updatedRows;
	}

	public Map<String,Store> retrieveDao(Store store) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Store> storeList = null;
		
		String address = "jdbc:mysql://10.73.45.134/DEV";
		String id = "erin314";
		String pw = "1234";
		String sql = "SELECT * FROM TB_STO WHERE STO_NM LIKE ?";
		
		//컨벤션 이름 어떻게 ?????
		storeList = new HashMap<String, Store>();
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%"+store.getName()+"%");
			rs = pstmt.executeQuery();
			while(rs.next()){
				storeList.put( rs.getString("STO_SEQ"), 
						new Store(rs.getString("STO_ONR_ID"), rs.getString("STO_NM"), 
							rs.getString("STO_ADDR"), rs.getString("STO_PHONE1")) );
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
