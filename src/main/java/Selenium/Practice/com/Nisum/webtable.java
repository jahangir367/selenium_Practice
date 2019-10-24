package Selenium.Practice.com.Nisum;


import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;


public class webtable {
	public static void main(String[] args) {

	WebDriver driver;
	
/*	WebDriverManager.chromedriver().setup(); 
	//System.setProperty("webdriver.chrome.driver", "E:\\com.pmr.org\\drivers\\chromedriver.exe");
    driver = new ChromeDriver();*/
	
	//WebDriverManager.firefoxdriver().setup(); 
	System.setProperty("webdriver.gecko.driver", "E:/MyTests/Nisum/drivers/geckodriver.exe");//E:/MyTests/Nisum/drivers/geckodriver.exe
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	
	driver.get("https://www.moneycontrol.com/stocksmarketsindia/");
	//get text for  second row third col
	String sensex = driver.findElement(By.xpath("//*[@id='maindindi']/div[1]/table/tbody/tr[2]/td[1]")).getText();
	System.out.println("index bank name 2 = " + sensex);
	
	//get text for third row third col
	String nifty = driver.findElement(By.xpath("//*[@id='maindindi']/div[1]/table/tbody/tr[3]/td[1]")).getText();
	System.out.println("index bank name 3 = " + nifty);
	
	//get all  text of the second row
	java.util.List<WebElement> allHeadersOfTable= driver.findElements(By.xpath("//*[@id=\"maindindi\"]/div[1]/table/tbody/tr[2]"));
	System.out.println("Total headers found2: "+allHeadersOfTable.size());
	for(WebElement header2 :allHeadersOfTable )
	{
		System.out.println(header2.getText());
	}
	
	//get all  text of the third row
	java.util.List<WebElement> allHeadersOfTablerow3= driver.findElements(By.xpath("//*[@id=\"maindindi\"]/div[1]/table/tbody/tr[3]"));
	System.out.println("Total headers found3: "+allHeadersOfTablerow3.size());
	for(WebElement header3 :allHeadersOfTablerow3 )
	{
		System.out.println(header3.getText());
	}
	
	//get text of all rows and col
	java.util.List<WebElement> allColumnsInRow=driver.findElements(By.xpath("//*[@id='maindindi']/div[1]/table/tbody/tr"));
	System.out.println("Total headers of the table: "+allColumnsInRow.size());
	for(WebElement e: allColumnsInRow)
	{
		System.out.println(e.getText());
	}
	//get the highest price value	
	java.util.List<WebElement> maxprice =driver.findElements(By.xpath("//*[@id='maindindi']/div[1]/table/tbody/tr/td[2]"));
	System.out.println("Total max value of the table: "+maxprice.size());
	ArrayList<String> maxpricevalue = new ArrayList<>();

	for(int i=0;i<maxprice.size();i++)
	{
		maxpricevalue.add(maxprice.get(i).getText());
	        System.out.println(maxprice.get(i).getText());
		//System.out.println(x.getText());
	}
	Object obj = Collections.max(maxpricevalue);
	System.out.println("Max price is = " + obj);
	System.out.println("Min price is = " + Collections.min(maxpricevalue));
	
	java.util.List<WebElement> leastchange =driver.findElements(By.xpath("//*[@id='maindindi']/div[1]/table/tbody/tr/td[3]"));
	System.out.println("Total max value of the table: "+leastchange.size());
	ArrayList<String> leastchnvalue = new ArrayList<>();

	for(int i=0;i<leastchange.size();i++)
	{
		leastchnvalue.add(leastchange.get(i).getText());
	        System.out.println(leastchange.get(i).getText());
		//System.out.println(x.getText());
	}
	Object object = Collections.max(leastchnvalue);
	System.out.println("Max change is = " + object);
	System.out.println("Min price is = " + Collections.min(leastchnvalue));

	
driver.close();
}}
