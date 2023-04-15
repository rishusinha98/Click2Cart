package com.click2cart.WebApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@RestController
public class ForgetPasswordEmail
{
//	For Forget Password for customer
	
	@GetMapping("/api/forget_password/customer")
	public String customerForgetPassword(String email) {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Click2Cart", "root", "0000");
	        Statement stmt = con.createStatement();
	        String query = "SELECT * FROM customers WHERE email='" + email + "'";
	        ResultSet rs = stmt.executeQuery(query);
	        if (rs.next()) {
	            Random random = new Random();  
	            int otp = random.nextInt(99999);
	            System.out.println("otp " + otp);
	            PreparedStatement stmt1 = con.prepareStatement("UPDATE customers SET otp=? WHERE email='" + email + "'");
	            stmt1.setInt(1, otp);
	            int i = stmt1.executeUpdate();
	            System.out.println("no of statement " + 1);
	            if(i > 0) {
	                String from = "click2cart.co@gmail.com"; // Own business email
	                String password = "wpzmcpttfyamqmqz"; // password
	                String to = email;
	                String subject = "OTP for Password Reset";
	                String body = "Your OTP for password reset is: " + otp;
	                Properties props = new Properties();
	                props.put("mail.smtp.auth", "true");
	                props.put("mail.smtp.starttls.enable", "true");
	                props.put("mail.smtp.host", "smtp.gmail.com");
	                props.put("mail.smtp.port", "587");
	                Session session = Session.getInstance(props, new Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(from, password);
	                    }
	                });
	                Message message = new MimeMessage(session);
	                message.setFrom(new InternetAddress(from));
	                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
	                message.setSubject(subject);
	                message.setText(body);
	                Transport.send(message);
	                return "Your OTP has been sent to your email address.";
	            }
	            else {
	                return "Try again.";
	            }
	        }
	        else {
	            return "Invalid email id.";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return "";
	   }
	
	
	
//	For Forget Password for Seller
	
	@GetMapping("/api/forget_password/seller")
	public String SellerForgetPassword(String email) {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Click2Cart", "root", "0000");
	        Statement stmt = con.createStatement();
	        String query = "SELECT * FROM seller WHERE email='" + email + "'";
	        ResultSet rs = stmt.executeQuery(query);
	        if (rs.next()) {
	            Random random = new Random();  
	            int otp = random.nextInt(99999);
	            System.out.println("otp " + otp);
	            PreparedStatement stmt1 = con.prepareStatement("UPDATE seller SET otp=? WHERE email='" + email + "'");
	            stmt1.setInt(1, otp);
	            int i = stmt1.executeUpdate();
	            System.out.println("no of statement " + 1);
	            if(i > 0) {
	                String from = "click2cart.co@gmail.com"; // Own business email
	                String password = "wpzmcpttfyamqmqz"; // password
	                String to = email;
	                String subject = "OTP for Password Reset";
	                String body = "Your OTP for password reset is: " + otp;
	                Properties props = new Properties();
	                props.put("mail.smtp.auth", "true");
	                props.put("mail.smtp.starttls.enable", "true");
	                props.put("mail.smtp.host", "smtp.gmail.com");
	                props.put("mail.smtp.port", "587");
	                Session session = Session.getInstance(props, new Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(from, password);
	                    }
	                });
	                Message message = new MimeMessage(session);
	                message.setFrom(new InternetAddress(from));
	                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
	                message.setSubject(subject);
	                message.setText(body);
	                Transport.send(message);
	                return "Your OTP has been sent to your email address.";
	            }
	            else {
	                return "Try again.";
	            }
	        }
	        else {
	            return "Invalid email id.";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return "";
	   }
}
	