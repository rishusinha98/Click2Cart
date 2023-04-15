package com.click2cart.WebApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Login 
{
	
//	For Login Customer Account 
	@GetMapping("/api/login/customer")
	public String customerLogin(String email, String password)
	{
	    try 
	    {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Click2Cart", "root", "0000");
	        Statement stmt = con.createStatement();
	        String query = "SELECT * FROM customers WHERE email='" + email + "' AND password='" + password + "'";
	        ResultSet rs = stmt.executeQuery(query);
	        if (rs.next())
	        {
	            return "Customer login successful";
	        }
	        else 
	        {
	            return "Invalid email or password";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Error: " + e.getMessage();
	    }
	           
	}


//	For Login Seller Account
	
	@GetMapping("/api/login/seller")
	public String sellerLogin(String email, String password) {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Click2Cart", "root", "0000");
	        Statement stmt = con.createStatement();
	        String query = "SELECT * FROM seller WHERE email='" + email + "' AND password='" + password + "'";
	        ResultSet rs = stmt.executeQuery(query);
	        if (rs.next()) {
	            return "Seller login successful";
	        } else {
	            return "Invalid email or password";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Error: " + e.getMessage();
	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
