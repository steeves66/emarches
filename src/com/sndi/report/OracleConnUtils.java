package com.sndi.report;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.sndi.utilitaires.GRFProperties;
 
public class OracleConnUtils {
 
    public static Connection getOracleConnection()
            throws ClassNotFoundException, SQLException {
    	 
         
        return getOracleConnection();
    }
 
    public static Connection getConnection() throws ClassNotFoundException,
            SQLException, NamingException {
 
    	InitialContext initialContext = new InitialContext();
    	DataSource dataSource = (DataSource)initialContext.lookup("java:/jdbc/emapDS");
    	/*DataSource dataSource = (DataSource)initialContext.lookup("java:/EmapDS");*/
    	/*DataSource dataSource = (DataSource)initialContext.lookup("java:/jdbc/emapTest"); */
    	Connection conn = dataSource.getConnection();
        return conn;
    }
/*    public static Connection getOracleConnection(String hostName, String sid,
    		String userName, String password) throws ClassNotFoundException,
    SQLException {
    	
    	
    	// Declare the class Driver for ORACLE DB
    	// This is necessary with Java 5 (or older)
    	// Java6 (or newer) automatically find the appropriate driver.
    	// If you use Java> 5, then this line is not needed.    
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	
    	
    	// Example: jdbc:oracle:thin:@localhost:1521:db11g
    	String connectionURL = "jdbc:oracle:thin:@" + hostName + ":1521:" + sid;
    	
    	Connection conn = DriverManager.getConnection(connectionURL, userName,
    			password);
    	return conn;
    }
*/}
