package com.tests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.BrowserUtils;
import utilities.TestConstants;

public class MultipleWindows {
	WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", TestConstants.CHROME_PATH);
		// open a browser page, one window
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com/windows");
		Thread.sleep(2000);

	}

//	@Test
	public void test() {
		// returns the window handle for current page
		String handle = driver.getWindowHandle();
		System.out.println(handle);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.linkText("Click Here")).click();
		
		String newWindowHandle="";
		Set<String> windowHandles = driver.getWindowHandles();
		
		// capture the handle of the tab which is not the current tab
		for (String string : windowHandles) {
			System.out.println(string);
			if (!string.equals(handle)) {
				newWindowHandle = string;
			}
		}
		// switch to new window using the handle of the new window
		driver.switchTo().window(newWindowHandle);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}
	
//	@Test
	public void switchUsingTitle(){
		driver.findElement(By.linkText("Click Here")).click();
		System.out.println(driver.getCurrentUrl());
		String targetTitle= "New Window";
		
		for (String handle : driver.getWindowHandles()) {
			// first switch
			driver.switchTo().window(handle);
			// then check the title
			if (driver.getTitle().equals(targetTitle)) {
				// stop switching
				break;
			}
		}
		
		System.out.println(driver.getCurrentUrl());
	}
	
	@Test
	public void switchUsingUtil(){
		driver.findElement(By.linkText("Click Here")).click();
		System.out.println(driver.getCurrentUrl());
		String targetTitle= "New Window";
		BrowserUtils.changeWindow(driver, targetTitle);
		System.out.println(driver.getCurrentUrl());

	}
	
	
	@Test
	public void driverClose(){
		driver.findElement(By.linkText("Click Here")).click();
		driver.findElement(By.linkText("Click Here")).click();
		driver.quit();
		String targetTitle= "New Window";
		BrowserUtils.changeWindow(driver, targetTitle);
		System.out.println(driver.getCurrentUrl());

	}
	
}