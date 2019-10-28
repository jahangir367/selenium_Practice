package Selenium.Practice.com.Nisum;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;


public class fluent_Wait {
	WebDriver driver;
	@Test
	public void fluentwait(){
		try {
			System.setProperty("webdriver.gecko.driver",Reusableclass.setPath("/src/drivers/geckodriver.exe"));     //E:/MyTests/Nisum/drivers/geckodriver.exe
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	driver.get("https://www.amazon.in");
	Thread.sleep(2000);
	driver.findElement(By.id("a-autoid-0-announce")).click();
	
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
			.withTimeout(30, TimeUnit.SECONDS) 			
			.pollingEvery(5, TimeUnit.SECONDS) 			
			.ignoring(NoSuchElementException.class);
	WebElement username = wait.until(new Function<WebDriver, WebElement>()
	{
		 public WebElement apply(WebDriver driver ) {
			return driver.findElement(By.id("ap_email"));
		}});
	username.sendKeys("jahangir");
	driver.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}	}}
