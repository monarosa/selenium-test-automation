package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.TestConstants;

public class ActionsDemo {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", TestConstants.CHROME_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

//	@Test
	public void hoverTest(){
		driver.get("http://amazon.com");
		Actions actions = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//span[.='Hello. Sign in']"));
		actions.moveToElement(element).perform();
		driver.findElement(By.linkText("Explore Idea Lists")).click();
	}
	
	public void dragAndDrop1(){
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
		Actions actions = new Actions(driver);
		// what you want to drop
		WebElement source = driver.findElement(By.id("draggable"));
		// where you want to drop it
		WebElement target = driver.findElement(By.id("droptarget"));
		actions.dragAndDrop(source, target).perform();
		
	}
	
//	@Test
	public void dragAndDrop2(){
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
		Actions actions = new Actions(driver);
		// what you want to drop
		WebElement source = driver.findElement(By.id("draggable"));
		// where you want to drop it
		WebElement target = driver.findElement(By.id("droptarget"));
		// move mouse to the source element
		// click and hold
//		move to second targt element
//		release
		actions.moveToElement(source).clickAndHold().moveToElement(target).release()
		.build().perform();
//		build  --> puts all the actions together and makes it ready for perform(), chains the actions
		
	}
	
//	@Test
	public void doubleClick(){
		Actions actions = new Actions(driver);
		 driver.get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml"); 
		 WebElement element = driver.findElement(By.id("puff_header"));
		 actions.doubleClick(element).perform();
		 
	}

//	@Test
	public void pageDown1(){
		Actions actions = new Actions(driver);
		 driver.get("http://jscroll.com/");
		 // find an element
		 // focus on that element 
		 // click page down
		 
		 WebElement element = 
				 driver.findElement(By.xpath("//h3[.='Page 1 of jScroll Example - jQuery Infinite Scrolling Plugin']"));	 
		actions.moveToElement(element).click().sendKeys(Keys.PAGE_DOWN).perform();; 
	}
	
	
	@Test
	public void pageDown2() throws InterruptedException{
		Actions actions = new Actions(driver);
		 driver.get("http://jscroll.com/");
		 // find an element
		 // focus on that element 
		 // click page down
		 
		 WebElement element = 
				 driver.findElement(By.xpath("//h2[.='About jScroll']"));	 
		actions.moveToElement(element).click().sendKeys(Keys.PAGE_DOWN).perform();; 
		Thread.sleep(1000);
		actions.sendKeys(Keys.PAGE_DOWN).perform();; 
		Thread.sleep(1000);
		actions.sendKeys(Keys.PAGE_DOWN).perform();; 
		Thread.sleep(1000);
		
	}
}
