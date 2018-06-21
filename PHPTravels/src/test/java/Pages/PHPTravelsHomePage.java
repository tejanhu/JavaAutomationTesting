package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PHPTravelsHomePage {

	@FindBy(className="select2-input")
	public WebElement hotelOrigin;
	
	@FindBy(className="form-control input-lg dpd1")
	public WebElement dateFrom;
	
	@FindBy(css="body > div:nth-child(13) > div.datepicker-days > table > tbody > tr:nth-child(4) > td.day.active")
	public WebElement dateFromPicked;
	
	@FindBy(className="form-control input-lg dpd2")
	public WebElement dateTo;
	
	@FindBy(css="body > div:nth-child(14) > div.datepicker-days > table > tbody > tr:nth-child(4) > td.day.active")
	public WebElement dateToPicked;
		
	@FindBy(css="#HOTELS > form > div.col-md-2.form-group.go-right.col-xs-12.search-button > button")
	public WebElement searchButton;
	
	public void clickHotelOriginTextField(ChromeDriver myWebDriver) {
		Actions action = new Actions(myWebDriver);
		action.moveByOffset(595, 280).click().perform();
//		hotelOrigin.click();
	}
		
	public void enterHotelOrigin(ChromeDriver myWebDriver) {
		Actions action = new Actions(myWebDriver);
		action.sendKeys("London").perform();
		action.sendKeys(Keys.TAB).perform();
	}
	
	public String verifyHotelIsInLondon() {
		return hotelOrigin.getAttribute("value");
	}
	

	
}
