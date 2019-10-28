package Testng;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import Selenium.Practice.com.Nisum.Reusableclass;
public class data_provider {

	private static WebDriver driver;

	
	// this test run for two time as we given two sets of data
	@DataProvider(name = "Authentication")

	public static Object[][] credentials() {
		return new Object[][] { { "jaan@yopmail.com", "!987654321987" }, { "testuser_1", "Test@123" }};
	}
	@Test(dataProvider = "Authentication")

	public void test(String sUsername, String sPassword) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver",Reusableclass.setPath("/src/drivers/geckodriver.exe"));

		
		//System.setProperty("webdriver.gecko.driver",Reusableclass.setPath("/src/drivers/geckodriver.exe"));
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.store.demoqa.com");
		driver.findElement(By.xpath("//a[text()='Dismiss']")).click();

		driver.findElement(By.xpath("//a[text()='My Account']")).click();
		driver.findElement(By.id("username")).sendKeys(sUsername);
		driver.findElement(By.id("password")).sendKeys(sPassword);
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/button")).click();
		//driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
Thread.sleep(2000);
		driver.close();

	}}
