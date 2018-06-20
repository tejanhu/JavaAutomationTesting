package widgets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.DemoQAPage;

public class DatepickerTest {
	WebDriver myDriver;
	static ExtentReports extent;
	
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		extent= new ExtentReports("C:\\Users\\Admin\\Desktop\\extentDatePicker.html", true);
	}
	
	@Before
	public void setUp() {
		myDriver = new ChromeDriver();
		myDriver.manage().window().maximize();
		String url = "http://demoqa.com/";
		myDriver.get(url);
	}
	
	@Test
	public void testSomething() {
		 DemoQAPage page = PageFactory.initElements(myDriver, DemoQAPage.class);     
		 page.datePickerNavClick();
		 assertEquals("http://demoqa.com/datepicker/",myDriver.getCurrentUrl());
//		 try {
//			 Thread.sleep(5000);
//		 }catch(InterruptedException ie) {
//			 
//		 }
		 page.clickDateBox();
//		 try {
//			 Thread.sleep(5000);
//		 }catch(InterruptedException ie) {
//			 
//		 }
		 page.clickNext();
//		 try {
//			 Thread.sleep(5000);
//		 }catch(InterruptedException ie) {
//			 
//		 }
		 page.selectDay();
		 page.clickDateBox();
		 try {
			 Thread.sleep(5000);
		 }catch(InterruptedException ie) {
			 
		 }
		 myDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 

		 assertEquals(page.verifyDate(),myDriver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(5) > td:nth-child(5) > a")).getText().contains((CharSequence) myDriver.findElement(By.id("datepicker1")).getText()));		 
	}
	
	@Test
	public void sendExtentReport() {
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
