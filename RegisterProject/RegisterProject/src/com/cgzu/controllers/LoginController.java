package com.cgzu.controllers;

import com.cgzu.helpers.DataBase;
import com.cgzu.helpers.Hashing;
import com.cgzu.helpers.PropertyReader;
import java.sql.*;

public class LoginController {
	
	private static PropertyReader pr = PropertyReader.getInstance();

	public static String login(String User, String Password) {
		
		String response = ""; 
		Connection con = DataBase.getConnection();
		String query = pr.getValue("loginUser");	
		
		String HashPass = Hashing.getMD5(Password);
		
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, User);
			ps.setString(2, HashPass);
			
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()){
				response = "Logged!";
				System.out.print(response);
				return "Logged!";
			}else {
				response = "Error";
				System.out.print(response);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		return query;
		
	}
	
}
