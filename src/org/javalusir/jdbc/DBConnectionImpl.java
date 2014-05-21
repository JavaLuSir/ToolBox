package org.javalusir.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.javalusir.interfaces.IDBConnection;

/**
 * DBConnection 
 * @author javalusir
 * 
 */
public class DBConnectionImpl implements IDBConnection{

	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private String dbUrl="jdbc:oracle:thin:@192.168.1.100:1521:ORCL";
	private String user="";
	private String pass="";
	private Connection conn = null;
	/**
	 * default constructor
	 */
	public DBConnectionImpl(){
		
	}
	/**
	 *  constructor by url user pass;
	 */
	public DBConnectionImpl(String dbUrl, String user, String pass) {
		this.dbUrl = dbUrl;
		this.user = user;
		this.pass = pass;
	}
	/**
	 * get Connection;
	 * @return conn this is Connection object
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName(DRIVER);
		conn=DriverManager.getConnection(this.getDbUrl(), this.getUser(), this.getPass());
		return conn;
	}
	/**
	 * close connection;
	 * @throws SQLException
	 */
	public void colseConn() throws SQLException{
		conn.close();
	};
	/**
	 * get a Statement object
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Statement getStatement() throws SQLException, ClassNotFoundException{
		return getConnection().createStatement();
	}
	
//--------------SET/GET--------------------------------------
	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}
}
