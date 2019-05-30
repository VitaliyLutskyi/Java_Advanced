package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	static String URL = "jdbc:mysql://localhost/magazine_store";
	static String USER_NAME = "root";
	static String USER_PASSWORD = "elephant";
	
	
	public static Connection connect() throws SQLException  {

		return DriverManager.getConnection (URL, USER_NAME, USER_PASSWORD);
	}
}
