package com.qa.quickstart.JavAutomation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class myTest {
	ChromeDriver myDriver;

	@Test
	public void test() {
		myDriver.manage().window().maximize();
		String url = "http://www.google.com";
		myDriver.navigate().to(url);
		assertEquals("https://www.google.com/?gws_rd-ssl",myDriver.getCurrentUrl());
	
	}
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
	}
	
	@Before
	public void setUp() {
		myDriver = new ChromeDriver();
	}
	@After
	public void tearDown() {
		myDriver.close();
	}

}
