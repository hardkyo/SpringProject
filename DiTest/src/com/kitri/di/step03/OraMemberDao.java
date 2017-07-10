package com.kitri.di.step03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OraMemberDao extends MemberDao {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.31:1521:orcl", "kitri", "kitri");
		return conn;
	}
}
