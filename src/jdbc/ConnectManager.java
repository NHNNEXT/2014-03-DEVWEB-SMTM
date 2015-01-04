package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectManager {
	public static Connection getConnection() {
		String address = "jdbc:mysql://10.73.45.134/PROD";
		String id = "erin314";
		String pw = "1234";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(address, id, pw);
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
}
