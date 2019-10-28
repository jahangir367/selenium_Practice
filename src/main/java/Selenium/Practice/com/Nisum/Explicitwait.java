package Selenium.Practice.com.Nisum;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Explicitwait {
	WebDriver driver;
	/*We will divide this topic in below scenarios:

		1)When element s found without any delay.
		2)When element is not found.
	a. When implicit wait and explicit wait timeout are same. //Maximum time you will get wait time as 10 seconds but sometimes 20 seconds.  You will see wait time as 20 seconds rarely.
	b. When implicit wait time is greater than explicit wait time.//always see time out equal to implicit wait.
	c. When explicit wait time is greater than implicit wait time //You will timeout equal to implicit wait time. because it needs to wait for 10 seconds because of implicit wait. After that implicit wait throws exception because of not able to locate element.
	Exception stops explicit wait to search further and doesnot allow to reach its timeout.
	implicit wait can ruin your explicit wait functionality. Implicit wait destroys meaning of using explicit wait when using together. So it is advised not to use implicit wait and explicit wait together.
	*/
	@Test
	public void explicitwait(){
		try {
			System.setProperty("webdriver.gecko.driver",Reusableclass.setPath("/src/drivers/geckodriver.exe"));     //E:/MyTests/Nisum/drivers/geckodriver.exe
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
