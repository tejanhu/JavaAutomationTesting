package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.DemoQAHomePage;
import Pages.DroppablePage;
import Pages.SelectablePage;
import Pages.widgets.AccordionPage;
import Pages.widgets.AutoCompletionPage;
import Pages.widgets.DatePickerPage;

public class DemoQaMainTest {
	WebDriver myDriver;
	static ExtentReports extent;
	
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		extent= new ExtentReports("C:\\Users\\Admin\\Desktop\\DemoQAextentReport.html", true);
	}
	
	@Before
	public void setUp() {
		myDriver = new ChromeDriver();
		myDriver.manage().window().maximize();
		String url = "http://demoqa.com/";
		myDriver.get(url);
	}
	
	@Test
	public void testNavigationToDroppable() {
		 DemoQAHomePage homePage = PageFactory.initElements(myDriver, DemoQAHomePage.class);     
		 DroppablePage droppablePage = PageFactory.initElements(myDriver, DroppablePage.class); 
		 myDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 assertEquals("http://demoqa.com/",myDriver.getCurrentUrl());
		 myDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 homePage.droppableNavClick();
		 assertEquals("http://demoqa.com/droppable/",myDriver.getCurrentUrl());
		 myDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		 droppablePage.drop(myDriver);
		 myDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 assertEquals("Dropped!",myDriver.findElement(By.id("droppableview")).findElement(By.xpath("//*[@id=\"droppableview\"]/p")).getText());
	}
	
	@Test
	public void testNavigationToSelectable() {
		 DemoQAHomePage homePage = PageFactory.initElements(myDriver, DemoQAHomePage.class);
		 SelectablePage selectablePage = PageFactory.initElements(myDriver, SelectablePage.class);  
		 assertEquals("http://demoqa.com/",myDriver.getCurrentUrl());
		 homePage.selectableNavClick();
		 
		 assertEquals("http://demoqa.com/selectable/",myDriver.getCurrentUrl());
			
		 selectablePage.select(myDriver);
		 assertEquals(selectablePage.widgetObj.isSelected(),myDriver.findElement(By.id("selectable")).isSelected());		
	}
	
	@Test
	public void testNavigationToAccordion() {
		 DemoQAHomePage homePage = PageFactory.initElements(myDriver, DemoQAHomePage.class);     
		 AccordionPage accordionPage = PageFactory.initElements(myDriver, AccordionPage.class);  
		 assertEquals("http://demoqa.com/",myDriver.getCurrentUrl());
		 homePage.accordionNavClick();
		 
		 assertEquals("http://demoqa.com/accordion/",myDriver.getCurrentUrl());
		 
		 accordionPage.collapse();
		 
		 try {
			 Thread.sleep(9000);
		 }
		 catch(InterruptedException ie) {
			 
		 }
		 
		 assertEquals(accordionPage.isParagraphTextPresent(),myDriver.findElement(By.cssSelector("#ui-id-5 > p")).isDisplayed());	
	}
	
	@Test
	public void testNavigationToAutcomplete() {
		 DemoQAHomePage homePage = PageFactory.initElements(myDriver, DemoQAHomePage.class);
		 AutoCompletionPage autoCompletionPage = PageFactory.initElements(myDriver, AutoCompletionPage.class); 
		 assertEquals("http://demoqa.com/",myDriver.getCurrentUrl());
		 homePage.autocompleteNavClick();
		 
		 assertEquals("http://demoqa.com/autocomplete/",myDriver.getCurrentUrl());

		 autoCompletionPage.tagClick();

		 autoCompletionPage.enterSomething();

		 myDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		
		 assertEquals(autoCompletionPage.isListItem1Present(),myDriver.findElement(By.xpath("//*[@id=\"ui-id-7\"]")).getText().equals("ActionScript"));		 
	}
	
	
	@Test
	public void testNavigationToDatePicker() {
		 DemoQAHomePage homePage = PageFactory.initElements(myDriver, DemoQAHomePage.class); 
		 DatePickerPage datePickerPage = PageFactory.initElements(myDriver, DatePickerPage.class);
		 assertEquals("http://demoqa.com/",myDriver.getCurrentUrl());
		 homePage.datePickerNavClick();
		 
		 assertEquals("http://demoqa.com/datepicker/",myDriver.getCurrentUrl());
//		 try {
//			 Thread.sleep(5000);
//		 }catch(InterruptedException ie) {
//			 
//		 }
		 datePickerPage.clickDateBox();
//		 try {
//			 Thread.sleep(5000);
//		 }catch(InterruptedException ie) {
//			 
//		 }
		 datePickerPage.clickNext();
//		 try {
//			 Thread.sleep(5000);
//		 }catch(InterruptedException ie) {
//			 
//		 }
		 datePickerPage.selectDay();
		 datePickerPage.clickDateBox();
		 try {
			 Thread.sleep(5000);
		 }catch(InterruptedException ie) {
			 
		 }
		 myDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 

		 assertEquals(datePickerPage.verifyDate(),myDriver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(5) > td:nth-child(5) > a")).getText().contains((CharSequence) myDriver.findElement(By.id("datepicker1")).getText()));
	}
		
//	@Ignore
//	public void testNavigationToMenu() {
//		 DemoQAHomePage homePage = PageFactory.initElements(myDriver, DemoQAHomePage.class);     
//		 assertEquals("http://demoqa.com/",myDriver.getCurrentUrl());
//		 homePage.menuNavClick();
//	}
//	
//	@Ignore
//	public void testNavigationToSlider() {
//		 DemoQAHomePage homePage = PageFactory.initElements(myDriver, DemoQAHomePage.class);     
//		 assertEquals("http://demoqa.com/",myDriver.getCurrentUrl());
//		 homePage.sliderNavClick();
//	}
	
	@Test
	public void testNavigationToTabs() {
		 DemoQAHomePage homePage = PageFactory.initElements(myDriver, DemoQAHomePage.class);     
		 assertEquals("http://demoqa.com/",myDriver.getCurrentUrl());
		 homePage.tabsNavClick();
	}
	
//	@Ignore
//	public void testNavigationToTooltip() {
//		 DemoQAHomePage homePage = PageFactory.initElements(myDriver, DemoQAHomePage.class);     
//		 assertEquals("http://demoqa.com/",myDriver.getCurrentUrl());
//		 homePage.tooltipNavClick();
//	}
	
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
