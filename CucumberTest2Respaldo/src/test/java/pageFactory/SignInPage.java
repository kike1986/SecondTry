package pageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SignInPage {
WebDriver driver;
	
	@FindBy(id="email")
	WebElement email_box;
	
	@FindBy(id="passwd")
	WebElement password_box;
	
	@FindBy(id="SubmitLogin")
	WebElement sigIn_Button;
	
	@FindBy(css="span[class=\"navigation_page\"]")
	WebElement menuAthentication;
	
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void logIn(String user, String password) {
		email_box.sendKeys(user);
		password_box.sendKeys(password);
		sigIn_Button.click();
		
	}
	
	public boolean verifyAutenticationPageIsDisplayed() {
		return menuAthentication.isDisplayed();
	}
}
