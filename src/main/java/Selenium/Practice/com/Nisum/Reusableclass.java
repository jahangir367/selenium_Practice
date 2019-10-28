package Selenium.Practice.com.Nisum;

public class Reusableclass {
	
	public static String setPath(String path) {
		String pathdir = System.getProperty("user.dir");
		//path = \\foldername\\drivername || ex: \\drivers\\chromedriver
		String driverpath = pathdir + path;
		return driverpath;
		}


}
