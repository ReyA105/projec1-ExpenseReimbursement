package com.revature.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Singleton utility for creating and retrieving database connection
 */
public class ConnectionUtil {
	private static ConnectionUtil cu = null;
	private static Properties prop;
	private String url;
	private String username;
	private String password;
	/**
	 * This method should read in the "database.properties" file and load
	 * the values into the Properties variable
	 */
	private ConnectionUtil() {
		ClassLoader classLoader =getClass().getClassLoader();
		InputStream is = classLoader.getResourceAsStream("database.properties");
		prop = new Properties();
		try {
			 prop.load(is);
			 url = (String) prop.getProperty("url");
			 username = (String) prop.getProperty("uname");
			 password = (String) prop.getProperty("pswd");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static synchronized ConnectionUtil getConnectionUtil() {
		if(cu == null)
			cu = new ConnectionUtil();
		return cu;
	}
	
	/**
	 * This method should create and return a Connection object
	 * @return a Connection to the database
	 */
	public Connection getConnection() {
			Connection conn = null;
			try {
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection(this.url,this.username,this.password);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		return conn;
	}
	
	
}
