package com.click2cart.WebApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Products 
{
	@PostMapping("/api/add-product")
	public String addProduct(String name, String description, double price, int quantity, int sellerId) {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Click2Cart", "root", "0000");
	        Statement stmt = con.createStatement();
	        String query = "INSERT INTO product (name, description, price, quantity, seller_id) VALUES ('" + name + "', '" + description + "', " + price + ", " + quantity + ", " + sellerId + ")";
	        int i = stmt.executeUpdate(query);
	        if (i > 0) {
	            return "Product added successfully";
	        } else {
	            return "Product addition failed";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Error: " + e.getMessage();
	    }
	}

}
