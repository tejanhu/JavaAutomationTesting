package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQAHomePage {

	@FindBy(xpath="//*[@id=\"menu-item-141\"]")
	private WebElement droppableNavbarButton;
	
	
	@FindBy(xpath="//*[@id=\"menu-item-142\"]/a")
	private WebElement selectableNavbarButton;
	
	@FindBy(id="selectable")
	public WebElement widgetObj;
	
	@FindBy(css="#menu-item-144 > a")
	private WebElement accordionNavbarButton;
	
	
	@FindBy(css="#menu-item-145 > a")
	private WebElement autocompleteNavbarButton;
	
	@FindBy(xpath="//*[@id=\"ui-id-1\"]")
	private WebElement unorderedList;
	
	
	@FindBy(xpath="//*[@id=\"menu-item-146\"]/a")
	private WebElement datePickerNavbarButton;
	
	
	@FindBy(css="#menu-item-98 > a")
	private WebElement tabsNavbarButton;
	
	public void droppableNavClick() {
		droppableNavbarButton.click();	
	}
	
	public void selectableNavClick() {
		selectableNavbarButton.click();	
	}
	
	public void accordionNavClick() {
		accordionNavbarButton.click();	
	}
	
	public void autocompleteNavClick(){
		autocompleteNavbarButton.click();
	}
	
	public void datePickerNavClick() {
		datePickerNavbarButton.click();
	}
	
	public void tabsNavClick () {
		tabsNavbarButton.click();
	}
		

 
}
