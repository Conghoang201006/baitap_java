package DAO;

import java.sql.*;

public class CustomerDAO { private String name;
private String email;

public void addCustomer(CustomerDAO customerDAO) 
		throws SQLException { Connection conn = ConnectionDatabase.getConnection();
	String sql = "INSERT INTO customers (name, email) VALUES (?, ?)"; 
	PreparedStatement stmt = conn.prepareStatement(sql); 
	stmt.setString(1, customerDAO.name); 
	stmt.setString(2, customerDAO.email); 
	stmt.executeUpdate(); conn.close();
	} 
}