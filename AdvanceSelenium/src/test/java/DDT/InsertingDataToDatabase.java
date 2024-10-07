package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertingDataToDatabase {

	public static void main(String[] args) throws Throwable {
		//step 1 : Register/load mysql database
				Driver driverref = new Driver();
				DriverManager.registerDriver(driverref);
				
				//step 2 : get the connection of database
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceselenium", "root", "root");
				
				//step 3 : create a SQL statement
				Statement state = conn.createStatement();
				String query = "insert into selenium (id,first_name,last_name,address)values('4','rathin','jathin','nasik')";
				
				int result = state.executeUpdate(query);
				
				if(result==1)  //if we will give +1 then data gets added and if we give -1 then we don't want to add data
				{
					System.out.println("....Data is added....");
				}
				else
				{
					System.out.println("...Data not added...");
				}
				conn.close();
	}

}
