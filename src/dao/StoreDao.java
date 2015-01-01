package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JdbcTemplate;
import jdbc.PreparedStatementSetter;
import jdbc.RowMapper;
import entity.Employment;
import entity.Store;

public class StoreDao {
	public int register(final Store store) {
		String currentMethod = new Object() {}.getClass().getEnclosingMethod().getName();
		PreparedStatementSetter pss = new PreparedStatementSetter(){
			public void setParameters(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1,store.getUsr());
				pstmt.setString(2,store.getName());
				pstmt.setString(3,store.getAddr());
				pstmt.setString(4,store.getPhone1());
				pstmt.setString(5,currentMethod);
			}
		};
		JdbcTemplate template = new JdbcTemplate();
		String sql = "INSERT INTO TB_STO(STO_ONR_ID, STO_NM, STO_ADDR, STO_PHONE1,CREATE_USR) VALUES(?,?,?,?,?)";
		return template.executeUpdate(sql, pss);
	}
	
	public int save(final Employment empt) {
		String currentMethod = new Object() {}.getClass().getEnclosingMethod().getName();
		PreparedStatementSetter pss = new PreparedStatementSetter(){
			public void setParameters(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1,empt.getStoreSeq());
				pstmt.setString(2,empt.getUsrSeq());
				pstmt.setString(3,currentMethod);
			}	
		};
		JdbcTemplate template = new JdbcTemplate();		
		
		String sql = "INSERT INTO TB_EMPT(EMPT_STO_SEQ, EMPT_ALBA_SEQ,CREATE_USR) VALUES(?,?,?)";	
		return template.executeUpdate(sql, pss);
	}

	public ArrayList<Store> retrieve(final String storeId, final String usrSeq) {
		PreparedStatementSetter pss = new PreparedStatementSetter(){
			public void setParameters(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, Integer.parseInt(usrSeq));
				pstmt.setString(2,"%"+storeId+"%");	
			}	
		};
		
		RowMapper<Store> rm = new RowMapper<Store>(){
			public Store mapRows(ResultSet rs) throws SQLException {
				return new Store(rs.getString("STO_SEQ"), rs.getString("STO_ONR_ID"), rs.getString("STO_NM"), 
								rs.getString("STO_ADDR"), rs.getString("STO_PHONE1"));
			}
		};
		
		JdbcTemplate template = new JdbcTemplate();
		String sql = "SELECT * FROM TB_STO "
				+"WHERE STO_SEQ NOT IN "
				+"(SELECT EMPT_STO_SEQ FROM TB_EMPT WHERE EMPT_ALBA_SEQ = ?) "
				+"AND STO_NM LIKE ?";

		return template.executeQueryList(sql, pss, rm);
	}

	public Employment retriveEmpt(final Employment empt) {
		PreparedStatementSetter pss = new PreparedStatementSetter(){
			public void setParameters(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1,empt.getStoreSeq());
				pstmt.setString(2,empt.getUsrSeq());
			}	
		};
		
		RowMapper<Employment> rm = new RowMapper<Employment>(){
			public Employment mapRows(ResultSet rs) throws SQLException {
				return new Employment(rs.getString("EMPT_STO_SEQ"), rs.getString("EMPT_ALBA_SEQ"));
			}
		};
		
		JdbcTemplate template = new JdbcTemplate();
		String sql = "SELECT * FROM TB_EMPT WHERE EMPT_STO_SEQ=? AND EMPT_ALBA_SEQ=?";	
		return template.executeQuery(sql, pss, rm);
	}
}
