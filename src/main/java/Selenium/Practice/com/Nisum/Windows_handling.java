package Selenium.Practice.com.Nisum;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Windows_handling {
	public static void main(String[] args) throws InterruptedException
	{
	WebDriver d;
	System.setProperty("webdriver.gecko.driver", "E:/MyTests/Nisum/drivers/geckodriver.exe");//E:/MyTests/Nisum/drivers/geckodriver.exe
	d = new FirefoxDriver();
	d.manage().window().maximize();
	
	d.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
	assertEquals("IRCTC Next Generation eTicketing System",d.getTitle());
	//Click on Food-on-Track
	d.findElement(By.linkText("Food-on-Track")).click();
	Set<String> h=d.getWindowHandles();
	System.out.println("***** Handles are ******");
	String handles[]=new String[h.size()];
	int i=0;
	for(String s:h)
	{
		System.out.println(s);
		handles[i]=s;
		i++;
	}
	//Switch driver focus from Parent to child window
	d.switchTo().window(handles[1]);
	assertTrue(d.findElement(By.id("stnCode")).isDisplayed());
	Thread.sleep(2000);
	//switch driver focus from child to parent window
	d.switchTo().window(handles[0]);
	assertTrue(d.findElement(By.id("usernameId")).isDisplayed());
	Thread.sleep(4000);
}}
