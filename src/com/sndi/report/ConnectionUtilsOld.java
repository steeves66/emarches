package com.sndi.report;

import java.sql.Connection;

import java.sql.SQLException;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ConnectionUtilsOld {
	@Autowired
	 DataSource dataSource;
 
	 public  Connection getConnection() throws ClassNotFoundException,
     SQLException, NamingException {

	Connection conn = dataSource.getConnection();
 return conn;
}
}
