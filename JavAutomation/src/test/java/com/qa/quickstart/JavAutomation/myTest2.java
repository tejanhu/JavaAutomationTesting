package com.qa.quickstart.JavAutomation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class myTest2 {
	ChromeDriver myDriver;
	static ExtentReports extent;
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		extent= new ExtentReports("C:\\Users\\Admin\\Desktop\\extent.html", true);

	}
	
	@Before
	public void setUp() {
		myDriver = new ChromeDriver();
		myDriver.manage().window().maximize();
		String url = "http://thedemosite.co.uk/";
		myDriver.navigate().to(url);
	}

	@Test
	public void createAndLogUser() {
		assertEquals("http://thedemosite.co.uk/",myDriver.getCurrentUrl());
		myDriver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")).click();
		assertEquals("http://thedemosite.co.uk/addauser.php", myDriver.getCurrentUrl());
		myDriver.findElementByName("username").click();
		myDriver.findElementByName("username").sendKeys("user123");
		myDriver.findElementByName("password").click();
		myDriver.findElementByName("password").sendKeys("password123");
		myDriver.findElement(By.cssSelector("p > input[type=\"button\"]")).click();
		
		myDriver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")).click();
		assertEquals("http://thedemosite.co.uk/login.php", myDriver.getCurrentUrl());
		myDriver.findElementByName("username").click();
		myDriver.findElementByName("username").sendKeys("user123");
		myDriver.findElementByName("password").click();
		myDriver.findElementByName("password").sendKeys("password123");
		myDriver.findElement(By.cssSelector("p > input[type=\"button\"]")).click();
		assertEquals("**Successful Login**",myDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText());
	}
	
	@Test
	public void test() {

		ExtentTest test = extent.startTest("Correct Navigation");
		try {
		test.log(LogStatus.PASS, "Successful, all green.");
		}catch(AssertionError e) {
			test.log(LogStatus.FAIL, "Error, Something broke so fix it!");
			
			fail();
		}finally {
			test.log(LogStatus.INFO, "Current URL: " + myDriver.getCurrentUrl());
		extent.endTest(test);
		}
	}


	@After
	public void tearDown() {
		myDriver.close();
		extent.flush();
	}

}