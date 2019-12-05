package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.TestConstants;

public class BrowserPopUps {
	WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", TestConstants.CHROME_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Thread.sleep(2000);

	}
	
	
	@Test
	public void acceptBrowserPopUp(){
		driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
		
		WebElement button = driver.findElement(By.cssSelector("button[type='submit']"));
		
		button.click();
//		 located the cancel option using findElement
		WebElement no =  driver.findElement(By.xpath("//span[.='No']"));
//		 click on the element
		no.click();
		
		button.click();
		
		// located the x link using findElement
		WebElement x = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-closethick']"));
		
		x.click();
	}
	// lunch break 2.00 pm est
}
