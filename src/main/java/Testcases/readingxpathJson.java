package Testcases;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import or_package.xpath_test;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.internal.Utils;

import Utility.driverUtils;
import Utility.excelUtility;
import Utility.jsonObject;
import Utility.methods_Utility;

import java.util.Date;
import java.util.List;

public class readingxpathJson extends driverUtils {
	//public static File jsonobject;
	
	@SuppressWarnings({ "unused", "static-access" })
	@Test
	public void readingxpathfromjson() throws Exception {
			
    String jsonfetch = System.getProperty("user.dir")+ "\\src\\main\\java\\Utility\\dataxpath.json";
    
    jsonObject json = new jsonObject(jsonfetch) {
	};

		
	excelUtility.excelinstance();
	//System.out.println(JsonPath.read(jsonobject,"$."+"popUp"));
   //methods_Utility.click(driver, JsonPath.read(jsonobject,"$."+"popUp"));
	//methods_Utility.click(driver, xpath_test.popClose);
	//web.setText(driver, json.getObjectLocator("$.Login.txt_username"), "username");
		
	methods_Utility.click(driver, json.getObjectLocator("$.Login.popUp"));
	driver.findElement(By.xpath("//a[text()='My Account']")).click();
	driver.findElement(By.id("username")).sendKeys(excelUtility.getCellData(1, 0));
	driver.findElement(By.id("password")).sendKeys(excelUtility.getCellData(1, 1));
	driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/button")).click();
	//driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
	Thread.sleep(2000);

}

	@BeforeTest
	public void Initialization() throws Exception 
	{
		driverUtils.getDefaultDriver();
		System.out.println("------@Before---------");

	}
	@AfterTest
	public void Cleanup () throws Exception 
	{
		System.out.println("------@After---------");
		driverUtils.closeDriver();
		//driver.quit();
	}}
