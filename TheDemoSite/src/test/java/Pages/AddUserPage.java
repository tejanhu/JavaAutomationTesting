package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserPage {

	@FindBy(name="username")
	public WebElement usernameTextField;
	
	@FindBy(name="password")
	public WebElement passwordTextField;
	
	@FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")
	public WebElement saveButton;
	
	@FindBy(css="body > table > tbody > tr > td.auto-style1 > blockquote > blockquote:nth-child(2) > blockquote")
	private WebElement elementIdentifier;

	public void clickUsernameTextField() {
		usernameTextField.click();
	}
	
	public void enterUername() {
		usernameTextField.sendKeys("user123");
	}
	
	public void clickPasswordTextField() {
		passwordTextField.click();
	}
	
	public void enterPassword() {
		passwordTextField.sendKeys("password123");
	}
	
	public void clickSave() {
		saveButton.click();	
	}
	
	public WebElement identifyElement() {
		return elementIdentifier;
	}

}
