package testNG;

import org.testng.annotations.Test;

public class SampleTest {

	@Test(invocationCount = 3)
	public void createProductTest() 
	{
		System.out.println("product created");
	}
	
	@Test(priority = 1)
	public void modifyProductTest()
	{
		System.out.println("product modified");
	}
	
	@Test(dependsOnMethods = {"createProductTest","modifyProductTest"})
	public void deleteProductTest()
	{
		System.out.println("product deleted");
	}
}
