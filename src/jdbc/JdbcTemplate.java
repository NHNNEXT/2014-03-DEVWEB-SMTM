package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import exception.DataAccessException;

public class JdbcTemplate {
	public int executeUpdate(String sql, PreparedStatementSetter pss) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int updatedRows = 0;
		
		try {	
			conn = ConnectManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pss.setParameters(pstmt);
			updatedRows = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			try {
				if(pstmt != null) { pstmt.close(); }			
				if(conn != null) { conn.close(); }	
			} catch (SQLException e) {
				throw new DataAccessException(e);
			}
		}
		return updatedRows;
	}
	
	public <T> T executeQuery(String sql, PreparedStatementSetter pss, RowMapper<T> rm) {
		ArrayList<T> list = executeQueryList(sql, pss, rm);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	
	public <T> ArrayList<T> executeQueryList(String sql, PreparedStatementSetter pss, RowMapper<T> rm) {
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
			throw new DataAccessException(e);
		} finally {
			try {
				if(rs != null) { rs.close(); }
				if(pstmt != null) { pstmt.close(); }			
				if(conn != null) { conn.close(); }	
			} catch (SQLException e) {
				throw new DataAccessException(e);
			}
		}
		return list;
	}
}
