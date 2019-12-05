package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * ACTUALLY THIS CLASS IS ABOUT RADIO BUTTONS
 * 1.OpenEtsy
 * 2.Enter search any term
 * 3.Verify Shop location: Anywhere is checked
 * 4.Verify Shop location: United States is not checked'
 * 5.Click on Shop location: United States
 * 6.Verify Shop location: Anywhere is checked
 * 7.Verify Shop location: United States is not checked
 */
public class RadioHead {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/cybertek/Documents/Libraries/drivers2/chromedriver");
		driver = new ChromeDriver();
		// implicit wait --> makes webdriver wait if it cannot find the element
		// it will keep trying to find the element for duration provided
		// it will throw exception if it cannot locate the element after
		// duration given
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://etsy.com");
		driver.findElement(By.id("search-query")).sendKeys("something else" + Keys.ENTER);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void radiButtonTest() throws InterruptedException {
		Assert.assertTrue(driver.findElement(By.name("locationQuery")).isSelected());
				
		Assert.assertFalse(driver.findElement(By.xpath("(//input[@name='locaqwerqwerwetionQuery'])[2]")).isSelected());
		
		driver.findElement(By.linkText("United States")).click();
		
		Assert.assertFalse(driver.findElement(By.name("locationQuery")).isSelected());
		
		Assert.assertTrue(driver.findElement(By.xpath("(//input[@name='locationQuery'])[2]")).isSelected());
		
		
	}

}



