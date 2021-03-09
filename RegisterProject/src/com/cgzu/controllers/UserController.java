package com.cgzu.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;


import com.cgzu.helpers.DataBase;
import com.cgzu.helpers.PropertyReader;

public class UserController {
	
	private static PropertyReader pr = PropertyReader.getInstance();
	
	public List<String> showUser(String User) {
		
		JSONObject json = new JSONObject();
		String response = ""; 
		Connection con = DataBase.getConnection();
		String query = pr.getValue("getUser");	
		List<String> lista = new ArrayList<String>();
		
		try {
			
		
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, User);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
			String name = rs.getString("name");
			String usuario = rs.getString("usuario");
			String email = rs.getString("email");
			String password = rs.getString("password");
			String tlf = rs.getString("tlf");
			String direccion = rs.getString("direccion");
			String ci = rs.getString("ci");
			String apodo = rs.getString("apodo");
			
			json.put("name", name);
			json.put("usuario", usuario);
			json.put("email", email);
			json.put("email", email);
			json.put("password", password);
			json.put("tlf", tlf);
			json.put("direccion", direccion);
			json.put("ci", ci);
			json.put("apodo", apodo);
			
			lista.add(json.toString());
			
				response = usuario;
				System.out.print(response);
				
			}else {
				System.out.print("Error");
			}
			return lista;
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.print("Error");
		}
		return null;
	}
	
	
}
