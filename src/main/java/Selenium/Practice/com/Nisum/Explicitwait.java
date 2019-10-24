package Selenium.Practice.com.Nisum;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Explicitwait {
	WebDriver driver;

	@Test
	public void explicitwait(){
		try {
			System.setProperty("webdriver.gecko.driver", "E:/MyTests/Nisum/drivers/geckodriver.exe");//E:/MyTests/Nisum/drivers/geckodriver.exe
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			driver.get("https://www.amazon.in");
			Thread.sleep(3000);
			driver.findElement(By.id("a-autoid-0-announce")).click();

			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));

			WebDriverWait waitforbutton = new WebDriverWait(driver,30);
			waitforbutton.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
			waitforbutton.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'  Enter your email or mobile phone number')]")));
			waitforbutton.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Need help?')]")));

			System.out.println("complete");
			driver.close();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}}
}
