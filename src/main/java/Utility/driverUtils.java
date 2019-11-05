package Utility;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class driverUtils {
	public static long DEFAULT_WAIT = 10;
	//single ton class
	public static WebDriver driver;


	public static WebDriver getDefaultDriver() {
		if (driver != null) {
			return driver;
		}
		System.out.println("------driver utils @before---------");

		/*System.setProperty("webdriver.chrome.driver", "E:\\com.pmr.org\\drivers\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup(); */

		WebDriverManager.firefoxdriver().setup(); 
		//System.setProperty("webdriver.gecko.driver", "C:/Users/Nisum/Desktop/jahangir/Softwares/geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.navigate().to(constantParams.URL); 

		/*DesiredCapabilities capabilities = null;
		capabilities = DesiredCapabilities.firefox();
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability("takesScreenshot", true);*/
		//driver = chooseDriver(capabilities);
		//driver.manage().timeouts().setScriptTimeout(5,TimeUnit.SECONDS);
		return driver;        
	}
	public static void closeDriver() {
		if(driver != null) {
			try {
				driver.close();
				System.out.println("------driver utils @After---------");

				//driver.quit(); // fails in current geckodriver! TODO: Fixme
			} catch (NoSuchMethodError nsme) { // in case quit fails
			} catch (NoSuchSessionException nsse) { // in case close fails
			} catch (SessionNotCreatedException snce) {} // in case close fails
			//driver = null;
		}	}
}
