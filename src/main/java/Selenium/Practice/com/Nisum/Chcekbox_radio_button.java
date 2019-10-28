package Selenium.Practice.com.Nisum;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Chcekbox_radio_button {
	/*//main difference between Radio button and Checkbox is that, 
	 1)using radio button we will be able to select only one option from the options vailable. 
	 2) whereas using checkbox, we can select multiple options.
	 Before performing the click even on the Radio buttons or checkboxes we will have to verify

     If Radio button or Checkbox is displayed on the webpage
     If Radio button or Checkbox is enabled on the webpage
     Check the default selection of the Radio button or Checkbox
     Above mentioined verification can be done using predefined menthods in Selenium

        isDisplayed()
        isEnabled()
        isSelected()*/
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver",Reusableclass.setPath("/src/drivers/geckodriver.exe"));    //E:/MyTests/Nisum/drivers/geckodriver.exe
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://toolsqa.com/automation-practice-form");

		List<WebElement> rdBtn_Sex = driver.findElements(By.name("sex"));
		boolean bValue = false;
		bValue = rdBtn_Sex.get(0).isSelected();
		if(bValue == true){
			rdBtn_Sex.get(1).click();
		}else{
			// If the first radio button is not selected by default, the first will be selected
			rdBtn_Sex.get(0).click();
		}

		//Step 4: Select the Third radio button for category 'Years of Exp' (Use Id attribute to select Radio button)
		WebElement rarioBtn_Exp = driver.findElement(By.id("exp-2"));
		rarioBtn_Exp.click();

		List<WebElement> chkBx_Profession = driver.findElements(By.name("profession"));

		int iSize = chkBx_Profession.size();
		System.out.println("no of check boxes = " +iSize);

		for(int i=0; i < iSize ; i++ ){
			String sValue = chkBx_Profession.get(i).getAttribute("value");

			if (sValue.equalsIgnoreCase("Manual Tester")){
				chkBx_Profession.get(i).click();
				break;
			}		}
		//scroll the page till the element found
		WebElement chekbox = driver.findElement(By.xpath("//input[@id='tool-2']"));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", chekbox);
		/*Actions actions = new Actions(driver);
		actions.moveToElement(chekbox);
		actions.perform();
		Thread.sleep(500); */

		//chekbox.click();
		driver.close();
	}
}