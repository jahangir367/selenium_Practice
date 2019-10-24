package Testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Depends_on_Methods {
	WebDriver d;

	 @Test(dependsOnMethods  = { "meth1" })
	    public void groupTestOne() throws InterruptedException {
	        System.out.println("Group Test method one");
	        System.out.println("Meth2 in GT2");
			d.get("https://www.flipkart.com");
			Thread.sleep(3000);
			d.close();
	    }
	 @Test(dependsOnMethods  = { "meth1","meth4" })
	    public void groupTestTwo() throws InterruptedException {
	        System.out.println("Group Test method one");
	        System.out.println("Meth2 in GT2");
			//d.get("https://www.flipkart.com");
			Thread.sleep(3000);
			d.close();

	    }
	 //--------------------------
	 @Test
		public void meth1()
		{
			System.out.println("Meth1 in GT1");
			System.setProperty("webdriver.gecko.driver", "C:/Users/Nisum/Desktop/jahangir/Softwares/geckodriver.exe");
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
		@Test
		public void meth3()
		{
			System.out.println("Meth3 in GT3");
			/*d.findElement(By.id("a-autoid-0-announce")).click();

			WebDriverWait wait = new WebDriverWait(d,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));*/
		}
		@Test
		public void meth4()
		{
			System.out.println("Meth1 in GT1");
			/*System.setProperty("webdriver.gecko.driver", "C:/Users/Nisum/Desktop/jahangir/Softwares/geckodriver.exe");
			d = new FirefoxDriver();	*/
			System.out.println("Meth3 in GT4");
			d.get("https://www.snapdeal.com");		}

}
