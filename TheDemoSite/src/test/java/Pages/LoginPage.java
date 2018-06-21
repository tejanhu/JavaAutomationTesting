package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(name="username")
	public WebElement usernameTextField;
	
	@FindBy(name="password")
	public WebElement passwordTextField;
	
	@FindBy(css="p > input[type=\"button\"]")
	public WebElement loginButton;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
	public WebElement successLoginText;
	
		
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
	
	
	public void clickLogin() {
		loginButton.click();	
	}
	
	public String getSuccessfulLoginText() {
		return successLoginText.getText();
	}
	
}
