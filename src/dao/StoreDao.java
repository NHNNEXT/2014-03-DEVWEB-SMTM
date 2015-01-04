package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JdbcTemplate;
import jdbc.RowMapper;
import entity.Employment;
import entity.Store;
import entity.User;

public class StoreDao {
	public int insertStore(final Store store) {
		JdbcTemplate template = new JdbcTemplate();
		String sql = "INSERT INTO STORE(STO_USER_SEQ, STO_NAME, STO_ADDR, STO_PHONE) VALUES(?,?,?,?)";
		return template.executeUpdate(sql, store.getUserSeq(), store.getName(), store.getAddr(), store.getPhone());
	}

	public int insertEmpt(final Employment empt) {
		JdbcTemplate template = new JdbcTemplate();
		String sql = "INSERT INTO EMPLOYMENT(EMPT_STO_SEQ, EMPT_USER_SEQ) VALUES(?,?)";
		return template.executeUpdate(sql, empt.getStoreSeq(), empt.getUserSeq());
	}

	public Store retriveStoreForMake(final String name, final String addr) {
		RowMapper<Store> rm = resultSetOfStore();
		JdbcTemplate template = new JdbcTemplate();
		String sql = "SELECT S.*, U.USER_NAME FROM STORE S JOIN USER U ON U.USER_SEQ = S.STO_USER_SEQ WHERE S.STO_NAME = ? AND S.STO_ADDR = ?";
		return template.executeQuery(sql, rm, name, addr);
	}

	public ArrayList<Store> retrieveStoreForEmpt(final String storeId, final String userSeq) {
		RowMapper<Store> rm = resultSetOfStore();
		JdbcTemplate template = new JdbcTemplate();
		String sql = "SELECT S.*, U.USER_NAME FROM STORE S JOIN USER U ON U.USER_SEQ = S.STO_USER_SEQ WHERE S.STO_SEQ NOT IN (SELECT EMPT_STO_SEQ FROM EMPLOYMENT WHERE EMPT_USER_SEQ = ?) AND S.STO_NAME LIKE ?";
		return template.executeQueryList(sql, rm, Integer.parseInt(userSeq), "%" + storeId + "%");
	}

	public ArrayList<Store> selectStoreForAlba(final User user) {
		RowMapper<Store> rm = resultSetOfStore();
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT S.*, U.USER_NAME FROM EMPLOYMENT E " + "JOIN STORE S ON E.EMPT_STO_SEQ = S.STO_SEQ "
				+ "JOIN USER U ON U.USER_SEQ = S.STO_USER_SEQ " + "WHERE E.EMPT_USER_SEQ = ?";
		return jdbcTemplate.executeQueryList(sql, rm, user.getSeq());
	}

	public ArrayList<Store> selectStoreForManager(final User user) {
		RowMapper<Store> rm = resultSetOfStore();
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT S.*, U.USER_NAME FROM STORE S JOIN USER U ON S.STO_USER_SEQ = U.USER_SEQ WHERE S.STO_USER_SEQ = ?;";
		return jdbcTemplate.executeQueryList(sql, rm, user.getSeq());
	}

	private RowMapper<Store> resultSetOfStore() {
		return new RowMapper<Store>() {
			public Store mapRows(ResultSet rs) throws SQLException {
				return new Store(rs.getString("STO_SEQ"), rs.getString("STO_USER_SEQ"), rs.getString("STO_NAME"),
						rs.getString("STO_ADDR"), rs.getString("STO_PHONE"), rs.getString("USER_NAME"));
			}
		};
	}

}
