package conection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	private static String url = "jdbc:sqlserver://localhost:1433";
	private static String password = "";
	private static String user = "";
	private static Connection connection = null;
	
	private static void conectar() {
		try {
			if (connection == null) {
				Class.forName("om.microsoft.sqlserver.jdbc.SQLServerDriver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private SingleConnection() {
		conectar();
	}
	
	static {
		conectar();
	}
	
	public static Connection getConnection() {
		return connection;
	}

}
