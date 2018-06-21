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

import Pages.AddUserPage;
import Pages.DemoSiteHomePage;
import Pages.LoginPage;

public class DemoSiteMainTest {
	ChromeDriver myDriver;
	static ExtentReports extent;
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		extent= new ExtentReports("C:\\Users\\Admin\\Desktop\\demoSiteExtent.html", true);
	}
	
	@Before
	public void setUp() {
		myDriver = new ChromeDriver();
		myDriver.manage().window().maximize();
		String url = "http://thedemosite.co.uk/";
		myDriver.get(url);
	}

	@Test
	public void createUser() {
		DemoSiteHomePage dsHomePage = PageFactory.initElements(myDriver, DemoSiteHomePage.class); 
		AddUserPage addUserPage = PageFactory.initElements(myDriver, AddUserPage.class);
		assertEquals("http://thedemosite.co.uk/",myDriver.getCurrentUrl());
		dsHomePage.addUserButtonClick();
		assertEquals("http://thedemosite.co.uk/addauser.php", myDriver.getCurrentUrl());
		addUserPage.clickUsernameTextField();
		addUserPage.enterUername();
		addUserPage.clickPasswordTextField();
		addUserPage.enterPassword();
		addUserPage.clickSave();
		assertEquals("http://thedemosite.co.uk/savedata.php",myDriver.getCurrentUrl());
	}
	
	@Test
	public void logUser() {
		DemoSiteHomePage dsHomePage = PageFactory.initElements(myDriver, DemoSiteHomePage.class);
		LoginPage loginPage = PageFactory.initElements(myDriver, LoginPage.class);
		assertEquals("http://thedemosite.co.uk/",myDriver.getCurrentUrl());
		dsHomePage.loginNavButton.click();
		assertEquals("http://thedemosite.co.uk/login.php", myDriver.getCurrentUrl());
		loginPage.clickUsernameTextField();
		loginPage.enterUername();
		loginPage.clickPasswordTextField();
		loginPage.enterPassword();
		myDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		loginPage.clickLogin();
		myDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		assertEquals("**Successful Login**",loginPage.getSuccessfulLoginText());
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
