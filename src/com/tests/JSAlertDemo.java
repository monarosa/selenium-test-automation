package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.TestConstants;

public class JSAlertDemo {
	WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", TestConstants.CHROME_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		Thread.sleep(2000);

	}
	
//	@Test
	public void alertAcceptTest() throws InterruptedException{
		driver.findElement(By.xpath("(//button)[1]")).click();
		Thread.sleep(2000);
		// capture the alert
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		// click ok on the alert
		alert.accept();
	}

	
//	@Test
	public void alertCancel() throws InterruptedException{
		driver.findElement(By.xpath("(//button)[2]")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		
		// clicking cancel on the alert
		alert.dismiss();
	}
	
	@Test
	public void alertType() throws InterruptedException{
		driver.findElement(By.xpath("(//button)[3]")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		// getText() --> gets the text of the alert
		System.out.println(alert.getText());
		// sendKeys --> types on the alert
		alert.sendKeys("Hello");
		System.out.println(alert.getText());
		alert.accept();
	}
	
	@Test
	public void test(){
		// start testing
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		// continue testing

	}
	
}




