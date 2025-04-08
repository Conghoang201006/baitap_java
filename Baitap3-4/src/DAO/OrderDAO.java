package DAO;

 import java.sql.*;

public class OrderDAO { private int customerId;
private double total;

public void addOrder(OrderDAO order) 
		throws SQLException { Connection conn = ConnectionDatabase.getConnection(); 
		String sql = "INSERT INTO orders (customer_id, total) VALUES (?, ?)"; 
		PreparedStatement stmt = conn.prepareStatement(sql); 
		stmt.setInt(1, order.customerId);
		stmt.setDouble(2, order.total); 
		stmt.executeUpdate(); conn.close();
		} 
}