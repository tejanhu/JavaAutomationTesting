package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.AddUserPage;
import Pages.DemoSiteHomePage;
import Pages.LoginPage;

public class DDT {
	
	ChromeDriver myDriver;
	static ExtentReports extent;
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		extent= new ExtentReports("C:\\Users\\Admin\\Desktop\\demoSiteDDTExtentReport.html", true);
	}
	
	@Before
	public void setUp() {
		myDriver = new ChromeDriver();
	}
	
	@Test
	public void createUserDDT() {
		myDriver.manage().window().maximize();
		myDriver.navigate().to("http://thedemosite.co.uk/index.php");
		DemoSiteHomePage dsHomePage = PageFactory.initElements(myDriver, DemoSiteHomePage.class);
		
		dsHomePage.addUserButtonClick();
		
		AddUserPage addUserPage = PageFactory.initElements(myDriver, AddUserPage.class);
		
		FileInputStream file = null;
		try {
			file = new FileInputStream("C:\\Users\\Admin\\Desktop\\DemoSiteMainTestData.xlsx");
		}
		catch(FileNotFoundException fne) {}
			XSSFWorkbook wb = null;
		try {
				wb = new XSSFWorkbook(file);
		}
		catch(IOException ioe) {}
		
		ArrayList <XSSFCell>usernamesList = new ArrayList<XSSFCell>();
		ArrayList <XSSFCell>passwordsList = new ArrayList<XSSFCell>();
		
		XSSFSheet sheet = wb.getSheetAt(0);
		for(int i=1; i<7;i++) {
			XSSFCell cell1 = sheet.getRow(i).getCell(0);
			usernamesList.add(cell1);
			XSSFCell cell2 = sheet.getRow(i).getCell(1);
			passwordsList.add(cell2);
		}
		
		for(int i=0;i<6;i++) {
			addUserPage.enterUername();
			addUserPage.enterPassword();
			addUserPage.clickSave();
			
			assertEquals("The username: " + usernamesList.get(i).getStringCellValue() + "\nThe password: " + passwordsList.get(i).getStringCellValue(), addUserPage.identifyElement().getText());

		}
		
		
		ExtentTest testName = extent.startTest("Create user");
		try {
			testName.log(LogStatus.PASS, "Successfull, all green!");
		}catch(AssertionError e) {
			testName.log(LogStatus.FAIL, "Error, Something broke so fix it!");
			
			fail();
		}finally {
			testName.log(LogStatus.INFO, "Current URL: " + myDriver.getCurrentUrl());
		extent.endTest(testName);
		}
	}
	
	
	
	@Test
	public void logUserDDT() {
		myDriver.manage().window().maximize();
		myDriver.navigate().to("http://thedemosite.co.uk/index.php");
		DemoSiteHomePage dsHomePage = PageFactory.initElements(myDriver, DemoSiteHomePage.class);
		AddUserPage addUserPage = PageFactory.initElements(myDriver, AddUserPage.class);
		dsHomePage.loginNavButton.click();
		
		FileInputStream file = null;
		try {
			file = new FileInputStream("C:\\Users\\Admin\\Desktop\\DemoSiteMainTestData.xlsx");
		}
		catch(FileNotFoundException fne) {}
			XSSFWorkbook wb = null;
		try {
				wb = new XSSFWorkbook(file);
		}
		catch(IOException ioe) {}
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFCell cell = sheet.getRow(0).getCell(0);
		System.out.println(cell.getStringCellValue());
		
		ArrayList <XSSFCell>usernamesList = new ArrayList<XSSFCell>();
		ArrayList <XSSFCell>passwordsList = new ArrayList<XSSFCell>();
		
		XSSFSheet sheet = wb.getSheetAt(0);
		for(int i=1; i<7;i++) {
			XSSFCell cell1 = sheet.getRow(i).getCell(0);
			usernamesList.add(cell1);
			XSSFCell cell2 = sheet.getRow(i).getCell(1);
			passwordsList.add(cell2);
		}
		LoginPage loginPage = PageFactory.initElements(myDriver, LoginPage.class);
		
		for(int i=0;i<6;i++) {
			addUserPage.enterUername();
			addUserPage.enterPassword();
			addUserPage.clickSave();
			
			
			loginPage.enterUername();
			loginPage.enterPassword();
			loginPage.clickLogin();
			
			assertEquals("**Successful Login**",loginPage.getSuccessfulLoginText());
			if(i<5) {
				dsHomePage.addUserButtonClick();
			}
		}
		
		
		
		
		ExtentTest testName = extent.startTest("Log user");
		try {
			testName.log(LogStatus.PASS, "Successfull, all green!");
		}catch(AssertionError e) {
			testName.log(LogStatus.FAIL, "Error, Something broke so fix it!");
			
			fail();
		}finally {
			testName.log(LogStatus.INFO, "Current URL: " + myDriver.getCurrentUrl());
		extent.endTest(testName);
		}
		
	}
	

}
