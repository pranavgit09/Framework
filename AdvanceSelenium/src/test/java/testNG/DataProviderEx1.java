package testNG;
//Booking bus tickets

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class DataProviderEx1 {

@Test(dataProvider = "dataProvider_BookTickets")
public void bookTickets(String src,String dest)
{
	System.out.println("Book tickets from "+src+" to "+dest);
}

@DataProvider
	
	public Object[][] dataProvider_BookTickets()
	{
		Object[][] objArr  = new Object[3][2];
		
		objArr[0][0]="Bangalore";
		objArr[0][1]="Goa";
		
		objArr[1][0]="Bangalore";
		objArr[1][1]="Mysore";
		
		objArr[2][0]="Bangalore";
		objArr[2][1]="chennai";
				
		return objArr;
	}
}
