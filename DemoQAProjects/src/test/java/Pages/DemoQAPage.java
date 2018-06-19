package Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQAPage {

	@FindBy(xpath="//*[@id=\"menu-item-141\"]")
	private WebElement droppableButton;
	
	public void click() {
		droppableButton.click();
		
	}
}
