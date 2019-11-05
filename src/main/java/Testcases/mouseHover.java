package Testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.constantParams;
import Utility.driverUtils;
import Utility.excelUtility;
import Utility.methods_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import or_package.xpath_test;

public class mouseHover {
	
	public static WebDriver driver;

	@BeforeTest
	public void Initialization() throws Exception 
	{	WebDriverManager.firefoxdriver().setup(); 
		//System.setProperty("webdriver.gecko.driver", "C:/Users/Nisum/Desktop/jahangir/Softwares/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.flipkart.com");		
		System.out.println("------@Before---------");

	}
	@AfterTest
	public void Cleanup () throws Exception 
	{
		System.out.println("------@After---------");
		driverUtils.closeDriver();
		//driver.quit();
	}
	@Test
	public void testcase1() throws Exception {
		excelUtility.excelinstance();
		System.out.println("Test case one started");
		
		methods_Utility.click(driver, xpath_test.popClose);
		
		//methods_Utility.mouseHover(driver, xpath_test.flipMouseHover);
		List<WebElement> x = driver.findElements(By.xpath("//a[contains(@href,'/mobile-phones-store?otracker=nmenu_sub_Electronics_0_Mobiles')]"));
		System.out.println("<<<<<<<<<<<<------List of all stars, size------------>>>>>>>>>>"+x.size());
		
		List<WebElement> mob = driver.findElements(By.xpath("//div[@id='container']/div/div[2]/div/ul/li[1]/ul/li/ul/li[1]/ul/li"));
		System.out.println("------List of all mobiles, size----------"+mob.size());
		for (WebElement m : mob) {
		    Actions act = new Actions(driver);
		    act.moveToElement(m).build().perform();
		    Thread.sleep(5000);
			System.out.println("<<<<<<<<<<<<------List of all mobiles, size------------>>>>>>>>>>"+m.getText());
		}	
		
		for(int i=1;i<=5;i++) {
			for (int j=1;j<=14;j++) {
		WebElement mtest = driver.findElement(By.xpath("//div[@id='container']/div/div[2]/div/ul/li[1]/ul/li/ul/li["+i+"]/ul/li["+j+"]"));
		System.out.println(i + "" +j);
		System.out.println("<<<<<<<<<<<<------List of all listss, size------------>>>>>>>>>>"+mtest.getText());

	}}}
}

