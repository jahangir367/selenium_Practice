package Testng;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import junit.framework.Assert;
import org.testng.annotations.Test;




@Listeners(Testng.Listeners_types.class)
public class Listeners_class {
	WebDriver d;

	//public class TestNGListenersTest {
	    @Test //Passing Test 
	    public void sampleTest1() throws InterruptedException { 
			System.setProperty("webdriver.gecko.driver", "C:/Users/Nisum/Desktop/jahangir/Softwares/geckodriver.exe");
			d = new FirefoxDriver();
			d.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			d.get("https://www.amazon.in");
			Thread.sleep(3000);
			d.findElement(By.id("a-autoid-0-announce")).click();

			WebDriverWait wait = new WebDriverWait(d,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));

			WebDriverWait waitforbutton = new WebDriverWait(d,30);
			waitforbutton.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
			waitforbutton.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'  Enter your email or mobile phone number')]")));
			waitforbutton.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Need help?')]")));
	d.close();
	}
	@Test //Failing Test 
	public void sampleTest2() throws InterruptedException { 
	System.out.println("Forcely Failed Test Method");
	Assert.assertTrue(false);
	}
	private int i = 0;
	@Test(successPercentage = 60, invocationCount = 5) //Test Failing But Within Success Percentage 
	public void sampleTest3() { i++; 
	System.out.println("Test Failed But Within Success Percentage Test Method, invocation count: " + i); 
	if (i == 1 || i == 2) { 
		System.out.println("sampleTest3 Failed"); 
		Assert.assertEquals(i, 6); } } 

}
