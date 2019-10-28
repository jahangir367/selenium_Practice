package Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Selenium.Practice.com.Nisum.Reusableclass;

public class Depends_on_class {
	
	WebDriver d;

	class c2 {
		
		//DependsOnMethods cannot be used from different class ,To resolve this we can use dependsOnGroups;
		// this limitations it should be in a same project
       // you need to run from .xml by using include methods
		@Test(groups={"verifyConfig"})
		public void verifyConfig() {
			System.setProperty("webdriver.gecko.driver",Reusableclass.setPath("/src/drivers/geckodriver.exe"));
			d = new FirefoxDriver();	
		}}

	class c1 {
		@Test(dependsOnGroups={"verifyConfig"})
		public void dotest() throws InterruptedException {
			d.get("https://www.amazon.in");
			Thread.sleep(3000);
			d.findElement(By.id("a-autoid-0-announce")).click();

			WebDriverWait wait = new WebDriverWait(d,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));

			WebDriverWait waitforbutton = new WebDriverWait(d,30);
			waitforbutton.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
			waitforbutton.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'  Enter your email or mobile phone number')]")));
			waitforbutton.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Need help?')]")));
			d.close();  }}

}
