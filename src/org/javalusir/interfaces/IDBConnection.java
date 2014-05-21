package org.javalusir.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * DBConnection use to connect DataBase
 * @author javalusir
 * 
 */
public interface IDBConnection {

	/**
	 * get a Connection object
	 * @return Connection
	 */
	Connection getConnection () throws SQLException,ClassNotFoundException;
	
	/**
	 * close connection resource
	 * @throws SQLException
	 */
	void colseConn() throws SQLException;
	
	
	
}
