package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomeShopPagePF {
	WebDriver driver;
	
	@FindBy(css="a[class=\"blockbestsellers\"]")
	//@FindBy(css="a[class=\"homefeatured\"]")
	WebElement link_to_open;
	//"columns"
	//div[id="center_column"]
	
	@FindBy(css="ul[id=\"blockbestsellers\"] :nth-child(7)")
	WebElement link_ultimo_resultado;
	
		
	public HomeShopPagePF(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this); //30 segundo de espera
	}
	
	public void clicBestSellers() {
		link_to_open.click();
	}
	public void clicLastResult() {
		link_ultimo_resultado.click();
	}

}
