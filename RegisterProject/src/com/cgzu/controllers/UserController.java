package com.cgzu.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.cgzu.helpers.DataBase;
import com.cgzu.helpers.PropertyReader;

public class UserController {
	
	private static PropertyReader pr = PropertyReader.getInstance();
	
	public static String showUser(String User) {
		
		String response = ""; 
		Connection con = DataBase.getConnection();
		String query = pr.getValue("registerUser");	
		List<String> lista = new ArrayList<String>();
		
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, User);
			ResultSet rs = ps.executeQuery();
			
			String name = rs.getString("name");
			String usuario = rs.getString("usuario");
			String email = rs.getString("email");
			String password = rs.getString("password");
			String tlf = rs.getString("tlf");
			String direccion = rs.getString("direccion");
			String ci = rs.getString("ci");
			String apodo = rs.getString("apodo");
			
			lista.add(name);
			lista.add(usuario);
			lista.add(email);
			lista.add(password);
			lista.add(tlf);
			lista.add(direccion);
			lista.add(ci);
			lista.add(apodo);
			
			System.out.print(lista);
			
			if(rs.next()){
				response = usuario;
				System.out.print(response);
			}else {
				System.out.print("Error");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.print("Error");
		}
		return query;
	}
	
	
}
