package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Testcases.driverUtils;
import Testcases.excelUtility;
import pageObject_pageFactory.Homepage_storedemo;
import pageObject_pageFactory.loginpage_Storedemoqa;

public class readingDataExcel extends driverUtils {


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
	}
	@Test
	public void testcase1() throws Exception {
		excelUtility.excelinstance();
		System.out.println("Test case one started");
		driver.findElement(By.xpath("//a[text()='Dismiss']")).click();

		driver.findElement(By.xpath("//a[text()='My Account']")).click();
		driver.findElement(By.id("username")).sendKeys(excelUtility.getCellData(1, 0));
		driver.findElement(By.id("password")).sendKeys(excelUtility.getCellData(1, 1));
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/button")).click();
		//driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
		Thread.sleep(2000);
		excelUtility.setCellData("Testcase is passed" , 1, 2);
	}
	
	@Test
	public void testcase2() throws Exception {
		try {
		excelUtility.excelinstance();
		System.out.println("Test case two started");
		driver.findElement(By.xpath("//a[text()='Dismiss']")).click();

		driver.findElement(By.xpath("//a[text()='My Account']")).click();
		driver.findElement(By.id("username")).sendKeys(excelUtility.getCellData(2, 0));
		driver.findElement(By.id("password")).sendKeys(excelUtility.getCellData(2, 1));
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/button")).click();
		//driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
		Thread.sleep(2000);
		excelUtility.setCellData("Test cases is passed", 2, 2);
		}
		catch(Exception e){
			excelUtility.setCellData("Testcase is failed", 2, 2);
		}}
	
	@Test
	public void storedemotest() throws Exception {
		System.out.println("Test three POM started");
		excelUtility.excelinstance();

		loginpage_Storedemoqa demologin = PageFactory.initElements(driver, loginpage_Storedemoqa.class);
		Homepage_storedemo demohome= PageFactory.initElements(driver, Homepage_storedemo.class);
		demohome.closePopUP();
		demohome.loginLink();
		demologin.setEmail(excelUtility.getCellData(1, 0));
		demologin.setPassword(excelUtility.getCellData(1, 1));
		demologin.clickOnLoginButton();
		System.out.println("Test three POM completesd");

	}}
