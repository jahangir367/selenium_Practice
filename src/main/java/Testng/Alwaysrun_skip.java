package Testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Selenium.Practice.com.Nisum.Reusableclass;

public class Alwaysrun_skip {
	WebDriver driver;
	
    //when we want to make sure a method always runs even if the parameters on which the method depends, fails. If set to true, this test method will always run.
	@BeforeMethod(alwaysRun = true)
	public void setupSuite() {
		System.setProperty("webdriver.gecko.driver",Reusableclass.setPath("/src/drivers/geckodriver.exe"));
		driver = new FirefoxDriver();
	}

	
	//     * This test will be executed as the enabled property is true.
	@Test(enabled=true)
	public void test() {
		driver.get("https:\\www.amazon.com");
	}
	
	//     * This test will NOT be executed as the enabled property is false.
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
