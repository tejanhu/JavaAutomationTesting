package com.qa.quickstart.JunitProj;

import static org.junit.Assert.*;

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
	
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
	}
	
	public void setUp() {
		myDriver = new ChromeDriver();
	}
	
	public void tearDown() {
		myDriver.close();
	}

}
