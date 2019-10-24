package Selenium.Practice.com.Nisum;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import junit.framework.Assert;

public class alerts {
	
	@SuppressWarnings("deprecation")
@Test
public void test1() throws InterruptedException{
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "E:/MyTests/Nisum/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		//driver.manage().window().maximize();

		driver.get("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");
		//This step will result in an alert on screen
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Simple Alert')]")).click();
		Alert simpleAlert = driver.switchTo().alert();
		 String alertText = simpleAlert.getText();
		 System.out.println("Alert text is = " + alertText);
		 simpleAlert.accept();
		 Assert.assertEquals("A simple Alert", alertText);
	driver.close();}
@Test
public void test2() throws InterruptedException{
	WebDriver driver;
	System.setProperty("webdriver.gecko.driver", "E:/MyTests/Nisum/drivers/geckodriver.exe");
	driver = new FirefoxDriver();
	driver.manage().window().maximize();

	driver.get("http://demo.guru99.com/test/delete_customer.php");
	driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("16367");
	driver.findElement(By.xpath("//input[@name='submit']")).click();
	Alert simple = driver.switchTo().alert();
	 String simple_text = simple.getText();
	 System.out.println("simple_text  is = " + simple_text);
	 simple.dismiss();	
	 Assert.assertEquals("Do you really want to delete this Customer?", simple_text);

}
}