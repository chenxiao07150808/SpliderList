package com.gdmec.baidu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.gdmec.baidu.MySqlHelper;

public class DateHelper {
	public static Connection conn=null;
  public DateHelper() {
   conn=MySqlHelper.connectionMySQL();
}
  public static void insert(String URL,String mess){
	  String sql="insert into new(URL,mess)values( '"+URL+"','"+mess+"')";
	  try {
		Statement state=conn.prepareStatement(sql);
		state.executeUpdate(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}

