package com.qa.quickstart.QaDemo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DroppableTest {
	ChromeDriver myDriver;
	WebDriver myWebDriver;
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
	}
	
	@Before
	public void setUp() {
		myDriver = new ChromeDriver();
		myDriver.manage().window().maximize();
		String url = "http://demoqa.com/";
		myDriver.navigate().to(url);
	}

	@Test
	public void clickAndDrop() {
		WebElement droppableButton = myDriver.findElementByCssSelector("#menu-item-141 > a");
		droppableButton.click();
		assertEquals("http://demoqa.com/droppable/",myDriver.getCurrentUrl());
		WebElement fromElement= myDriver.findElementByClassName("ui-widget-content ui-draggable ui-draggable-handle");
	    WebElement toElement=myDriver.findElement(By.className("ui-widget-header ui-droppable"));
	    Actions action = new Actions(myWebDriver);
	    Action dragDrop = action.dragAndDrop(fromElement, toElement).build();
	    dragDrop.perform(); 
	    assertEquals("Dropped",myDriver.findElementById("droppableview").findElement(By.xpath("//*[@id=\"droppableview\"]/p")).getText());
	}
	

	@After
	public void tearDown() {
		myDriver.close();
	}

}

