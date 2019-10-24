package Selenium.Practice.com.Nisum;

import java.util.List;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class handling_frames {
		WebDriver d;

		@Test
		public void handling_frames() throws InterruptedException{
			System.setProperty("webdriver.gecko.driver", "E:/MyTests/Nisum/drivers/geckodriver.exe");//E:/MyTests/Nisum/drivers/geckodriver.exe
		d = new FirefoxDriver();
		d.manage().window().maximize();

		d.get("https://seleniumhq.github.io/selenium/docs/api/java/index.html");

		List<WebElement> f=d.findElements(By.tagName("frame"));
		System.out.println("No of frames:"+f.size());
		
        int size = d.findElements(By.tagName("frame")).size();
        System.out.println("No of frames:" + size);
        
        //Switch to third frame using index
        d.switchTo().frame(2);
        d.findElement(By.linkText("INDEX")).click();
        
        //Switch to the parent webpage  
        d.switchTo().defaultContent();
        
        //switch to the second frame using name attribute value
        d.switchTo().frame("packageFrame");
        d.findElement(By.linkText("AbstractAnnotations")).click();
        
        //Switch to the parent webpage  
        d.switchTo().defaultContent();
        
        //Take the reference of the first frame and store in a variable of type WebElement 
        WebElement ele = d.findElement(By.name("packageListFrame"));
                //switch to the frame using the reference
        d.switchTo().frame(ele);
        d.findElement(By.linkText("com.thoughtworks.selenium")).click();
        d.switchTo().defaultContent();
        
		for(int i=0; i<=size-1; i++){
			//WebElement frame1 = d.findElement(By.xpath("//frameset/frameset/frame[i]"));
		    d.switchTo().frame(i);
		    List<WebElement> links = d.findElements(By.tagName("a"));
		   int linkcount = links.size();
		    
		    //String pack = d.findElement(By.xpath("//div[@class='indexContainer']/h2[1]")).getText();
			System.out.println("no of links in frame " +i+ " = " + linkcount);
			d.switchTo().defaultContent();
			Thread.sleep(3000);
}
/*		WebElement frame1 = d.findElement(By.xpath("//frameset/frameset/frame[1]"));
		d.switchTo().frame(frame1);
		//Type text
		String pack = d.findElement(By.xpath("//div[@class='indexContainer']/h2[1]")).getText();
		System.out.println("get the text if frame1 = " + pack);
		//Outside frame
		d.switchTo().defaultContent();
		Thread.sleep(3000);
		WebElement frame2 = d.findElement(By.xpath("//frameset/frameset/frame[2]"));
		//WebElement frame2 = d.findElement(By.xpath("/html/frameset/frame")); 

		d.switchTo().frame(frame2);
		//Type text
		String pack1 = d.findElement(By.xpath("/html/body/div/ul/li[101]/a")).getText();
		System.out.println("get the text if frame2 = " + pack1);
*/				
		/*
			d.get("http://jqueryui.com/autocomplete/");
			assertEquals("Autocomplete | jQuery UI",d.getTitle());
			List<WebElement> f=d.findElements(By.tagName("iframe"));
			System.out.println("No of frames:"+f.size());
			//Switch driver focus to frame
			//d.switchTo().frame(d.findElement(By.className("demo-frame")));
			d.switchTo().frame(0);
			//Type text
			d.findElement(By.id("tags")).sendKeys("Selenium");
			//Outside frame
			d.switchTo().defaultContent();
			String text = d.findElement(By.xpath("//div[@id=\"sidebar\"]/aside[1]/ul/li[1]/a")).getText();
			System.out.println("print the text of element = " + text);
			Thread.sleep(4000);*/

		System.out.println("completed");
d.close();

	}}
