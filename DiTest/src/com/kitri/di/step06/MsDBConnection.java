package com.kitri.di.step06;

import java.sql.*;

public class MsDBConnection implements DBConnection {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn;
		Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
		conn = DriverManager.getConnection("jdbc:microsoft:sqlser://192.168.18.31:1433;DatabaseName=myserver", "kitri", "kitri");
		return conn;
	}
	
}
