package Testng;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class Annotation_parameter {
	WebDriver d;
	@Test
	public void autoComplete() throws Exception
	{
		//Load web page
		d.get("http://jqueryui.com/autocomplete/");
		assertEquals("Autocomplete | jQuery UI",d.getTitle());
		//Switch driver focus to frame
		d.switchTo().frame(0);
		//Type text
		d.findElement(By.id("tags123")).sendKeys("a");
		List<WebElement> s=d.findElements(By.className("ui-menu-item"));
		System.out.println("No of suggestions:"+s.size());
		System.out.println("********* Suggestions are ************");
		for(WebElement e:s)
		{
			System.out.println(e.getText());
		}
		if(s.size()>=3)
		{
			for(int i=0;i<3;i++)
			{
				d.findElement(By.id("tags")).sendKeys(Keys.ARROW_DOWN);
				Thread.sleep(2000);
			}
			d.findElement(By.id("tags")).sendKeys(Keys.ENTER);
			
		}
		Thread.sleep(4000);
	}
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser)
	{
		// Launch browser
		if(browser.equals("FF"))
		{
			d=new FirefoxDriver();
			System.setProperty("webdriver.gecko.driver", "C:/Users/Nisum/Desktop/jahangir/Softwares/geckodriver.exe");

		}
		else if(browser.equals("GC"))
		{
			System.setProperty("webdriver.chrome.driver","E:\\Selenium_Scripts_Jan16\\Lib\\chromedriver.exe");
			d=new ChromeDriver();
		}
		else if(browser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","E:\\Selenium_Scripts_Jan16\\Lib\\IEDriverServer.exe");
			d=new InternetExplorerDriver();
		}
		
		
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@AfterMethod
	public void tearDown()
	{
		//Close browser
		d.quit();
	}

}
