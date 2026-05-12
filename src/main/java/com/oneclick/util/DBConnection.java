package com.oneclick.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection{

	public static final String URL = "jdbc:mysql://localhost:3306/OneClick_Store";
	public static final String user = "root";
	public static final String pass = "Pass@123";
	
	public static Connection getConnection() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL , user , pass);
			
			System.out.println("Database Connected Successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}