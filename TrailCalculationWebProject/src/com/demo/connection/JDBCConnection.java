package com.demo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class JDBCConnection {
	private static final String DRIVER_NAME =  "com.mysql.cj.jdbc.Driver" ; // "com.mysql.jdbc.Driver"com.mysql.cj.jdbc.Driver;
	private static final String URL = "jdbc:mysql://localhost:3306/calculation";
	private static final String USERNAME = "root";
	private static final String PASSWORD = " ";

	private static Collection connection;

	static {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver class not found");
		}
	}

	public static Connection getConnection() throws SQLException {
		connection = (Collection) DriverManager.getConnection(URL,USERNAME,PASSWORD);
		System.out.println("success");
		return (Connection) connection;
		
	}
	/*public static  Connection get_connection() {
		Connection conn = null;
		try {			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tcalculation","root","");
			System.out.println("success");
		} 
		catch (Exception e) {
			System.out.print(e);
		}
		return conn;
	}*/

	public static void closeConnection(Connection conn) throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}

	public static void closePrepaerdStatement(PreparedStatement stmt) throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
	}

	public static void closeResultSet(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
	}

}
