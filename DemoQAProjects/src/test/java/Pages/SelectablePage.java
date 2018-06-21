package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectablePage {

	@FindBy(id="selectable")
	public WebElement widgetObj;
	
	public void select(WebDriver myWebdriver) {
		widgetObj.click();
	}
}
