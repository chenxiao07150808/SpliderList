package com.gdmec.CarType;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DateHelper {
  public static Connection conn=null;
  public DateHelper(){
	  conn=MySqlHelper.connectionMySQL();
  }
  public static void insert(String Name,String Type,String price){
	   String cmd="insert into car(Name,Type,price)values( '"+Name+"','"+Type+"','"+price+"')";
  
	   try {
		Statement state=conn.prepareStatement(cmd);
		state.executeUpdate(cmd);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  
  }
}
