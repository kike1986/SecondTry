package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartSumaryAddressPage {
WebDriver driver;
	
	@FindBy(css="a[class=\"logout\"]")
	WebElement logOutMenu;
	
	@FindBy(name="processAddress")
	WebElement proceddButton;

	public CartSumaryAddressPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateIsLogIn() {
		return logOutMenu.isDisplayed();
	}
	public void proceddTocheckOut() {
		proceddButton.click();
	}
}
