package Pages.widgets;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DatePickerPage {
	
	@FindBy(xpath="//*[@id=\"datepicker1\"]")
	private WebElement dateBox;
	
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")
	private WebElement nextButton;
	
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[5]/a")
	private WebElement date;
	
	public void clickNext() {
		nextButton.click();
	}
	
	public void selectDay() {
		date.click();
	}
	
	public void clickDateBox() {
		dateBox.click();
	}
	
	public boolean verifyDate() {
		return dateBox.getText().contains(date.getText());
	}

}
