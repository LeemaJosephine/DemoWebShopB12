package day31;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JBDCConnectorClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Step 1: Provide connection details
		
		String db_url="jdbc:mysql://localhost:3306";
		String username="root";
		String password="root";
		
		// Step 2: Establish the connection
		
		try {
			Connection connection = DriverManager.getConnection(db_url, username, password);
			
			// Step 3: Perform operations
			
				// Step 1: create the statements
			String create_DB="create database employee_DB";
			String useDB="use employee_DB";
			String createTable="create table demo_table (rno int, name varchar(25))";
			String insert="insert into demo_table values (101,'abc'),(102,'bcd'),(103,'cdf')";
			String select="Select * from demo_table";
			String select_details="select rno from demo_table";
			
				// Step 2: Execute the statements.
			
			Statement smt = connection.createStatement();
			
			smt.execute(create_DB);  // DDL
			smt.execute(useDB);
			smt.execute(createTable);
			smt.executeUpdate(insert); // For insert, update, delete 
			
			ResultSet result = smt.executeQuery(select); // specifically for select
			
			while(result.next()) {
				
				System.out.println(result.getInt("rno")+"||"+result.getString("name"));
			}
			
			System.out.println("--Selecting rno alone--");
			ResultSet result_rno = smt.executeQuery(select_details);
			
			while(result_rno.next()) {
				
				System.out.println(result_rno.getInt("rno"));
			}
			// Step 4: Close the connection
			
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
