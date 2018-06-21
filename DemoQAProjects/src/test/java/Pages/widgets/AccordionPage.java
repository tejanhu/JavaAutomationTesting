package Pages.widgets;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccordionPage {
	
	@FindBy(css="#ui-id-4 > span")
	private WebElement collapseBar;
	
	@FindBy(css="#ui-id-5 > p")
	private WebElement paragraphText;
	
	public void collapse() {
		collapseBar.click();
	}
	
	public boolean isParagraphTextPresent() {
		return paragraphText.isDisplayed();
	}

}
