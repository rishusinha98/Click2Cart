//package com.click2cart.WebApp;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.Random;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class ForgetPassword 
//{
//	@GetMapping("/api/forget_password/customer")
//	public String customerForgetPassword(String email) {
//	    try {
//	        Class.forName("com.mysql.cj.jdbc.Driver");
//	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Click2Cart", "root", "0000");
//	        Statement stmt = con.createStatement();
//	        String query = "SELECT * FROM customers WHERE email='" + email + "'";
//	        ResultSet rs = stmt.executeQuery(query);
//	        if (rs.next()) {
//	            Random random = new Random();  
//	            int otp = random.nextInt(99999);
//	            System.out.println("otp " + otp);
//	            PreparedStatement stmt1 = con.prepareStatement("UPDATE customers SET otp=? WHERE email='" + email + "'");
//	            stmt1.setInt(1, otp);
//	            int i = stmt1.executeUpdate();
//	            System.out.println("no of statement " + 1);
//	            if (i > 0) {
//	                return "Your OTP is generated";
//	            } else {
//	                return "Try again";
//	            }
//	        } else {
//	            return "Invalid email id";
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        return "Error: " + e.getMessage();
//	    }
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	@GetMapping("/api/forget_password/seller")
//	public String sellerForgetPassword(String email) {
//	    try {
//	        Class.forName("com.mysql.cj.jdbc.Driver");
//	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Click2Cart", "root", "0000");
//	        Statement stmt = con.createStatement();
//	        String query = "SELECT * FROM seller WHERE email='" + email + "'";
//	        ResultSet rs = stmt.executeQuery(query);
//	        if (rs.next()) {
//	            Random random = new Random();  
//	            int otp = random.nextInt(99999);
//	            System.out.println("otp " + otp);
//	            PreparedStatement stmt1 = con.prepareStatement("UPDATE seller SET otp=? WHERE email='" + email + "'");
//	            stmt1.setInt(1, otp);
//	            int i = stmt1.executeUpdate();
//	            System.out.println("no of statement " + 1);
//	            if (i > 0) {
//	                return "Your OTP is generated";
//	            } else {
//	                return "Try again";
//	            }
//	        } else {
//	            return "Invalid email id";
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        return "Error: " + e.getMessage();
//	    }
//	}
//
//	
//	
//	
//	
//
//}
