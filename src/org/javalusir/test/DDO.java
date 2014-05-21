package org.javalusir.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.sql.DataSource;

public class DDO {

	public static void main(String[] args) {
		DBCPDataSource db = DBCPDataSource.getDBCPDataSource();
		/*BasicDataSource bd = new BasicDataSource();
		bd.setDriverClassName(DBCPDataSource.DRIVER_CLASS);
		bd.setUrl(DBCPDataSource.URL);
		bd.setUsername(DBCPDataSource.USER);
		bd.setPassword(DBCPDataSource.PASS);
		
		try {
			Connection conn = bd.getConnection();
			PreparedStatement pst = conn.prepareStatement("select * from emp");
			pst.executeQuery();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		try {
			
			DataSource datasource = db.getDataSourceInstance();
			Connection conn = datasource.getConnection();
			//Statement st = conn.createStatement();
			//st.execute("select * from emp");
			PreparedStatement stmt = conn.prepareStatement("insert into emp (empno) values (?)");
			stmt.setInt(1, 1237);
			stmt.execute();
			//ResultSet rs = stmt.getResultSet();
			/*while(rs.next()){ 
				System.out.println(rs.getString(1));
			}*/
			
			conn.commit();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		
}
