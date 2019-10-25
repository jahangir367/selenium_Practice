package Testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Alwaysrun_skip {
	WebDriver driver;

	@BeforeMethod(alwaysRun = true)

	public void setupSuite() {

		System.setProperty("webdriver.gecko.driver", "E:/MyTests/Nisum/drivers/geckodriver.exe");//E:/MyTests/Nisum/drivers/geckodriver.exe
		driver = new FirefoxDriver();
	}

	@Test
	public void test() {
		driver.get("https:\\www.amazon.com");
	}
	@Test(enabled=false)  //it is ignored and never runs
	public void test2() {
		driver.get("https:\\www.irctc.com");
	}
	@Test   // it will skip but runs the programme
	public void testCaseSkipException(){
			System.out.println("Im in skip exception");
			throw new SkipException("Skipping this exception");
		}
	@AfterMethod
	public void tearDown() {
		driver.close();

	}}
