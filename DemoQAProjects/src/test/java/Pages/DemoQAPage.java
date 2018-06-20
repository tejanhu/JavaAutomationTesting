package Pages;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DemoQAPage {

	@FindBy(xpath="//*[@id=\"menu-item-141\"]")
	private WebElement droppableButton;
	
	@FindBy(xpath="//*[@id=\"draggableview\"]")
	private WebElement droppableObj;
	
	
	@FindBy(xpath="//*[@id=\"menu-item-142\"]/a")
	private WebElement selectableButton;
	
	@FindBy(id="selectable")
	public WebElement widgetSelectable;
	
	
	public void droppableClick() {
		droppableButton.click();	
	}
	
	public void selectableClick() {
		selectableButton.click();	
	}
	
	public void drop(WebDriver myWebdriver) {
		Actions action = new Actions(myWebdriver);
		action.moveToElement(droppableObj).clickAndHold().moveByOffset(200, 20).release().perform();;	
	}
	
	public void select(WebDriver myWebdriver) {
		widgetSelectable.click();
		//change this
//		 assertEquals(widgetSelectable.isSelected(),myWebdriver.findElement(By.id("selectable")).isSelected());	
	}
}
