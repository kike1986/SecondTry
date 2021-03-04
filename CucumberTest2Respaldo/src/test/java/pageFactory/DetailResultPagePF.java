package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetailResultPagePF {
	WebDriver driver;

	@FindBy(css="div[class=\"pb-center-column col-xs-12 col-sm-4\"] :first-child")
	WebElement mensajePantalla;
	
	@FindBy(css="a[class=\"btn btn-default button-plus product_quantity_up\"]")
	WebElement cantidadMas;
	
	@FindBy(id="group_1")
	WebElement selectTalla; //L
	
	@FindBy(css="button[name=\"Submit\"]")
	WebElement addToCartButton;
	
	@FindBy(css="div[class=\"layer_cart_cart col-xs-12 col-md-6\"]")
	WebElement divCart;
	
	@FindBy(css="a[class=\"btn btn-default button button-medium\"]")
	WebElement procedButton;
	
	public DetailResultPagePF(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this); //30 segundo de espera
	}
	
	public boolean productDetailIsDisplayed() {
		System.out.println("Mensaje en pantalla: "+mensajePantalla.getText());
		return mensajePantalla.isDisplayed();
	}
	
	public void anadirCantidad(int catidadClicks) {
		for (int i = 0; i < catidadClicks; i++) {
			cantidadMas.click();	
		}
	}
	public void seleccionarTalla(String size) {
		Select select = new Select(selectTalla);
		select.selectByVisibleText(size);
	}
	public void clicAddToCart() {
		System.out.println("Cantidad de ventanas avbertas: "+driver.getWindowHandles().size());
		addToCartButton.click();
	}
	
	public void clicProcedCheckOut() {
		WebDriverWait wait = new WebDriverWait(driver, 7);
		wait.until(ExpectedConditions.elementToBeClickable(procedButton));
		procedButton.click();
	}
}
