package com.kitri.di.step07;

import java.sql.*;

public class OraDBConnection implements DBConnection {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.31:1521:orcl", "kitri", "kitri");
		return conn;
	}
	
}
