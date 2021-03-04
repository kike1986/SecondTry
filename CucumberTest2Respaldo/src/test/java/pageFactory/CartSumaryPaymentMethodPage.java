package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartSumaryPaymentMethodPage {
WebDriver driver;
	
	public CartSumaryPaymentMethodPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="span[class=\"navigation_page\"]")
	WebElement paymentMenu;
	
	@FindBy(css="a[class=\"bankwire\"]")
	WebElement linkPayByBank;
	
	public void clickOnPayByBank() {
		linkPayByBank.click();
	}
	
	public boolean validateIsOnPaymentPage() {
		return paymentMenu.isDisplayed();
	}
}
