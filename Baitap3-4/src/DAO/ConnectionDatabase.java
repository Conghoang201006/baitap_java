package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {
	private static final String url = "jdbc:sqlserver://localhost:1433;databaseName=OrderManagement;encrypt=false;trustServerCertificate=false;";
	private static final String user = "sa";
	private static final String pass = "123";

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Lỗi kết nối đến SQL Server: " + e.getMessage());
			throw new RuntimeException("Vui lòng kết nối lại");
		}
	}
}ư


