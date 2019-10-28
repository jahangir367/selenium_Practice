package Selenium.Practice.com.Nisum;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Waits {
	
	 WebDriver driver;
	
	@Test
	public void implicitwait(){
		try {
			System.setProperty("webdriver.gecko.driver",Reusableclass.setPath("/src/drivers/geckodriver.exe"));        //E:/MyTests/Nisum/drivers/geckodriver.exe
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	driver.get("https://www.amazon.in");
	driver.findElement(By.id("a-autoid-0-announce---")).click();
	//Assert.assertEquals(0, 0);
	driver.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	}