import java.sql.*;

public class ProductDAO { private String name;
private double price;

public void addProduct(ProductDAO product) 
		throws SQLException { Connection conn = ConnectionDatabase.getConnection(); 
		String sql = "INSERT INTO products (name, price) VALUES (?, ?)"; 
		PreparedStatement stmt = conn.prepareStatement(sql); 
		stmt.setString(1, product.name); 
		stmt.setDouble(2, product.price); 
		stmt.executeUpdate(); conn.close(); 
		} 
}