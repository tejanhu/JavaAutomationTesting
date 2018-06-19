package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

//import com.relevantcodes.extentreports.ExtentReports;

import org.junit.Test;

import Pages.*;
public class DroppableTest {
	
	WebDriver myDriver;
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
//		extent= new ExtentReports("C:\\Users\\Admin\\Desktop\\extentDroppable.html", true);
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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 DemoQAPage page = PageFactory.initElements(myDriver, DemoQAPage.class);     
		 page.click();
		 assertEquals("http://demoqa.com/droppable/",myDriver.getCurrentUrl());
	}
	
	@After
	public void tearDown() {
		myDriver.close();
//		extent.flush();
	}
	
}
