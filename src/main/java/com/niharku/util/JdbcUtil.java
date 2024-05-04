package com.niharku.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	
	
	
	public static Connection getConnection() throws SQLException, IOException {
		
		String path = "src/main/resources/application.properties";
		FileInputStream fis = new FileInputStream(path);
		Properties pr = new Properties();
		pr.load(fis);
		
		Connection conn = DriverManager.getConnection(pr.getProperty("url"), pr.getProperty("user"), pr.getProperty("password"));
		return conn;
	}
	
	public static void removeConnection(Connection conn, Statement st, ResultSet rs) throws SQLException {
		if(conn != null)
			conn.close();
		if(st != null)
			st.close();
		if(rs != null)
			rs.close();
	}

}
