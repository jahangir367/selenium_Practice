package Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Selenium.Practice.com.Nisum.Reusableclass;


public class Depends_on_group {
	WebDriver d;
// groups are limited to the package ..and if we want to run dependency from othere package we need to import the package
	 @Test(dependsOnGroups = { "Group1" })
	    public void groupTestOne() throws InterruptedException {
	        System.out.println("Group Test method one");
	        System.out.println("Meth2 in GT2");
			d.get("https://www.flipkart.com");
			Thread.sleep(3000);
			d.close();
	    }
	 @Test(dependsOnGroups = { "Group1","Group4" })
	    public void groupTestTwo() throws InterruptedException {
	        System.out.println("Group Test method one");
	        System.out.println("Meth2 in GT2");
			//d.get("https://www.flipkart.com");
			Thread.sleep(3000);
			d.close();

	    }
	 //--------------------------
	 @Test(groups="Group1")
		public void meth1()
		{
			System.out.println("Meth1 in GT1");
			System.setProperty("webdriver.gecko.driver",Reusableclass.setPath("/src/drivers/geckodriver.exe"));
			d = new FirefoxDriver();	
		}
	 	/*@Test(groups="Group2")
		public void meth2() throws InterruptedException
		{
			System.out.println("Meth2 in GT2");
			System.setProperty("webdriver.chrome.driver", "C:/Users/Nisum/Desktop/jahangir/Softwares/chromedriver.exe");
			d = new ChromeDriver();
			Thread.sleep(3000);
		}*/
		@Test(groups="Group3")
		public void meth3()
		{
			System.out.println("Meth3 in GT3");
			/*d.findElement(By.id("a-autoid-0-announce")).click();

			WebDriverWait wait = new WebDriverWait(d,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));*/
		}
		@Test(groups="Group4")
		public void meth4()
		{
			System.out.println("Meth1 in GT1");
			/*System.setProperty("webdriver.gecko.driver",Reusableclass.setPath("/src/drivers/geckodriver.exe"));
			d = new FirefoxDriver();	*/
			System.out.println("Meth3 in GT4");
			d.get("https://www.snapdeal.com");		}
			 
}
