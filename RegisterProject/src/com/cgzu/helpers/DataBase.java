package com.cgzu.helpers;

import java.sql.*;
import com.cgzu.helpers.PropertyReader;

public class DataBase {

	private static PropertyReader pr = PropertyReader.getInstance();
	private static Connection con = null;
	
	public static Connection getConnection(){
		
		
		try {
			Class.forName(pr.getValue("Driver"));
			con= DriverManager.getConnection(pr.getValue("URL"),pr.getValue("User"),pr.getValue("Password"));
		
			pr.getValue("URL");
			pr.getValue("User");
			pr.getValue("Password");
			if (con != null) {
				System.out.println("Conexion establecida!");
			}else {
				System.out.println("Sin Conexion a PSQL!");
			}
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
