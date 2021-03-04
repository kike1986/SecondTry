package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartBankWirePaage {
	WebDriver driver;
	
	public CartBankWirePaage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="span[class=\"navigation_page\"]")
	WebElement bankWireMenu;
	
	@FindBy(css="button[class=\"button btn btn-default button-medium\"]")
	WebElement confirmButton;
	
	public boolean validateIsOnBankWirePage() {
		return bankWireMenu.isDisplayed();
	}
	
	public void clickConfirmButton() {
		confirmButton.click();
	}
}
