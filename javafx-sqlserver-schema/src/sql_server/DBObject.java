package sql_server;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public abstract class DBObject {
	
	/*
	 * This class model a create, read, update and delete action
	 * in simple way to encapsulate an object to be used like another
	 * and all the classes that use it like parent class, need to implement 
	 * this actions according to their attributes
	 * 
	 * If is necessary create an another object to a complex stored procedure
	 * you need to create a CallableStatement object and later call using runStoredProcedure from ActionModule
	 * @see ConnectionModule 
	 * */
	
	/**
	 * Unpack an object using the fields in the database table
	 * 
	 * Example:
	 * *******************************************************
	 * T obj = new T();
	 * obj.setParam1(resultSet.getInt("param1");
	 * obj.setParam2(resultSet.getString("param2");
	 * obj.setParam3(resultSet.getFloat("param3");
	 * . . .
	 * obj.setParamN(resutlSet.getDate("param4");
	 * return obj
	 * *******************************************************
	 * */
	public abstract <T> T unpackObjectUsingResulSet(ResultSet resultSet);
	
	/**
	 * Pack an object using the fields in the database table to execute a stored procedure
	 * 
	 * Example:
	 * *******************************************************
	 * CallableStatement callSt = connection.prepareCall("EXEC <storedprocedurename> ?,?,?,?....");
	 * 
	 * callSt.setInt("param1", this.getValue1();
 	 * callSt.setString("param2", this.getValue3();
  	 * callSt.setFloat("param3", this.getValue3();
  	 * . . .
  	 * callSt.setDate("paramN", this.getValueN();
  	 * 
  	 * return callSt;
	 * *******************************************************
	 * */
	public abstract <T> CallableStatement packObjectForProcedure(Connection connection);
}
