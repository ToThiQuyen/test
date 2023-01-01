package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static final String hostName = "localhost";
	private static final String userName = "root";
	private static final String password = "123456";
	private static final String dbName = "bannoithat";
	private static final String url = "jdbc:mysql://" + hostName + ":3306/" + dbName;
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, userName, password);
			System.out.println("kết nối thành công");
			return connection;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Kết nối không thành công" +e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		Connection connection = DBConnect.getConnection();
	}
}
