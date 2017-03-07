package com.gdmec.computer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.gdmec.computer.MySqlHelper;

public class DateHelper {
	public static Connection conn=null;
  public DateHelper() {
   conn=MySqlHelper.connectionMySQL();
}
  public static void insert(String title,String time,String statu,String price,String maxprice){
	  String sql="insert into Carmessage(title,time,statu,price,maxprice)values( '"+title+"','"+time+"','"+statu+"','"+price+"','"+maxprice+"')";
	  try {
		Statement state=conn.prepareStatement(sql);
		state.executeUpdate(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}

