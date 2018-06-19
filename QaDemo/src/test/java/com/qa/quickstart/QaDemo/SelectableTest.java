package com.qa.quickstart.QaDemo;

import static org.junit.Assert.assertEquals;


import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import org.junit.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class SelectableTest {
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
	public void clickAndSelect() throws Throwable {
		WebElement selectableButton = myDriver.findElementByXPath("//*[@id=\"menu-item-142\"]/a");
		selectableButton.click();
		assertEquals("http://demoqa.com/selectable/",myDriver.getCurrentUrl());
		WebElement widgetSelectable= myDriver.findElementById("selectable");
		widgetSelectable.click();
	    assertEquals(widgetSelectable.isSelected(),myDriver.findElementById("selectable").isSelected());
	}
	

	@After
	public void tearDown() {
		myDriver.close();
	}

	}

