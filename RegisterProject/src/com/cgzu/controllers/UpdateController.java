package com.cgzu.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cgzu.helpers.DataBase;
import com.cgzu.helpers.PropertyReader;

public class UpdateController {
	
	private static PropertyReader pr = PropertyReader.getInstance();

	public static String Update(String Tlf, String Direccion, String Ci, String Apodo,String User) {
		String response = ""; 
		Connection con = DataBase.getConnection();
		String query = pr.getValue("updateUser");	
		
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, Tlf);
			ps.setString(2, Direccion);
			ps.setString(3, Ci);
			ps.setString(4, Apodo);
			ps.setString(5, User);

			ps.execute();
			
			System.out.print(User);
			response = "User Updated";
			System.out.print(response);
			
			return "Updated";

		}catch(SQLException e){
			e.printStackTrace();
			System.out.print("ErrorBD");
		}
		return query;
	}
}
