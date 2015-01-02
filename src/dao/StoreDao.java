package dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JdbcTemplate;
import jdbc.RowMapper;
import entity.Employment;
import entity.Store;
import entity.Usr;

public class StoreDao {
	public int register(final Store store) {
		String currentMethod = new Object() {}.getClass().getEnclosingMethod().getName();
		JdbcTemplate template = new JdbcTemplate();
		String sql = "INSERT INTO TB_STO(STO_ONR_ID, STO_NM, STO_ADDR, STO_PHONE1,CREATE_USR) VALUES(?,?,?,?,?)";
		return template.executeUpdate(sql, store.getUsr(), store.getName(), store.getAddr(), store.getPhone1(), currentMethod);
	}
	
	public int save(final Employment empt) {
		String currentMethod = new Object() {}.getClass().getEnclosingMethod().getName();
		JdbcTemplate template = new JdbcTemplate();
		String sql = "INSERT INTO TB_EMPT(EMPT_STO_SEQ, EMPT_ALBA_SEQ, CREATE_USR) VALUES(?,?,?)";	
		return template.executeUpdate(sql, empt.getStoreSeq(), empt.getUsrSeq(), currentMethod);
	}

	public ArrayList<Store> retrieve(final String storeId, final String usrSeq) {

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

		return template.executeQueryList(sql, rm, Integer.parseInt(usrSeq), "%"+storeId+"%");
	}

	public Employment retriveEmpt(final Employment empt) {
		
		RowMapper<Employment> rm = new RowMapper<Employment>(){
			public Employment mapRows(ResultSet rs) throws SQLException {
				return new Employment(rs.getString("EMPT_STO_SEQ"), rs.getString("EMPT_ALBA_SEQ"));
			}
		};
		
		JdbcTemplate template = new JdbcTemplate();
		String sql = "SELECT * FROM TB_EMPT WHERE EMPT_STO_SEQ=? AND EMPT_ALBA_SEQ=?";	
		return template.executeQuery(sql, rm, empt.getStoreSeq(), empt.getUsrSeq());
	}
	
	public ArrayList<Store> selectStoreForAlba(final Usr usr) {
		
		RowMapper<Store> rm = new RowMapper<Store>(){
			public Store mapRows(ResultSet rs) throws SQLException {
				return new Store(rs.getString("STO_SEQ"), rs.getString("STO_ONR_ID"), rs.getString("STO_NM"), rs.getString("STO_ADDR"), rs.getString("STO_PHONE1"));
			}
		};
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT S.STO_SEQ, S.STO_ONR_ID, S.STO_NM, S.STO_ADDR, S.STO_PHONE1 "
				+ "FROM TB_EMPT E "
				+ "JOIN TB_STO S "
				+ "ON E.EMPT_STO_SEQ = S.STO_SEQ WHERE E.EMPT_ALBA_SEQ = ?";	

		return jdbcTemplate.executeQueryList(sql, rm, usr.getSeq());
	}
	
	public ArrayList<Store> selectStoreForManager(final Usr usr) {
		
		RowMapper<Store> rm = new RowMapper<Store>(){
			public Store mapRows(ResultSet rs) throws SQLException {
				return new Store(rs.getString("STO_SEQ"), rs.getString("STO_ONR_ID"), rs.getString("STO_NM"), rs.getString("STO_ADDR"), rs.getString("STO_PHONE1"));
			}
		};
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT STO_SEQ, STO_ONR_ID, STO_NM, STO_ADDR, STO_PHONE1 "
				+ "FROM TB_STO "
				+ "WHERE STO_ONR_ID = ?";	

		return jdbcTemplate.executeQueryList(sql, rm, usr.getId());
	}

	public Store findStore(String name, String addr) {
		
		RowMapper<Store> rm = new RowMapper<Store>(){
			public Store mapRows(ResultSet rs) throws SQLException {
				return new Store(rs.getString("STO_SEQ"), rs.getString("STO_ONR_ID"), rs.getString("STO_NM"), 
								rs.getString("STO_ADDR"), rs.getString("STO_PHONE1"));
			}
		};
		
		JdbcTemplate template = new JdbcTemplate();
		String sql = "SELECT * FROM TB_STO "
				+"WHERE STO_NM = ? AND STO_ADDR = ?";
		return template.executeQuery(sql, rm, name, addr);
	}
}
