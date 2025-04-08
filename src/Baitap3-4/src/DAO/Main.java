package DAO;

import java.sql.SQLException;

public class Main { public static void main(String[] args) { 
	 try { CustomerDAO customerDAO = new CustomerDAO(); 
 OrderDAO orderDAO = new OrderDAO();
 ProductDAO productDAO = new ProductDAO();

 		Customer customer = new Customer(0, "Nguyen Van A", "a@gmail.com");
 			customerDAO.addCustomer(customer);
        
        Product product = new Product(0, "Laptop", 1500.0);
        	productDAO.addProduct(product);
        
        Order order = new Order(0, 1, 1500.0);
        	orderDAO.addOrder(order);
        
        System.out.println("Thêm khách hàng, sản phẩm và đơn hàng thành công!");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}