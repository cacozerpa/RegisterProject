package com.cgzu.controllers;

import com.cgzu.helpers.DataBase;
import com.cgzu.helpers.PropertyReader;
import com.cgzu.helpers.Hashing;
import java.sql.*;

public class RegisterController {
		
	private static PropertyReader pr = PropertyReader.getInstance();
	
			public static String register(String name, String User, String Email, String ConfEmail, String Password, String ConfPassword, String Tlf ) {
				String response = ""; 
				Connection con = DataBase.getConnection();
				String query = pr.getValue("registerUser");	
										
				if (checkUser(User)) {
					
					response = "User already Exist!";
					System.out.print(response);
					
				}else {
						if(checkEmail(Email)) {
					
					response = "Email already Exist!";
					System.out.print(response);
						}else {
													
								String HashPass = Hashing.getMD5(Password);
								
								try {
									PreparedStatement ps = con.prepareStatement(query);
									
									
									ps.setString(1, name);
									ps.setString(2, User);
									ps.setString(3, Email);
									ps.setString(4, HashPass);
									ps.setString(5, Tlf);
						
									ps.execute();
									return "registered";
						
								}catch(SQLException e){
									e.printStackTrace();
									System.out.print("ErrorBD");
								}
								
						}

	}
			return query;
				
					
	}
			
	public static boolean checkUser(String User) {
		
		Connection con = DataBase.getConnection();
		String query = pr.getValue("checkUser");
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, User);
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()){
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}
	
	public static boolean checkEmail(String Email) {
		
		Connection con = DataBase.getConnection();
		String query = pr.getValue("checkEmail");
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, Email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
