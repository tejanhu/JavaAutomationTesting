
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

public class AutocompleteTest {
	WebDriver myDriver;
	static ExtentReports extent;
	
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		extent= new ExtentReports("C:\\Users\\Admin\\Desktop\\extentAutocomplete.html", true);
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
		 page.autocompleteClick();
		 assertEquals("http://demoqa.com/autocomplete/",myDriver.getCurrentUrl());
		 page.tagClick();
		 page.enterSomething();
		 myDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 

		 assertEquals(page.isListItem1Present(),myDriver.findElement(By.xpath("//*[@id=\"ui-id-7\"]")).getText().equals("ActionScript"));		 
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
