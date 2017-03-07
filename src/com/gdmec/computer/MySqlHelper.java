package com.gdmec.computer;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlHelper {

	public static Connection conn=null;

	
	public static Connection connectionMySQL()
	{
		if(conn==null)
		{
			String className="com.mysql.jdbc.Driver";
			
			String url="jdbc:mysql://127.0.0.1:3306/car?characterEncoding=UTF-8";
			
			String user="root";
			
			String pass="";
			
			try {
				
				Class.forName(className);
				
				conn=DriverManager.getConnection(url,user,pass);
				
				 if(!conn.isClosed()) 
			          System.out.println("Succeeded connecting to the Database!");
				 
				 return conn;
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		}
		else
			return conn;
	}


	public static void disconnect()
	{
		if(conn!=null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
