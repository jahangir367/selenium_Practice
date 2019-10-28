package Testng;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import Selenium.Practice.com.Nisum.Reusableclass;

public class Retrycount implements IRetryAnalyzer {
	WebDriver driver;
    private int retryCount = 0;
    private int maxRetryCount = 2;

    public boolean retry(ITestResult result) {

        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }

    @Test(retryAnalyzer = Retrycount.class)
    public void testGenX() throws InterruptedException {
    	System.setProperty("webdriver.gecko.driver",Reusableclass.setPath("/src/drivers/geckodriver.exe"));
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
		Assert.assertEquals("A simple Alert----------", alertText);
		driver.close();
    }

    @Test(retryAnalyzer = Retrycount.class)
    public void testGenY() {
    	System.setProperty("webdriver.gecko.driver",Reusableclass.setPath("/src/drivers/geckodriver.exe"));
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

		driver.get("http://demo.guru99.com/test/delete_customer.php");
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("16367");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Alert simple = driver.switchTo().alert();
		String simple_text = simple.getText();
		System.out.println("simple_text  is = " + simple_text);
		simple.dismiss();	
		Assert.assertEquals("Do you really want to delete this Customer?", simple_text);    }

}
