package Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Selenium.Practice.com.Nisum.Reusableclass;


public class Priority_testng {
	
	
	  WebDriver driver;			

	    @Test (priority=1)		
	    public void openBrowser() {				
	    	System.setProperty("webdriver.gecko.driver",Reusableclass.setPath("/src/drivers/geckodriver.exe"));
			driver = new FirefoxDriver();	    }		

	    // Method 2: Launch Google.com			
	    @Test (priority=2)		
	    public void launchGoogle() {				
	        driver.get("https://www.amazon.in");						
	    }		

	    // Method 3: Perform a search using "Facebook"			
	    @Test (priority=3)		
	    public void peformSeachAndClick1stLink() {				
			driver.findElement(By.id("a-autoid-0-announce")).click();
	    }		

	    // Method 4: Verify Google search page title.			
	    @Test (priority=4)		
	    public void FaceBookPageTitleVerification() throws Exception {				
	        driver.findElement(By.id("continue")).click();						
	        Thread.sleep(3000);
			WebDriverWait waitforbutton = new WebDriverWait(driver,30);

			waitforbutton.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'  Enter your email or mobile phone number')]")));
driver.close();
}}
