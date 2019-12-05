package utilities;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BrowserUtils {
	public static void verifyCheckBoxSelected(WebElement checkbox) {
		if (checkbox.isSelected()) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}

	public static void verifyCheckBoxNotSelected(WebElement checkbox) {
		if (checkbox.isSelected()) {
			System.out.println("Fail");
		} else {
			System.out.println("Pass");
		}
	}

	// public void Unselect (WebElement checkbox, ){
	// // if selected
	// // then click
	// }
	
	public static void verifyTitleContains(WebDriver driver, String expected){
		String actual = driver.getTitle();
		if (actual.toLowerCase().contains(expected.toLowerCase())) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
			System.out.println("Expected: "+expected);
			System.out.println("Actual+ "+ actual);
		}
		
	}
	
	// write a method that verifies an element exists,
	// method has two params: webdriver, locator
	public static void verifyElementExists(WebDriver driver, By by){
		try {
			assertTrue(driver.findElement(by).isDisplayed());
		} catch (NoSuchElementException e) {
			Assert.fail("Element was not found");
		}
	}

	public static void changeWindow(WebDriver driver, String targetTitle) {
		String origin = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			if(driver.getTitle().equals(targetTitle)){
				return;
			}
		}
		driver.switchTo().window(origin);
		
	}
	
	
	
}