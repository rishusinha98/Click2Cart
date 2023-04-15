package com.click2cart.WebApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Registation 
{
	
//	For Register a new Seller
	
	@GetMapping("/api/register/Seller")
	public String registerUser(String email, String password, String Name, String mobile_no, String address) {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Click2Cart", "root", "0000");
	        Statement stmt = con.createStatement();
	        String query = "INSERT INTO seller (email, password, Name, mobile_no, address) VALUES ('" + email + "', '" + password + "', '" + Name + "', '" + mobile_no + "', '"+address+"')";
	        int i = stmt.executeUpdate(query);
	        if (i > 0) {
	            return "User registered successfully";
	        } else {
	            return "User registration failed";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Error: " + e.getMessage();
	    }
	}
	
	
	
	
//	For Register as a new Customer
	
	@GetMapping("/api/register/customer")
	public String registerCustomer(String email, String password, String Name, String mobile_no, String shipping_address) {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Click2Cart", "root", "0000");
	        Statement stmt = con.createStatement();
	        String query = "INSERT INTO customers (email, password, Name, mobile_no, shipping_address) VALUES ('" + email + "', '" + password + "', '" + Name + "', '" + mobile_no + "', '" + shipping_address + "' )";
	        int i = stmt.executeUpdate(query);
	        if (i > 0) {
	            return "Customer registered successfully";
	        } else {
	            return "Customer registration failed";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Error: " + e.getMessage();
	    }
	}

  
}
