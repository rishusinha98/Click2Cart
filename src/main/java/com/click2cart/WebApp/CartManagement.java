package com.click2cart.WebApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartManagement 
{
//	For Add to cart
	
	@PostMapping("/api/add-to-cart")
	public String addToCart(int customerId, int productId, int quantity) {
	    try {
	 
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Click2Cart", "root", "0000");


	        String cartQuery = "SELECT id, quantity FROM cart WHERE customer_id = ? AND product_id = ?";
	        PreparedStatement cartStmt = con.prepareStatement(cartQuery);
	        cartStmt.setInt(1, customerId);
	        cartStmt.setInt(2, productId);
	        ResultSet cartResult = cartStmt.executeQuery();

	        int cartId = 0;
	        int cartQuantity = 0;

	        if (cartResult.next()) {

	            cartId = cartResult.getInt("id");
	            cartQuantity = cartResult.getInt("quantity") + quantity;
	            String updateCartQuery = "UPDATE cart SET quantity = ? WHERE id = ?";
	            PreparedStatement updateCartStmt = con.prepareStatement(updateCartQuery);
	            updateCartStmt.setInt(1, cartQuantity);
	            updateCartStmt.setInt(2, cartId);
	            int i = updateCartStmt.executeUpdate();

	            if (i > 0) {
	                return "Cart updated successfully";
	            }
	        } else {
	         
	            String insertCartQuery = "INSERT INTO cart (customer_id, product_id, quantity) VALUES (?, ?, ?)";
	            PreparedStatement insertCartStmt = con.prepareStatement(insertCartQuery);
	            insertCartStmt.setInt(1, customerId);
	            insertCartStmt.setInt(2, productId);
	            insertCartStmt.setInt(3, quantity);
	            int i = insertCartStmt.executeUpdate();

	            if (i > 0) {
	                return "Product added to cart successfully";
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return "Failed to add product to cart";
	}
	
	
	
	
	
//	For Search the products
	
	@GetMapping("/api/product/search")
	public Map searchProduct(String Name) {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Click2Cart", "root", "0000");
	        String query = "SELECT * FROM products WHERE name LIKE ?";
	        PreparedStatement pstmt = con.prepareStatement(query);
	        pstmt.setString(1, "%" + Name + "%");
	        ResultSet rs = pstmt.executeQuery();
	        ArrayList l= new ArrayList();
	        while (rs.next()) {
	        	Map map=new HashMap();
				map.put("Product ID:" , rs.getString("product_id"));
				map.put("Name:" , rs.getString("name"));
				map.put("Description:" , rs.getString("description"));
				map.put("Price:" , rs.getString("price")); 
				l.add(map);
	        }
	        Map data=new HashMap();
	        data.put("ProductDetail",l);
	        return data;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


