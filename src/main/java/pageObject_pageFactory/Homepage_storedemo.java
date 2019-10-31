package pageObject_pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Homepage_storedemo {
	
	WebDriver driver;
	public Homepage_storedemo(WebDriver driver){
	this.driver=driver;
	}
	//Using FindBy for locating elements
	@FindBy(how=How.XPATH, using="//a[text()='Dismiss']") WebElement closepopUp;
	@FindBy(how=How.XPATH, using="//a[text()='My Account']") WebElement loginlink;
	public void closePopUP(){
		closepopUp.click();
	}
	// This method to click on Logout link
	public void loginLink(){
		loginlink.click();
	}

}
