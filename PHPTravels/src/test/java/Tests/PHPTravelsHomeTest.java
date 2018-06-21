package Tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

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

import Pages.PHPTravelsHomePage;

public class PHPTravelsHomeTest {
	ChromeDriver myDriver;
	static ExtentReports extent;
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		extent= new ExtentReports("C:\\Users\\Admin\\Desktop\\PHPTravelsExtentReport.html", true);
	}
	
	@Before
	public void setUp() {
		myDriver = new ChromeDriver();
		myDriver.manage().window().maximize();
		String url = "https://www.phptravels.net/";
		myDriver.get(url);
	}

	@Test
	public void bookHotel() {
		PHPTravelsHomePage phpTravelsHomePage = PageFactory.initElements(myDriver, PHPTravelsHomePage.class);  
		assertEquals("https://www.phptravels.net/",myDriver.getCurrentUrl());
		phpTravelsHomePage.clickHotelOriginTextField(myDriver);
		myDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException ie) {
			
		}
		myDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		phpTravelsHomePage.enterHotelOrigin(myDriver);
		myDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			Thread.sleep(9000);
		}
		catch(InterruptedException ie) {
			
		}
		System.out.println(phpTravelsHomePage.verifyHotelIsInLondon());
		assertEquals(phpTravelsHomePage.verifyHotelIsInLondon(),myDriver.findElement(By.className("select2-input")).getText());

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
