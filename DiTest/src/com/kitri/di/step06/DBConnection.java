package com.kitri.di.step06;

import java.sql.*;

public interface DBConnection {

	public Connection getConnection() throws ClassNotFoundException, SQLException;	
}
