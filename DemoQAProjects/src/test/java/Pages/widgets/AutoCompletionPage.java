package Pages.widgets;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutoCompletionPage {
	
	@FindBy(id="tagss")
	private WebElement tagTextField;
	
	@FindBy(xpath="//*[@id=\"ui-id-7\"]")
	private WebElement listItem;
	
	public void tagClick() {
		tagTextField.click();	
	}
	
	public void enterSomething() {
		tagTextField.sendKeys("a");
	}
	
	public boolean isListItem1Present() {
		return listItem.getText().equals("ActionScript");
	}
}
