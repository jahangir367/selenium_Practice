package Selenium.Practice.com.Nisum;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class webtable_max_value_withindex_value {
	@SuppressWarnings({ "unchecked", "rawtypes" })

		WebDriver driver;
	@Test
	public void test1() {
	
		System.setProperty("webdriver.gecko.driver", "E:/MyTests/Nisum/drivers/geckodriver.exe");//E:/MyTests/Nisum/drivers/geckodriver.exe
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.moneycontrol.com/stocksmarketsindia/");

		HashMap<String, String> map = new HashMap<String, String>();

		Double maxnum = null;
		Double mininum = null;

		String bank = null;
		String bank1 = null;


		for (int i = 0; i < 5; i++) {
			int j = i;
			String max = driver
					.findElement(By.xpath("//*[@id='maindindi']/div[1]/table/tbody/tr[" + (i + 1) + "]/td[1]"))
					.getText();
			String max1 = driver
					.findElement(By.xpath("//*[@id='maindindi']/div[1]/table/tbody/tr[" + (j + 1) + "]/td[2]"))
					.getText();
			System.out.println("Total No of key  : " + max);
			System.out.println("Total No of value  : " + max1);

			map.put(max, max1);
			if (i == 0) {
				maxnum = Double.valueOf(max1); // returns Double object
				bank = max;
			}
			if (i == 0) {
				mininum = Double.valueOf(max1); // returns Double object
				bank1 = max;
			}	
		}
		for (Entry<String, String> entry : map.entrySet()) { // Itrate through hashmap
			Double d = Double.valueOf(entry.getValue());

			if (maxnum <= d) {
				maxnum = d;
				bank = entry.getKey();
			}
			 if (mininum >= d) {
				mininum = d;
				bank1 = entry.getKey();
			}
		}
		System.out.println("Highest price with bank name "+ bank   + " = " +maxnum );
		System.out.println("Lowest  price with bank name "+ bank1  + " = " +mininum );

		driver.close();
	}}
