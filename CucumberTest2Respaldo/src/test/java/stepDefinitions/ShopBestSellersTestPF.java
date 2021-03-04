package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageFactory.*;

public class ShopBestSellersTestPF {
	WebDriver 						driver;
	HomeShopPagePF					homePage;
	DetailResultPagePF 				resultPage;
	CartSumaryPage 					sumaryPage;
	SignInPage 						signInPage;
	CartSumaryAddressPage 			cartAddressPage;
	CartSumaryShippingPage 			cartShippingPage;
	CartSumaryPaymentMethodPage 	cartPayMethod;
	CartBankWirePaage				cartBankWirePage;
	OrderConfirmationPage			ordConfirmPage;

	@Given("El usuario esta en la pagina home")
	public void el_usuario_esta_en_la_pagina_home() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver 				= new ChromeDriver();
		resultPage 			= new DetailResultPagePF(driver);
		homePage 			= new HomeShopPagePF(driver);
		sumaryPage 			= new CartSumaryPage(driver);
		signInPage 			= new SignInPage(driver);
		cartAddressPage 	= new CartSumaryAddressPage(driver);
		cartShippingPage 	= new CartSumaryShippingPage(driver);
		cartPayMethod 		= new CartSumaryPaymentMethodPage(driver);
		cartBankWirePage	= new CartBankWirePaage(driver);
		ordConfirmPage		= new OrderConfirmationPage(driver);
		 driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");

	}

	@And("da clic en BEST SELLERS")
	public void da_clic_en_BEST_SELLERS() {

		homePage.clicBestSellers();
	}

	@And("da clic el ultimo resultado")
	public void da_clic_el_ultimo_resultado() {

		homePage.clicLastResult();
	}

	@Then("se muestra la informacion del Printed Dress")
	public void se_muestra_la_informacion_del_Printed_Dress() {
		System.out.println("Resulto Page:--------- " + resultPage.productDetailIsDisplayed());
	}

	@And("da clic en simbolo mas para subir Quantity a {int}")
	public void da_clic_en_simbolo_mas_para_subir_Quantity_a(Integer int1) {
		resultPage.anadirCantidad(int1);
	}

	@And("selecciona talla {string}")
	public void selecciona_talla(String talla) {

		resultPage.seleccionarTalla(talla);
	}

	@And("clic en Add to cart y clic en Proceed to checkout")
	public void clic_en_Add_to_cart_y_clic_en_Proceed_to_checkout() {

		resultPage.clicAddToCart();
		resultPage.clicProcedCheckOut();

	}

	@Then("se muestra el resumen de la compra")
	public void se_muestra_el_resumen_de_la_compra() {
		sumaryPage.cartSumaryTitleIsDisplayed();
		sumaryPage.clicToProced();
	}

	@And("se muestra la pagina de Authentication")
	public void se_muestra_la_pagina_de_Authentication() {
		System.out
				.println("Estamos en la pagina de autenticación? : " + signInPage.verifyAutenticationPageIsDisplayed());
	}

	@And("el usuario se logea con {string} y {string}")
	public void el_usuario_se_logea_con_y(String user, String password) {
		signInPage.logIn(user, password);
	}

	@And("el usuario esta logeado y se confirman las direcciones de envio y facturacion dando clic en proceed")
	public void el_usuario_esta_logeado_y_se_confirman_las_direcciones_de_envio_y_facturacion_dando_clic_en_proceed() {
		System.out.println("Esta logeado : " + cartAddressPage.validateIsLogIn());
		cartAddressPage.proceddTocheckOut();
	}

	@Then("se muestra detalle del envio")
	public void se_muestra_detalle_del_envio() {
		System.out.println("Esta en la pagina de shipping: " + cartShippingPage.validateIsOnShipping());
	}

	@And("el usuario confirma los terminos de servicio")
	public void el_usuario_confirma_los_terminos_de_servicio() {
		cartShippingPage.checkingTermsOfServiceAndProced();
	}

	@And("el usuario paga por bankwire haciendo clien en la opcion")
	public void el_usuario_paga_por_bankwire_haciendo_clien_en_la_opcion() {
		System.out.println("Estamos en la pagina de metodo de pago "+cartPayMethod.validateIsOnPaymentPage());
		cartPayMethod.clickOnPayByBank();
	}

	@Then("se muestra la pagina de detalle de bank wire")
	public void se_muestra_la_pagina_de_detalle_de_bank_wire() {
		System.out.println("Esta en la pafina de BankWire: "+cartBankWirePage.validateIsOnBankWirePage());
	}

	@And("el usuario confirma la orden")
	public void el_usuario_confirma_la_orden() {
		cartBankWirePage.clickConfirmButton();

	}

	@Then("se muestra la pagina de Order Confirmation")
	public void se_muestra_la_pagina_de_Order_Confirmation() {
		System.out.println("Esta en la pagina de confirmacion de la orden:---->  "+ordConfirmPage.validateIsOnOrderConfirmationPage());
		driver.close();
		driver.quit();
	}

}
