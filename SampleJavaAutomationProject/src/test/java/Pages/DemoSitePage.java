package Pages;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DemoSitePage {

	@FindBy(name="username")
	public WebElement usernameTextField;
	
	@FindBy(name="password")
	public WebElement passwordTextField;
	
	
	@FindBy(xpath="/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")
	public WebElement addAUserButton;
	
	@FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")
	public WebElement saveButton;
	
	@FindBy(css="p > input[type=\"button\"]")
	public WebElement loginButton;
	
	@FindBy(xpath="/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
	public WebElement loginNavButton;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
	public WebElement successLoginText;
	
	
	public void addUserButtonClick() {
		addAUserButton.click();	
	}
	
	public void loginUserButtonClick() {
		loginNavButton.click();	
	}
	
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
	
	public void clickLogin() {
		loginButton.click();	
	}
	
	public String getSuccessfulLoginText() {
		return successLoginText.getText();
	}
	
}
