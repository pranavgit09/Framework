package testNG;
//Booking bus tickets

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class DataProviderEx2 {

@Test(dataProvider = "dataProvider_BookTickets")
public void bookTickets(String src,String dest,int noppl)
{
	System.out.println("Book tickets from "+src+" to "+dest+" number of people travelling "+noppl);
}

@DataProvider
	
	public Object[][] dataProvider_BookTickets()
	{
		Object[][] objArr  = new Object[2][3];
		
		objArr[0][0]="Bangalore";
		objArr[0][1]="Goa";
		objArr[0][2]=5;
		
		objArr[1][0]="Bangalore";
		objArr[1][1]="Mysore";
		objArr[1][2]=9;
				
		return objArr;
	}
}
