package com.pavikumbhar.javaheart.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataAccessObject {
	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection != null)
			return connection;
		else {
			// Store the database URL in a string
		String serverName = "127.0.0.1";
		String portNumber = "1521";
		String sid = "XE";
		String dbUrl = "jdbc:oracle:thin:@" + serverName + ":" + portNumber
				+ ":" + sid;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// set the url, username and password for the database
		connection = DriverManager.getConnection(dbUrl, "system", "admin");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	}
}