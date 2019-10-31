package pageObject_pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class loginpage_Storedemoqa {
	
	WebDriver driver;
	public loginpage_Storedemoqa(WebDriver driver){
	this.driver=driver;
	}
	@FindBy(how=How.ID, using="username") WebElement emailTextBox;
	@FindBy(how=How.ID, using="password") WebElement passwordTextBox;
	@FindBy(how=How.XPATH, using="//*[@id=\"customer_login\"]/div[1]/form/p[3]/button") WebElement signinButton;
	 
	// This method is to set Email in the email text box
	public void setEmail(String strEmail){
	emailTextBox.sendKeys(strEmail);
	}
	// This method is to set Password in the password text box
	public void setPassword(String strPassword){
	passwordTextBox.sendKeys(strPassword);}
	 
	// This method is to click on Login Button
	public void clickOnLoginButton(){
	signinButton.click();

}}
