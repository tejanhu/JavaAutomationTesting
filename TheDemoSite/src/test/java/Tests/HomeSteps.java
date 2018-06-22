package Tests;

import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomeSteps {
	
	WebDriver myWebDriver;
	static ExtentReports extent;
	
	@Given("^I have a fully functional webdriver$")
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		myWebDriver = new ChromeDriver();
		myWebDriver.manage().window().maximize();
		assertNotNull(myWebDriver);
		extent= new ExtentReports("C:\\Users\\Admin\\Desktop\\demoSiteCucumberExtent.html", true);
	}
	
	@When("^I enter http://thedemosite.co.uk$")
	public void navigate() {
		myWebDriver.navigate().to("http://thedemosite.co.uk");
	}
	
	@Then("^the homepage should be visible$")
	public void checkVisibility() {
		assertEquals("http://thedemosite.co.uk/", myWebDriver.getCurrentUrl());
	}
	
	public void sendReport() {

		ExtentTest test = extent.startTest("Correct Navigation");
		try {
		test.log(LogStatus.PASS, "Successfull, all green!");
		}catch(AssertionError e) {
			test.log(LogStatus.FAIL, "Error, Something broke so fix it!");
			
			fail();
		}finally {
			test.log(LogStatus.INFO, "Current URL: " + myWebDriver.getCurrentUrl());
		extent.endTest(test);
		}
	}
	
	
	
	@After
	public void tidyUp() {
		sendReport();
		myWebDriver.close();
		
		extent.flush();
		
	}

	

}
