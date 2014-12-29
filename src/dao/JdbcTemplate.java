package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JdbcTemplate {

	public int excuteUpdate(String sql, PreparedStatementSetter pss){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int updatedRows = 0;
		
		try {	
			conn = ConnectManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pss.setParameters(pstmt);
//			System.out.println("pstmt: "+pstmt); 
			updatedRows = pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.toString());
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
			if(conn != null) try { conn.close(); } catch (SQLException e) {}				
		}
		return updatedRows;
	}
	
	public <T> T executeQuery(String sql, PreparedStatementSetter pss, RowMapper<T> rm) {
		ArrayList<T> list = excuteQueryList(sql, pss, rm);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	
	public <T> ArrayList<T> excuteQueryList(String sql, PreparedStatementSetter pss, RowMapper<T> rm) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<T> list = new ArrayList<T>();
		
		try {	
			conn = ConnectManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pss.setParameters(pstmt);
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				list.add(rm.mapRows(rs));
			}
		} catch(SQLException e) {
			System.out.println(e.toString());
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
			if(conn != null) try { conn.close(); } catch (SQLException e) {}				
		}
		return list;
	}
}
