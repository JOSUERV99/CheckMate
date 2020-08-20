package sql_server;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActionModule {
	
	/**
	 * Get all the registers that the query returned like a object list using the schema from
	 * objectInstance given as a parameter
	 * @param T objectEmptyInstance object type to storage in the list
	 * @param Connection connection the current connection to SQL server
	 * @param String query, code in SQL server to execute in the run process
	 * @since 19/08/2020
	 * */
	public static <T extends DBObject> List<T> getObjectListFromQuery( Connection connection, T objectEmptyInstance, String query) {
		
		List<T> dataCollector = new ArrayList<T>();
		
		try {
			if ( connection != null ) {		
				
				PreparedStatement storedProcedure = connection.prepareStatement(query);
				storedProcedure.execute();
				
				ResultSet set = storedProcedure.getResultSet();
				
				while ( set.next() ) 
					dataCollector.add(objectEmptyInstance.unpackObjectUsingResulSet(set));
			}
			else
				throw new NullPointerException();
		} 
		catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		} 
				
		return dataCollector;
	}
	
	/**
	 * Get all the registers that the view returned like a object list using the schema from
	 * objectInstance given as a parameter
	 * @param T objectEmptyInstance object type to storage in the list
	 * @param Connection connection the current connection to SQL server
	 * @param String query, code in SQL server to execute in the run process
	 * @since 19/08/2020
	 * */
	public static <T extends DBObject> List<T> getObjectListFromView( Connection connection, T objectEmptyInstance, String viewName ){
		
		List<T> dataCollector = new ArrayList<T>();
		
		try {
			
			if ( connection != null ) {
					
				PreparedStatement storedProcedure = connection.prepareStatement("SELECT * FROM "+viewName);
				storedProcedure.execute();
				
				ResultSet set = storedProcedure.getResultSet();
				
				while ( set.next() ) 
					dataCollector.add(objectEmptyInstance.unpackObjectUsingResulSet(set));
			}
			else
				throw new NullPointerException();
		} 
		catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		} 
				
		return dataCollector;
	}
	
	/**
	 * Get all the registers that the stored procedure returned like a object list using the schema from
	 * objectInstance given as a parameter
	 * @param T objectEmptyInstance object type to storage in the list
	 * @param Connection connection the current connection to SQL server
	 * @param String query, code in SQL server to execute in the run process
	 * @since 19/08/2020
	 * */
	@SuppressWarnings("unchecked")
	public static <T extends DBObject> List<T> getObjectListUsingStoredProcedure( Connection connection, T objectEmptyInstance, CallableStatement callableStatement ){
		
		ArrayList<T> dataCollector = new ArrayList<T>();
		
		try {			
			if (connection != null) {
									
				callableStatement.execute();
				ResultSet set = callableStatement.getResultSet();
				
				while ( set.next() ) 
					dataCollector.add( (T) objectEmptyInstance.<T> packObjectForProcedure(connection) );
					
			} else
				throw new NullPointerException();
			
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		} 
	
		return dataCollector;
	}
	
	/**
	 * Run a stored procedure using the given parameters
	 * @param connection : SQL Server connection
	 * @param callableStatement : object to call the stored procedure
	 * @return true if all works correctly, false in another way
	 */
	public static boolean runStoredProcedure( Connection connection, CallableStatement callableStatement ){
		
		boolean success = false;
		
		try {			
			if (connection != null) {
				success = callableStatement.execute();
			} else
				throw new NullPointerException();
			
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		} 
		
		return success;
	}
}
