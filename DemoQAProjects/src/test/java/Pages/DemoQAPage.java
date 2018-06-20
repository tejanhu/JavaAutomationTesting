package Pages;

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
	public WebElement widgetObj;
	
	@FindBy(css="#menu-item-144 > a")
	private WebElement accordionButton;
	
	@FindBy(css="#ui-id-4 > span")
	private WebElement collapseBar;
	
	@FindBy(css="#ui-id-5 > p")
	private WebElement paragraphText;
	
	@FindBy(id="tagss")
	private WebElement tagTextField;
	
	@FindBy(css="#menu-item-145 > a")
	private WebElement autocompleteButton;
	
	@FindBy(xpath="//*[@id=\"ui-id-1\"]")
	private WebElement unorderedList;
	
	@FindBy(xpath="//*[@id=\"ui-id-7\"]")
	private WebElement listItem;
	
	
	public void droppableClick() {
		droppableButton.click();	
	}
	
	public void selectableClick() {
		selectableButton.click();	
	}
	
	public void accordionClick() {
		accordionButton.click();	
	}
	
	public void autocompleteClick(){
		autocompleteButton.click();
	}
		
	public void drop(WebDriver myWebdriver) {
		Actions action = new Actions(myWebdriver);
		action.moveToElement(droppableObj).clickAndHold().moveByOffset(200, 20).release().perform();;	
	}
	
	public void select(WebDriver myWebdriver) {
		widgetObj.click();
	}
	
	public void collapse() {
		collapseBar.click();
	}
	
	public boolean isParagraphTextPresent() {
		return paragraphText.isDisplayed();
	}
	
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
