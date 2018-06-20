package widgets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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

public class AccordionTest {
	WebDriver myDriver;
	static ExtentReports extent;
	
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		extent= new ExtentReports("C:\\Users\\Admin\\Desktop\\extentAccordion.html", true);
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
		 page.accordionClick();
		 assertEquals("http://demoqa.com/accordion/",myDriver.getCurrentUrl());
		 page.collapse();
		 try {
			 Thread.sleep(9000);
		 }
		 catch(InterruptedException ie) {
			 
		 }
		 assertEquals(page.isParagraphTextPresent(),myDriver.findElement(By.cssSelector("#ui-id-5 > p")).isDisplayed());		 
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
