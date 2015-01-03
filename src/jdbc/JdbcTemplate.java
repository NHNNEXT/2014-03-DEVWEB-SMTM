package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Work;
import exception.DbAccessException;

public class JdbcTemplate {

	
	public int executeUpdate(String sql, Object... parameters){
		return executeUpdate(sql, createPreparedStatementSetter(parameters));	
	}

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
			throw new DbAccessException(e);
		} finally {
			try {
				if(pstmt != null) { pstmt.close(); }			
				if(conn != null) { conn.close(); }	
			} catch (SQLException e) {
				throw new DbAccessException(e);
			}
		}
		return updatedRows;
	}
	
	public <T> T executeQuery(String sql, RowMapper<T> rm, Object... parameters){
		return executeQuery(sql, rm, createPreparedStatementSetter(parameters));
	}
	
	public <T> T executeQuery(String sql, RowMapper<T> rm, PreparedStatementSetter pss) {
		ArrayList<T> list = executeQueryList(sql, rm, pss);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	
	public <T> ArrayList<T> executeQueryList(String sql, RowMapper<T> rm, Object... parameters) {
		return executeQueryList(sql, rm, createPreparedStatementSetter(parameters));
	}
	
	public <T> ArrayList<T> executeQueryList(String sql, RowMapper<T> rm, PreparedStatementSetter pss) {
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
			throw new DbAccessException(e);
		} finally {
			try {
				if(rs != null) { rs.close(); }
				if(pstmt != null) { pstmt.close(); }			
				if(conn != null) { conn.close(); }	
			} catch (SQLException e) {
				throw new DbAccessException(e);
			}
		}
		return list;
	}
	
	
	private PreparedStatementSetter createPreparedStatementSetter(Object... parameters) {
		return new PreparedStatementSetter() {
			@Override
			public void setParameters(PreparedStatement pstmt) throws SQLException {
				for (int i = 0; i < parameters.length; i++) {
					pstmt.setObject(i + 1, parameters[i]);
				}
			}
		};
	}


	
	
}
