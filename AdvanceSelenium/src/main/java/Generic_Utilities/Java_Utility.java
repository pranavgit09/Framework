package Generic_Utilities;

import java.util.Random;

public class Java_Utility {

	/**
	 * This method is used to avoid Duplicates
	 * @return
	 * @author Diksha
	 */
	public int getRandomNum(){
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;
	}
}
