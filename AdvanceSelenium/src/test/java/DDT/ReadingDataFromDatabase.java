package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadingDataFromDatabase {

	public static void main(String[] args) throws Throwable {
		
		//step 1 : Register/load mysql database
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		//step 2 : get the connection of database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceselenium", "root", "root");
		
		//step 3 : create a SQL statement
		Statement state = conn.createStatement();
		String query = "select * from selenium";
		
		//step 4 : execute statement/Query
		ResultSet result = state.executeQuery(query);
		
		while(result.next())
		{
			//"\t" used for giving space in between and getInt 1,2,3,4 is for getting fields from database
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		conn.close();          //closing database connection
	
	}

}
