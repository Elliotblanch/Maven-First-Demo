package jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCDemo {
	
	// Create some variables that our JDBC will use
	// final - this variable can never change
	final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://localhost:3306/cafe";
	final String USER = "root";
	final String PASSWORD = "root";
	
	// There are scrapers on github that go through reops and find
	// passwords connected to this repos email, and can be use
	// to steal your data
	
	// import - Connection from java.sql
	Connection conn;

	
	// Method to connect to database
	public Connection connect() {
		// try {contains the code we are attempting to do}
		try {
			Class.forName(JDBC_DRIVER); // finding our JDBC driver to use
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connected to database");
		} catch (Exception e) { // catch {contains what to do if there's an error in the try{} }
			e.printStackTrace(); 
			// catch method takes in an exception, exception is an object that is an error
			// print the details of this error
			
		}
		
		return conn; //return the connection we have created
	}
	
	
}
