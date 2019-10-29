package Testng;

import static org.testng.Assert.assertEquals;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import Selenium.Practice.com.Nisum.Reusableclass;

public class Annotation_parameter {
	WebDriver d;
	@Test
	public void autoComplete() throws Exception
	{
		//Load web page
		d.get("https://jqueryui.com/autocomplete/");
		assertEquals("Autocomplete | jQuery UI",d.getTitle());
		//Switch driver focus to frame
		d.switchTo().frame(0);
		//Type text
		d.findElement(By.id("tags")).sendKeys("a");
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
	@BeforeTest
	public void setUp(String browser) throws InterruptedException
	{
		// Launch browser
		if(browser.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver",Reusableclass.setPath("/src/drivers/geckodriver.exe"));
			d=new FirefoxDriver();

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
			}
	@AfterTest
	public void tearDown()
	{
		//Close browser
		d.close();
	}

}
