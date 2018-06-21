package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoSiteHomePage {
	
	@FindBy(xpath="/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")
	public WebElement addAUserNavButton;
		
	@FindBy(xpath="/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
	public WebElement loginNavButton;
	
	public void addUserButtonClick() {
		addAUserNavButton.click();	
	}
	
	public void loginUserButtonClick() {
		loginNavButton.click();	
	}
	
}
