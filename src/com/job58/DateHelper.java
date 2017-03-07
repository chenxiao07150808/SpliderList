package com.job58;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DateHelper {
  public static Connection conn=null;
  public DateHelper(){
	  conn=MySqlHelper.connectionMySQL();
  }
  public static void insert(String title,String location,String pubdate){
	   String cmd="insert into jobinfo (title,location,pubdate)values( '"+title+"','"+location+"','"+pubdate+"')";
  
	   try {
		Statement state=conn.prepareStatement(cmd);
		state.executeUpdate(cmd);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  
  }
}
