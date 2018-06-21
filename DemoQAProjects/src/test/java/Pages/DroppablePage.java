package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DroppablePage {
	
	@FindBy(xpath="//*[@id=\"draggableview\"]")
	private WebElement droppableObj;
	
	
	public void drop(WebDriver myWebdriver) {
		Actions action = new Actions(myWebdriver);
		action.moveToElement(droppableObj).clickAndHold().moveByOffset(200, 20).release().perform();;	
	}

}
