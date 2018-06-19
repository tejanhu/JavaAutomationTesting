package com.qa.quickstart.ShoppingWebsite;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SWTest {
	ChromeDriver myDriver;
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
	}
	
	@Before
	public void setUp() {
		myDriver = new ChromeDriver();
		myDriver.manage().window().maximize();
		String url = "http://automationpractice.com/index.php";
		myDriver.navigate().to(url);
	}

	@Test
	public void search() {
		WebElement searchbar = myDriver.findElementById("search_query_top");
		searchbar.click();
		searchbar.clear();
		searchbar.sendKeys("Dress");
		myDriver.findElementByCssSelector("#searchbox > button").click();
//		myDriver.findElementByXPath("//*[@id=\"search_query_top\"]").sendKeys("Dress");
//		assertEquals("http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=Dress&submit_search=",myDriver.getCurrentUrl());
		assertEquals("7 results have been found.",myDriver.findElementByClassName("heading-counter").getText());

	}
	

	@After
	public void tearDown() {
		myDriver.close();
	}

}

