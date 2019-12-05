package com.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BlackList {
	WebDriver driver;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "/Users/cybertek/Documents/Libraries/drivers2/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://amazon.com");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium cookbook" + Keys.ENTER);
		Thread.sleep(2000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void searchTest() throws InterruptedException {
		// verify every result has the word selenium
		// get the text of all the results
		// write locators that chooses all the results
		// store in a list
		// iterate thru list
		// verify each element in that list contains word selenium

		List<WebElement> allResults = driver.findElements(By.tagName("h2"));
		System.out.println(allResults.size());
		for (WebElement result : allResults) {
			System.out.println(result.getText());
			Assert.assertTrue(result.getText().toLowerCase().contains("selenium"));
		}

	}
}