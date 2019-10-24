package Selenium.Practice.com.Nisum;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdown {
	public static void main(String[] args) throws InterruptedException
	{
	WebDriver driver;
	System.setProperty("webdriver.gecko.driver", "E:/MyTests/Nisum/drivers/geckodriver.exe");//E:/MyTests/Nisum/drivers/geckodriver.exe
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	
	driver.get("http://toolsqa.com/automation-practice-form");
	Select select = new Select(driver.findElement(By.id("continents")));
	select.selectByVisibleText("Europe");
	Thread.sleep(4000);

	select.selectByIndex(3);
	Thread.sleep(2000);

	List<WebElement> list = select.getOptions();
	int iListSize = list.size();
System.out.println("no of count = " + list.size());
	
	
	for(int i =0; i < iListSize ; i++){
		String sValue = select.getOptions().get(i).getText();
		System.out.println(sValue);
		if(sValue.equals("Africa")){
			select.selectByIndex(i);
			break;
			}
		}	    
	driver.quit();

}}
