package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TeaTestingSteps {
	
	WebDriver myDriver;
	static ExtentReports extent;
	
	
	@Given("^the correct web address$")
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		myDriver = new ChromeDriver();
		myDriver.manage().window().maximize();
		assertNotNull(myDriver);
		myDriver.navigate().to("http://www.practiceselenium.com/welcome.html");
		assertEquals("http://www.practiceselenium.com/welcome.html",myDriver.getCurrentUrl());
		extent= new ExtentReports("C:\\Users\\Admin\\Desktop\\teaTestingCucumberExtent.html", true);
	}
	@When("^I navigate to the 'Menu' page$")
	public void webDriverNavigate() {
		myDriver.navigate().to("http://www.practiceselenium.com/menu.html");
		assertEquals("http://www.practiceselenium.com/menu.html",myDriver.getCurrentUrl());
	}
	
	@Then("^I can browse a list of the available products.$")
	public void browseToAvailableProducts() {
		myDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		assertEquals(true, myDriver.findElement(By.id("wsb-button-00000000-0000-0000-0000-000451955160")).isDisplayed());
		assertEquals(true, myDriver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000451959280")).isDisplayed());
		assertEquals(true, myDriver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000451961556")).isDisplayed());
	}
	
	
	@When("^I click the checkout button$")
	public void clickCheckout() {
		myDriver.findElement(By.cssSelector("#wsb-button-00000000-0000-0000-0000-000451955160")).click();
	}
	
	
	@Then("^I am taken to the checkout page$")
	public void browseToCheckoutPage() {
		assertEquals("http://www.practiceselenium.com/check-out.html", myDriver.getCurrentUrl());
	}
	
	
	public void sendReport() {

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
	public void tidyUp() {
		sendReport();
		myDriver.close();
		
		extent.flush();
		
	}
	

}
