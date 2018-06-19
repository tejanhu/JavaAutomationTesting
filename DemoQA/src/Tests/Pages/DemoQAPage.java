import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQAPage {

	@FindBy(xpath="//*[@id=\"menu-item-140\"]/a")
	private WebElement draggableButton;
	
	public void click() {
		draggableButton.click();
	}
}
