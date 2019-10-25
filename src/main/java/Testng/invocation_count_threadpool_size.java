package Testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class invocation_count_threadpool_size {
	
	WebDriver driver;

	
	int count = 0;

	@Test(invocationCount = 5)
	public void test1() {
		count++;
		System.out.println("print the count "+ count);
	}
	
	@Test(invocationCount = 4,threadPoolSize = 2)
	public void test2() {
		System.setProperty("webdriver.gecko.driver", "E:/MyTests/Nisum/drivers/geckodriver.exe");//E:/MyTests/Nisum/drivers/geckodriver.exe
		driver = new FirefoxDriver();
		count++;
		System.out.println("Browserr opened for = "+ count + " time");//
		System.out.println("Test Case two with Thread Id:- "+ Thread.currentThread().getId());
				
		driver.close();
	}
	
	//The test is executed only 4 times out 10 times with in the given 6000 millis seconds
	@Test(invocationCount = 10, invocationTimeOut = 6000)
	public void test3() throws InterruptedException {
	/*	System.setProperty("webdriver.gecko.driver", "E:/MyTests/Nisum/drivers/geckodriver.exe");//E:/MyTests/Nisum/drivers/geckodriver.exe
		driver = new FirefoxDriver();
		*/
		Thread.sleep(3000);		
		count++;
		System.out.println("Browserr opened for = "+ count + " time");//
				
		//driver.close();
	}


}
