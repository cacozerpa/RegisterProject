package com.cgzu.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cgzu.helpers.*;


public class DeleteController {
	
	private static PropertyReader pr = PropertyReader.getInstance();
	
	public static String Delete(String User, String Password) {
		
		String response = ""; 
		Connection con = DataBase.getConnection();
		String query = pr.getValue("deleteUser");
		
		String HashPass = Hashing.getMD5(Password);
		
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			
			
			ps.setString(1, User);
			ps.setString(2, HashPass);
			
			int delete = ps.executeUpdate();
			
			if(delete > 0 ) {
			 
			response = "Deleted!";
			System.out.print(response);
			return "deleted";
			}else {
				response = "Error";
				System.out.print(response);
			}
			
		}catch(SQLException e) {
			System.out.print("Error SQL");
			e.printStackTrace();
		}
		return null;
	}
	

}
