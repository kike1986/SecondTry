package pageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CartSumaryPage {
	WebDriver driver;
	
	@FindBy(id="cart_title")
	WebElement cartSumaryTitle;
	
	@FindBy(css="a[class=\"button btn btn-default standard-checkout button-medium\"]")
	WebElement procedCheckOutButton;

	public CartSumaryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this); //30 segundo de espera
	}
	
	public boolean cartSumaryTitleIsDisplayed() {
		System.out.println("EL titulo de la pagina es: "+cartSumaryTitle.getText());
		return cartSumaryTitle.isDisplayed();
	}
	
	public void clicToProced() {
		procedCheckOutButton.click();
	}

}
