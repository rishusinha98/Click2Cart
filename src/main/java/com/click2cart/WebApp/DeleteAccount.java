package com.click2cart.WebApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteAccount 
{
	
	
//	For Delete Customer Account
	@DeleteMapping("/api/delete-customer")
	public String deleteCustomer(String email) {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Click2Cart", "root", "0000");
	        String query = "DELETE FROM customers WHERE email = ?";
	        PreparedStatement pstmt = con.prepareStatement(query);
	        pstmt.setString(1, email);
	        int i = pstmt.executeUpdate();
	        if (i > 0) {
	            return "Your record has been deleted successfully";
	        } else {
	            return "Error occurred while deleting your record";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return "";
	}
	
	
	
	
//	For Delete Seller Account
	
	@DeleteMapping("/api/delete-seller")
	public String deleteSeller(String email) {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Click2Cart", "root", "0000");
	        String query = "DELETE FROM sellers WHERE email = ?";
	        PreparedStatement pstmt = con.prepareStatement(query);
	        pstmt.setString(1, email);
	        int i = pstmt.executeUpdate();
	        if (i > 0) {
	            return "Your record has been deleted successfully";
	        } else {
	            return "Error occurred while deleting your record";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return "";
	}

	
}
