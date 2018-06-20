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

import Pages.DemoSitePage;

public class CreateAndLoginTest {
	ChromeDriver myDriver;
	static ExtentReports extent;
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		extent= new ExtentReports("C:\\Users\\Admin\\Desktop\\createAndLoginextent.html", true);

	}
	
	@Before
	public void setUp() {
		myDriver = new ChromeDriver();
		myDriver.manage().window().maximize();
		String url = "http://thedemosite.co.uk/";
		myDriver.get(url);
	}

	@Test
	public void createAndLogUser() {
		DemoSitePage dsPage = PageFactory.initElements(myDriver, DemoSitePage.class);  
		assertEquals("http://thedemosite.co.uk/",myDriver.getCurrentUrl());
		dsPage.addUserButtonClick();
		assertEquals("http://thedemosite.co.uk/addauser.php", myDriver.getCurrentUrl());
		dsPage.clickUsernameTextField();
		dsPage.enterUername();
		dsPage.clickPasswordTextField();
		dsPage.enterPassword();
		dsPage.clickSave();
		assertEquals("http://thedemosite.co.uk/savedata.php",myDriver.getCurrentUrl());
		
		dsPage.loginNavButton.click();
		assertEquals("http://thedemosite.co.uk/login.php", myDriver.getCurrentUrl());
		dsPage.clickUsernameTextField();
		dsPage.enterUername();
		dsPage.clickPasswordTextField();
		dsPage.enterPassword();
		dsPage.clickLogin();
		assertEquals("**Successful Login**",dsPage.getSuccessfulLoginText());
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
