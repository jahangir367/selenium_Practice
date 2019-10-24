package Testng;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Testng_annotations {

	public static final String FileUtils = null;
	WebDriver d;

	public class TestngAnnotation {
		// test case 1
	    @Test(groups="urlValidation")
		public void testCase1() {
			System.out.println("in test case 1");
			d.findElement(By.id("a-autoid-0-announce")).click();

			WebDriverWait wait = new WebDriverWait(d,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));

			WebDriverWait waitforbutton = new WebDriverWait(d,30);
			waitforbutton.until(ExpectedConditions.elementToBeClickable(By.id("continue")));}
		// test case 2
		@Test
		public void testCase2() {
			System.out.println("in test case 2");
			WebDriverWait waitforbutton = new WebDriverWait(d,30);
			waitforbutton.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
			waitforbutton.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'  Enter your email or mobile phone number')]")));
			waitforbutton.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Need help?')]")));

	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("in beforeMethod");

	}

	@AfterMethod
	public void afterMethod() throws IOException {
		System.out.println("in afterMethod");
		 	     
	     File scrFile;
	        scrFile = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);

	     org.apache.commons.io.FileUtils.copyFile(scrFile, new File("E:\\My_Nisum_selenium\\Selenium_jahangir\\testimages.png"));

	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("in beforeClass");
		d.get("https://www.amazon.in");						

	}

	@AfterClass
	public void afterClass() {
		System.out.println("in afterClass");

	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("in beforeTest");
		d.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("in afterTest");
        System.out.println("Report is ready to be shared, with screenshots of tests");

	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("in beforeSuite");
		System.setProperty("webdriver.gecko.driver", "C:/Users/Nisum/Desktop/jahangir/Softwares/geckodriver.exe");
		d = new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("in afterSuite");
		d.close();

	}}}