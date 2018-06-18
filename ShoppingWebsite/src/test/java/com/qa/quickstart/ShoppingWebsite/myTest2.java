package com.qa.quickstart.ShoppingWebsite;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class myTest2 {
	ChromeDriver myDriver;
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
	}
	
	@Before
	public void setUp() {
		myDriver = new ChromeDriver();
		myDriver.manage().window().maximize();
		String url = "http://thedemosite.co.uk/";
		myDriver.navigate().to(url);
	}

	@Test
	public void search() {
		assertEquals("http://thedemosite.co.uk/",myDriver.getCurrentUrl());
		myDriver.findElementById("#search_query_top").click();
		myDriver.findElementById("#search_query_top").sendKeys("Dress");
		assertEquals("7 results have been found.",myDriver.findElement(By.cssSelector("#center_column > h1 > span.heading-counter")).getText());

	}
	

	@After
	public void tearDown() {
		myDriver.close();
	}

}

