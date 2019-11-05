package Utility;

import java.util.List;
import static org.junit.Assert.assertFalse;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class methods_Utility {
	
	public static WebDriver driver = null;
	public static String browserName = null;	
    static String timeStamp = new SimpleDateFormat("HH.mm.ss.yyyy.MM.dd").format(new Date());

	
    public static void  mouseHover(WebDriver driver,  By string) throws InterruptedException{
		List<WebElement> menuOption = driver.findElements(string);
		System.out.println("<<<<<<<<<<<<------List of all stars, size------------>>>>>>>>>>"+menuOption.size());
		for (WebElement e : menuOption) {
		    Actions act = new Actions(driver);
		    act.moveToElement(e).build().perform();
		    Thread.sleep(5000);
			System.out.println("<<<<<<<<<<<<------List of all stars, size------------>>>>>>>>>>"+e.getText());
		}}    
    
	@SuppressWarnings("deprecation")
	public static boolean between(Double i, int minValueInclusive, int maxValueInclusive,int row, int col) throws Exception {
	    if (i >= minValueInclusive && i <= maxValueInclusive) {
	    	System.out.println("number is in range");
	        return true;}
	    else {
	    	System.out.println("number is not  in range");
			excelUtility.setCellData("----Failed----"+timeStamp, row,col);
			Assert.fail();
	        return false;}
	}
	
	 public void waitForLoad(WebDriver driver,int i) {
	        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
	public Boolean apply(WebDriver driver) {
	return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	                    }};
	        WebDriverWait wait = new WebDriverWait(driver, i);
	        wait.until(pageLoadCondition);
	    }
                
	public static void waitTillPageLoad(int i) {
		driver.manage().timeouts().pageLoadTimeout(i, TimeUnit.SECONDS);
	}
	public static void  getTextValue(WebDriver driver,  By locatortype){
		String result = driver.findElement(locatortype).getText(); 
		System.out.println("showing the the display result = " + result);
			}

	public static void  click(WebDriver driver,  By locatortype){
		WebElement result = driver.findElement(locatortype); 
		result.click();
	}

	public static boolean  isDisplayed(WebDriver driver,  By locatortype){
		boolean result = driver.findElement(locatortype).isDisplayed(); 
		return result;
	}

	public static void sendKeys(WebDriver driver,  By locatortype,String text) {
		WebElement result = driver.findElement(locatortype); 
		result.sendKeys(text);
	}
	
	
	public static void clearTextField(WebDriver driver, By locatortype) {
		WebElement result = driver.findElement(locatortype); 
		result.clear();
	}
	public static void waitTillElementFound(WebDriver driver, By locatortype,
			int seconds) {
		WebElement result = driver.findElement(locatortype); 

		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(result));
					}
	public static void dragAndDrop(WebElement sourceElement, WebElement destinationElement) throws Exception
	{
		(new Actions(driver)).dragAndDrop(sourceElement, destinationElement).perform();
		Thread.sleep(3000);
	}
	public static WebElement waitAndGetElementByCssSelector(WebDriver driver, By selector,
			int seconds) {
		WebElement someElement = driver.findElement(selector); 
		return (new WebDriverWait(driver, seconds)).until( // ensure element is visible!
				ExpectedConditions.visibilityOfElementLocated((By) someElement));
	} 
	public static void  dropdDownByValue(WebDriver driver,  By locatortype, String value){
		WebElement element=driver.findElement(locatortype);
		Select se=new Select(element);
		se.selectByValue(value);
	}
	public static void  dropdDownByVisibleText(WebDriver driver,  By locatortype, String VisibleText){
		WebElement element=driver.findElement(locatortype);
		Select se=new Select(element);
		se.selectByValue(VisibleText);
	}
	public static void  dropdDownByIndex(WebDriver driver,  By locatortype, String index){
		WebElement element=driver.findElement(locatortype);
		Select se=new Select(element);
		se.selectByValue(index);
	}
	/*
	 * public void dropDownByVisibleTextloop(String studyType) throws Exception {
	 * List<WebElement> allOptions =
	 * dropDown.findElements(By.cssSelector(".dropdown-menu li"));
	 * 
	 * java.util.Iterator<WebElement> i = allOptions.iterator(); while(i.hasNext())
	 * { WebElement ele = i.next(); if (ele.text.equals(studyType) { ele.click(); //
	 * do something in else perhaps } } }
	 */

	public static void clickMultipleElements(WebDriver driver,By locatortype1,By locatortype2) {
		WebElement someElement = driver.findElement(locatortype1); 
		WebElement someOtherElement = driver.findElement(locatortype2); 

		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(someElement)
		.click(someOtherElement).keyUp(Keys.CONTROL).build().perform();
	}
	public static void navigate_forward() {
		driver.navigate().forward();
	}
	public static void navigate_back() {
		driver.navigate().back();
	}

	public static void refresh() {
		driver.navigate().refresh();
	}

	public static void waitMyTime(int i) {
		driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);

	}
	/*
	 * 
	 * ----Author <----jahangir---->----------webElement methods starts from
	 * 
	 */
	public static void sendKeys(WebElement element,String text) {
		element.sendKeys(text);
	}
	public static void keyboardEvents(WebElement webelement, Keys key,
			String alphabet) {
		webelement.sendKeys(Keys.chord(key, alphabet));
	}


	public static void clearTextField(WebElement element) {
		element.clear();

	}

	public static void clearTextField1(WebElement element) {
		element.clear();

	}

	public static void clickWebelement(WebElement element) {
		try {
			boolean elementIsClickable = element.isEnabled();
			while (elementIsClickable) {
				element.click();
			}

		} catch (Exception e) {
			System.out.println("Element is not enabled");
			e.printStackTrace();
		}
	}

	public static void clickMultipleElements(WebElement someElement,
			WebElement someOtherElement) {
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(someElement)
		.click(someOtherElement).keyUp(Keys.CONTROL).build().perform();
	}

	public static void highlightelement(WebElement element) {
		for (int i = 0; i < 4; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(
					"arguments[0].setAttribute(‘style’, arguments[1]);",
					element, "color: solid red; border: 6px solid yellow;");
			js.executeScript(
					"arguments[0].setAttribute(‘style’, arguments[1]);",
					element, "");

		}

	}

	public static boolean checkAlert_Accept() {
		try {
			Alert a = driver.switchTo().alert();
			String str = a.getText();
			System.out.println(str);

			a.accept();
			return true;

		} catch (Exception e) {

			System.out.println("no alert ");
			return false;

		}
	}

	public static boolean checkAlert_Dismiss() {
		try {
			Alert a = driver.switchTo().alert();
			String str = a.getText();
			System.out.println(str);

			a.dismiss();
			return true;

		} catch (Exception e) {

			System.out.println("no alert ");
			return false;

		}
	}

	/*public static void scrolltoElement(WebElement ScrolltoThisElement) {
		Coordinates coordinate = ((Locatable) ScrolltoThisElement)
		.getCoordinates();
		coordinate.onPage();
		coordinate.inViewPort();
		}*/

	public static void checkbox_Checking(WebElement checkbox) {
		boolean checkstatus;
		checkstatus = checkbox.isSelected();
		if (checkstatus == true) {
			System.out.println("Checkbox is already checked");
		} else {
			checkbox.click();
			System.out.println("Checked the checkbox");
		}
	}

	public static void radiobutton_Select(WebElement Radio) {
		boolean checkstatus;
		checkstatus = Radio.isSelected();
		if (checkstatus == true) {
			System.out.println("RadioButton is already checked");
		} else {
			Radio.click();
			System.out.println("Selected the Radiobutton");
		}}

	

}
