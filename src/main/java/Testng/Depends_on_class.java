package Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Depends_on_class {
	
	WebDriver d;

	class c1 {
		@Test(groups={"verifyConfig"})
		public void verifyConfig() {
			System.setProperty("webdriver.gecko.driver", "C:/Users/Nisum/Desktop/jahangir/Softwares/geckodriver.exe");
			d = new FirefoxDriver();	
		}}

	class c2 {
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
