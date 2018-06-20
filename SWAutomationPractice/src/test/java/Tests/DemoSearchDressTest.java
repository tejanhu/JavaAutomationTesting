package Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.AutomationPracticePage;

public class DemoSearchDressTest {
	ChromeDriver myDriver;
	static ExtentReports extent;
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		extent= new ExtentReports("C:\\Users\\Admin\\Desktop\\SearchDressextent.html", true);
	}
	
	@Before
	public void setUp() {
		myDriver = new ChromeDriver();
		myDriver.manage().window().maximize();
		String url = "http://automationpractice.com/index.php";
		myDriver.get(url);
	}

	@Test
	public void searchDress() {
		AutomationPracticePage apPage = PageFactory.initElements(myDriver, AutomationPracticePage.class);  
		assertEquals("http://automationpractice.com/index.php",myDriver.getCurrentUrl());
		apPage.serachDress();
		try {
			Thread.sleep(5000);
		}
		catch(InterruptedException ie) {
			
		}
		assertEquals("7 results have been found.",apPage.getResults());

	}
	
	@Test
	public void test() {

		ExtentTest test = extent.startTest("Correct Navigation");
		try {
		test.log(LogStatus.PASS, "Successfull, all green!");
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
