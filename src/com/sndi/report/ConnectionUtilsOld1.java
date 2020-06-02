package com.sndi.report;

import java.sql.Connection;
import java.sql.SQLException;
 
public class ConnectionUtilsOld1 {
 
    public static Connection getConnection() throws SQLException,
            ClassNotFoundException {
 
        // Using Oracle
        // You may be replaced by other Database.
        return OracleConnUtils.getOracleConnection();
    }
 
    //
    // Test Connection ...
    //
    public static void main(String[] args) throws SQLException,
            ClassNotFoundException {
 
        System.out.println("Get connection ... ");
 
        // Get a Connection object
        Connection conn = ConnectionUtilsOld1.getConnection();
 
        System.out.println("Get connection " + conn);
 
        System.out.println("Done!");
    }
}
