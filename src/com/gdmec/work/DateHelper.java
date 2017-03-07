package com.gdmec.work;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.gdmec.work.MySqlHelper;

public class DateHelper {
public static Connection conn=null;
public DateHelper() {
	// TODO Auto-generated constructor stub
	conn=MySqlHelper.connectionMySQL();
}
public static void insert(String title,String price,String detail){
	String sql="insert into myplace(title,price,detail)values( '"+title+"','"+price+"','"+detail+"')";

	try {
		Statement state=conn.prepareStatement(sql);
		state.executeUpdate(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
