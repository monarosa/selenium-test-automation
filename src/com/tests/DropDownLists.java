package com.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownLists {
	WebDriver driver;

	/*
	 * 
	 */
	@BeforeMethod
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/cybertek/Documents/Libraries/drivers2/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dropdown");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void test() {
		// To create a Select oject
		// 1. find the element with a select tag
		WebElement element = driver.findElement(By.id("dropdown"));
		// 2. create the Select object by pasing the element as a constructor
		Select list = new Select(element);
		// print the currently selected option
		System.out.println(list.getFirstSelectedOption().getText());

		// print all of the options
		List<WebElement> allOptions = list.getOptions();
		System.out.println(allOptions.size());
		for (WebElement webElement : allOptions) {
			System.out.println(webElement.getText());
		}

		System.out.println("Selecting option 2");
		list.selectByVisibleText("Option 2");
		System.out.println(list.getFirstSelectedOption().getText());

		// System.out.println("Selecting option 1");
		// list.selectByVisibleText("Option 1");
		// System.out.println(list.getFirstSelectedOption().getText());

		System.out.println("Selecting first one");
		list.selectByIndex(1);
		System.out.println(list.getFirstSelectedOption().getText());

		System.out.println("Selecting second one");
		list.selectByIndex(2);
		System.out.println(list.getFirstSelectedOption().getText());

		System.out.println("Selecting value one");
		list.selectByValue("1");
		System.out.println(list.getFirstSelectedOption().getText());

		System.out.println("Selecting value one");
		list.selectByValue("2");
		System.out.println(list.getFirstSelectedOption().getText());

	}

}