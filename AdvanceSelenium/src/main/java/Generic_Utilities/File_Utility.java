package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {

	/**
	 * This method is used to read data from properties file
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author Diksha
	 */
	public String getPropertiesData(String key) throws Throwable{
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\hi\\Desktop\\Java\\Advance selenium\\commonData.properties.txt");

		// step2:-create an object to property class to load all the keys
		Properties pro = new Properties();
		pro.load(fis);

		// step3:-read the value using getProperty()
		String value = pro.getProperty(key);
		return value;
	}
}
