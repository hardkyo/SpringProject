package com.kitri.di.step08;

import java.sql.*;

public interface DBConnection {

	public Connection getConnection() throws ClassNotFoundException, SQLException;	
}
