package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartSumaryShippingPage {
	
WebDriver driver;
	
	@FindBy(css="input[id=\"cgv\"]")
	WebElement checkTermsOfService;
	
	@FindBy(css="span[class=\"navigation_page\"]")
	WebElement shippingMenu;
	
	@FindBy(css="button[name=\"processCarrier\"]")
	WebElement buttonProced;

	public CartSumaryShippingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void checkingTermsOfServiceAndProced() {
		checkTermsOfService.click();
		buttonProced.click();
	}
	
	public boolean validateIsOnShipping() {
		return shippingMenu.isDisplayed();
	}

}
