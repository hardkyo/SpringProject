package com.kitri.di.step07;

import java.sql.*;

public interface DBConnection {

	public Connection getConnection() throws ClassNotFoundException, SQLException;	
}
