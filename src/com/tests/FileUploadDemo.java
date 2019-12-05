package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.TestConstants;

public class FileUploadDemo {
	WebDriver drier;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", TestConstants.CHROME_PATH);
		drier = new ChromeDriver();
		// maximing a webpage
		// somehow does not always work on all macs
	
	}
	
	@Test
	public void fileUpload(){
		drier.get("https://the-internet.herokuapp.com/upload");
		// get the path to file.
		// the folder where the file is located + name of the file + extension of the file (if there is one)
		String file = "/Users/cybertek/Desktop/test-folder/Reference.key";
		// find the element on the page that accepts the path to file
		WebElement input = drier.findElement(By.id("file-upload"));
		// send the path to that element
		input.sendKeys(file);
		
		// click on the upload button
		drier.findElement(By.id("file-submit")).click();
		
		
		
		
		
	}
	
	
	
	
}