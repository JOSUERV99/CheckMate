package sql_server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionModule {
	
	/**
	 * Establish a connection between the app and sql server using the integrated
	 * security option
	 * @since 19/08/2020
	 * */
	public static Connection getConnectionWithIntegratedSecurity(String database) {
		
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection( "jdbc:sqlserver://;database="+ database +";integratedSecurity=true;" );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	/**
	 * Establish a connection between the app and sql server using an user currently registered
	 * with a login assigned
	 * @since 19/08/2020
	 * */
	public static Connection getConnectionWithCredentials( String host, String port, String database,String user, String password ) {
		
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection( getUrl( host, port, database, user, password) );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return connection;
	}
	
	/**
	 * Get the connection string given some parameters
	 * @param host as Internet protocol direction, port as input door, database as schema name, user and password for the user currently registered in the database
	 * @since 19/08/2020
	 * */
	private static String getUrl(String host, String port, String database, String usuario, String clave) {
		return 
			"jdbc:sqlserver:"
			+ "//"+host+":"+port+";"
			+ "databaseName="+ database +";"
			+ "user="+ usuario +";"
			+ "password="+clave;
	}
}
