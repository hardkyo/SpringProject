package com.kitri.di.step05;

import java.sql.*;

public interface DBConnection {

	public Connection getConnection() throws ClassNotFoundException, SQLException;	
}
