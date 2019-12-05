package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeDemo {
	WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "/Users/cybertek/Documents/Libraries/drivers2/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com/iframe");

	}

	@Test
	public void test() {
		// 1. we have to find the iframe
		// 2. call driver.switchTo().frame() by passing the iframe element
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys("more text");

		driver.switchTo().parentFrame();
		System.out.println(driver.findElement(By.linkText("Elemental Selenium")));
	}

	@Test
	public void test2() {
		// we can also switch to iframes by passing the name or id directly
		driver.switchTo().frame("mce_0_ifr");
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys("more text");

		driver.switchTo().parentFrame();
		System.out.println(driver.findElement(By.linkText("Elemental Selenium")));
	}

	@Test
	public void test3() {
		// switch by count
		// by the number of the frame
		driver.switchTo().frame(0);
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys("more text");

		driver.switchTo().parentFrame();
		System.out.println(driver.findElement(By.linkText("Elemental Selenium")));
	}
}