package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticePage {

	@FindBy(id="search_query_top")
	public WebElement searchTextField;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/h1/span[2]")
	public WebElement resultsShown;
	
	
	@FindBy(css="#searchbox > button")
	public WebElement searchButton;
	
	
	public void serachDress() {
		searchTextField.click();
		searchTextField.sendKeys("Dress");
		searchButton.click();
		
	}
	
	public String getResults() {
		return resultsShown.getText();	
	}

	
}
